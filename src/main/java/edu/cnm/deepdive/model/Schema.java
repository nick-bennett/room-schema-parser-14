package edu.cnm.deepdive.model;

import com.google.gson.annotations.Expose;
import java.util.stream.Stream;

public class Schema implements StreamableDdl {

  @Expose
  private Database database;

  public Database getDatabase() {
    return database;
  }

  public void setDatabase(Database database) {
    this.database = database;
  }

  @Override
  public Stream<String> streamDdl() {
    return database.streamDdl();
  }

}
