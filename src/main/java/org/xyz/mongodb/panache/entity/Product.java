package org.xyz.mongodb.panache.entity;

import java.time.LocalDate;
//import java.util.List;

import org.bson.codecs.pojo.annotations.BsonProperty;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "Product")
public class Product extends PanacheMongoEntity {
    
    @BsonProperty("productName")      // will be persisted as a 'firstName' field in MongoDB
    public String name;

    @BsonProperty("ProductDescription")
    public String description;

    public String price;

    public LocalDate createdDate;


    //--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
    // GETTERS AND SETTERS

    // return name as lowercase in the model
    public String getName() {
        return name.toLowerCase();
    }

    // store all names in uppercase in the DB
    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    //--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
    // entity methods
    public static Product findByName(String name) {
        return find("name", name).firstResult();
    }
}
