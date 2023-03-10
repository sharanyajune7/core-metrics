package com.zaga.entity;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;

@MongoEntity(collection = "metr" , database = "metric")
public class Perrson extends PanacheMongoEntity {
    public String name;

    public String getName() {
        return name;
    }

    public Perrson(String name) {
        this.name = name;
    }
    public Perrson() {
        
    }
    public void setName(String name) {
        this.name = name;
    }
}
