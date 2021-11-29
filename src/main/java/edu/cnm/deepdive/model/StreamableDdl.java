package edu.cnm.deepdive.model;

import java.util.stream.Stream;

public interface StreamableDdl {

  Stream<String> streamDdl();

}
