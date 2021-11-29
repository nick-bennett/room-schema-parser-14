package edu.cnm.deepdive.model;

import com.google.gson.annotations.Expose;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class Database implements StreamableDdl {

  @Expose
  private List<Entity> entities = new LinkedList<>();

  @Expose
  private List<View> views = new LinkedList<>();

  public List<Entity> getEntities() {
    return entities;
  }

  public void setEntities(List<Entity> entities) {
    this.entities = entities;
  }

  public List<View> getViews() {
    return views;
  }

  public void setViews(List<View> views) {
    this.views = views;
  }

  @Override
  public Stream<String> streamDdl() {
    return Stream
        .concat(
            entities.stream(),
            views.stream()
        )
        .flatMap(StreamableDdl::streamDdl);
  }

}
