package com.orientechnologies.orient.distributed.impl.structural.operations;

import com.orientechnologies.orient.distributed.impl.coordinator.OCoordinateMessagesFactory;
import com.orientechnologies.orient.distributed.impl.coordinator.transaction.OSessionOperationId;
import com.orientechnologies.orient.distributed.impl.structural.OStructuralSubmitRequest;
import com.orientechnologies.orient.distributed.impl.structural.raft.OMasterContext;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ODropDatabaseSubmitRequest implements OStructuralSubmitRequest {
  private String database;

  public ODropDatabaseSubmitRequest(String database) {
    this.database = database;
  }

  public ODropDatabaseSubmitRequest() {
  }

  @Override
  public void begin(OSessionOperationId id, OMasterContext context) {

  }

  @Override
  public void serialize(DataOutput output) throws IOException {
    output.writeUTF(database);
  }

  @Override
  public void deserialize(DataInput input) throws IOException {
    database = input.readUTF();
  }

  @Override
  public int getRequestType() {
    return OCoordinateMessagesFactory.DROP_DATABASE_SUBMIT_REQUEST;
  }
}
