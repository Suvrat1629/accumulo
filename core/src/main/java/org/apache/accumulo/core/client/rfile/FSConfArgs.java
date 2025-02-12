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
package org.apache.accumulo.core.client.rfile;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

class FSConfArgs {

  FileSystem fs;
  Configuration conf;

  FileSystem getFileSystem(Path path) throws IOException {
    if (fs == null) {
      return path.getFileSystem(getConf());
    }
    return fs;
  }

  FileSystem getFileSystem() throws IOException {
    if (fs == null) {
      return FileSystem.get(getConf());
    }
    return fs;
  }

  Configuration getConf() throws IOException {
    if (fs != null) {
      return fs.getConf();
    }

    if (conf == null) {
      conf = new Configuration();
    }
    return conf;
  }
}
