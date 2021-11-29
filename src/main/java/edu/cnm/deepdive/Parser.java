package edu.cnm.deepdive;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.cnm.deepdive.model.Schema;
import edu.cnm.deepdive.model.StreamableDdl;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Parser {

  private static final String TERMINATED_FORMAT = "%s;%n%n";

  public static void main(String[] args) throws IOException {
    Gson gson = new GsonBuilder()
        .excludeFieldsWithoutExposeAnnotation()
        .create();
    try (Reader reader = new InputStreamReader(System.in)) {
      StreamableDdl ddl = gson.fromJson(reader, Schema.class);
      ddl
          .streamDdl()
          .map(Parser::terminate)
          .forEach(System.out::print);
    }
  }

  private static String terminate(String statement) {
    return String.format(TERMINATED_FORMAT, statement);
  }

}
