/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.accumulo.test.compaction;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.time.Duration;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

import org.apache.accumulo.compactor.Compactor;
import org.apache.accumulo.core.cli.ConfigOpts;
import org.apache.accumulo.core.compaction.thrift.TCompactionState;
import org.apache.accumulo.core.compaction.thrift.TCompactionStatusUpdate;
import org.apache.accumulo.core.dataImpl.KeyExtent;
import org.apache.accumulo.core.metadata.ReferencedTabletFile;
import org.apache.accumulo.core.metadata.schema.ExternalCompactionId;
import org.apache.accumulo.core.metadata.schema.TabletMetadata;
import org.apache.accumulo.core.metadata.schema.TabletMetadata.ColumnType;
import org.apache.accumulo.core.tabletserver.thrift.TExternalCompactionJob;
import org.apache.accumulo.core.util.UtilWaitThread;
import org.apache.accumulo.server.compaction.FileCompactor;
import org.apache.accumulo.server.compaction.FileCompactor.CompactionCanceledException;
import org.apache.accumulo.server.compaction.RetryableThriftCall.RetriesExceededException;
import org.apache.accumulo.server.tablets.TabletNameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExternalDoNothingCompactor extends Compactor {

  private static final Logger LOG = LoggerFactory.getLogger(ExternalDoNothingCompactor.class);

  ExternalDoNothingCompactor(ConfigOpts opts, String[] args) {
    super(opts, args);
  }

  @Override
  protected void startCancelChecker(ScheduledThreadPoolExecutor schedExecutor,
      long timeBetweenChecks) {
    @SuppressWarnings("unused")
    var future = schedExecutor.scheduleWithFixedDelay(this::checkIfCanceled, 0, 5000, MILLISECONDS);
  }

  @Override
  protected FileCompactorRunnable createCompactionJob(TExternalCompactionJob job,
      LongAdder totalInputEntries, LongAdder totalInputBytes, CountDownLatch started,
      CountDownLatch stopped, AtomicReference<Throwable> err) {

    // Set this to true so that only 1 external compaction is run
    final AtomicReference<FileCompactor> ref = new AtomicReference<>();
    gracefulShutdown(getContext().rpcCreds());

    return new FileCompactorRunnable() {

      @Override
      public AtomicReference<FileCompactor> getFileCompactor() {
        return ref;
      }

      @Override
      public Duration getCompactionAge() {
        return Duration.ZERO;
      }

      @Override
      public void run() {
        try {
          LOG.info("Starting up compaction runnable for job: {}", job);
          TCompactionStatusUpdate update = new TCompactionStatusUpdate();
          update.setState(TCompactionState.STARTED);
          update.setMessage("Compaction started");
          updateCompactionState(job, update);

          // Create tmp output file
          final TabletMetadata tm = getContext().getAmple()
              .readTablet(KeyExtent.fromThrift(job.getExtent()), ColumnType.DIR);
          ReferencedTabletFile newFile = TabletNameGenerator.getNextDataFilenameForMajc(
              job.isPropagateDeletes(), getContext(), tm.getExtent(), tm.getDirName(), (dir) -> {},
              ExternalCompactionId.from(job.getExternalCompactionId()));
          LOG.info("Creating tmp file: {}", newFile.getPath());
          getContext().getVolumeManager().createNewFile(newFile.getPath());

          LOG.info("Starting compactor");
          started.countDown();

          while (!JOB_HOLDER.isCancelled()) {
            LOG.info("Sleeping while job is not cancelled");
            UtilWaitThread.sleep(1000);
          }
          // Compactor throws this exception when cancelled
          throw new CompactionCanceledException();

        } catch (Exception e) {
          KeyExtent fromThriftExtent = KeyExtent.fromThrift(job.getExtent());
          LOG.error("Compaction failed: id: {}, extent: {}", job.getExternalCompactionId(),
              fromThriftExtent, e);
          err.set(e);
        } finally {
          stopped.countDown();
        }
      }

      @Override
      public void initialize() throws RetriesExceededException {
        // This isn't used, just need to create and return something
        ref.set(new FileCompactor(getContext(), KeyExtent.fromThrift(job.getExtent()), null, null,
            false, null, null, null, null, null));
      }

    };

  }

  public static void main(String[] args) throws Exception {
    try (var compactor = new ExternalDoNothingCompactor(new ConfigOpts(), args)) {
      compactor.runServer();
    }
  }

}
