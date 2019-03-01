/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.accumulo.core.tabletserver.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)")
public class TooManyFilesException extends org.apache.thrift.TException implements org.apache.thrift.TBase<TooManyFilesException, TooManyFilesException._Fields>, java.io.Serializable, Cloneable, Comparable<TooManyFilesException> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TooManyFilesException");

  private static final org.apache.thrift.protocol.TField EXTENT_FIELD_DESC = new org.apache.thrift.protocol.TField("extent", org.apache.thrift.protocol.TType.STRUCT, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TooManyFilesExceptionStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TooManyFilesExceptionTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable org.apache.accumulo.core.dataImpl.thrift.TKeyExtent extent; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    EXTENT((short)1, "extent");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // EXTENT
          return EXTENT;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.EXTENT, new org.apache.thrift.meta_data.FieldMetaData("extent", org.apache.thrift.TFieldRequirementType.DEFAULT, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, org.apache.accumulo.core.dataImpl.thrift.TKeyExtent.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TooManyFilesException.class, metaDataMap);
  }

  public TooManyFilesException() {
  }

  public TooManyFilesException(
    org.apache.accumulo.core.dataImpl.thrift.TKeyExtent extent)
  {
    this();
    this.extent = extent;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TooManyFilesException(TooManyFilesException other) {
    if (other.isSetExtent()) {
      this.extent = new org.apache.accumulo.core.dataImpl.thrift.TKeyExtent(other.extent);
    }
  }

  public TooManyFilesException deepCopy() {
    return new TooManyFilesException(this);
  }

  @Override
  public void clear() {
    this.extent = null;
  }

  @org.apache.thrift.annotation.Nullable
  public org.apache.accumulo.core.dataImpl.thrift.TKeyExtent getExtent() {
    return this.extent;
  }

  public TooManyFilesException setExtent(@org.apache.thrift.annotation.Nullable org.apache.accumulo.core.dataImpl.thrift.TKeyExtent extent) {
    this.extent = extent;
    return this;
  }

  public void unsetExtent() {
    this.extent = null;
  }

  /** Returns true if field extent is set (has been assigned a value) and false otherwise */
  public boolean isSetExtent() {
    return this.extent != null;
  }

  public void setExtentIsSet(boolean value) {
    if (!value) {
      this.extent = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case EXTENT:
      if (value == null) {
        unsetExtent();
      } else {
        setExtent((org.apache.accumulo.core.dataImpl.thrift.TKeyExtent)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case EXTENT:
      return getExtent();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case EXTENT:
      return isSetExtent();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TooManyFilesException)
      return this.equals((TooManyFilesException)that);
    return false;
  }

  public boolean equals(TooManyFilesException that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_extent = true && this.isSetExtent();
    boolean that_present_extent = true && that.isSetExtent();
    if (this_present_extent || that_present_extent) {
      if (!(this_present_extent && that_present_extent))
        return false;
      if (!this.extent.equals(that.extent))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetExtent()) ? 131071 : 524287);
    if (isSetExtent())
      hashCode = hashCode * 8191 + extent.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TooManyFilesException other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetExtent()).compareTo(other.isSetExtent());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExtent()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.extent, other.extent);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TooManyFilesException(");
    boolean first = true;

    sb.append("extent:");
    if (this.extent == null) {
      sb.append("null");
    } else {
      sb.append(this.extent);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
    if (extent != null) {
      extent.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TooManyFilesExceptionStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TooManyFilesExceptionStandardScheme getScheme() {
      return new TooManyFilesExceptionStandardScheme();
    }
  }

  private static class TooManyFilesExceptionStandardScheme extends org.apache.thrift.scheme.StandardScheme<TooManyFilesException> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TooManyFilesException struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // EXTENT
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.extent = new org.apache.accumulo.core.dataImpl.thrift.TKeyExtent();
              struct.extent.read(iprot);
              struct.setExtentIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TooManyFilesException struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.extent != null) {
        oprot.writeFieldBegin(EXTENT_FIELD_DESC);
        struct.extent.write(oprot);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TooManyFilesExceptionTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TooManyFilesExceptionTupleScheme getScheme() {
      return new TooManyFilesExceptionTupleScheme();
    }
  }

  private static class TooManyFilesExceptionTupleScheme extends org.apache.thrift.scheme.TupleScheme<TooManyFilesException> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TooManyFilesException struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetExtent()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetExtent()) {
        struct.extent.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TooManyFilesException struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.extent = new org.apache.accumulo.core.dataImpl.thrift.TKeyExtent();
        struct.extent.read(iprot);
        struct.setExtentIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
  private static void unusedMethod() {}
}

