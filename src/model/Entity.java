package model;

import java.util.List;

public class Entity {
    int id;

    public int getId() {
        return id;
    }

    String name;

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    List<String> tags;

    public Entity(int id, String name) {
        this.name = name;
        this.id = id;
    }


}
