package org.xyz.mongodb.panache.entity;

import java.time.LocalDate;
import org.bson.codecs.pojo.annotations.BsonProperty;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "Orders")
public class Order extends PanacheMongoEntity {
    
    @BsonProperty("orderName")      // will be persisted as a 'firstName' field in MongoDB
    public String name;
    public LocalDate createdDate;
    public int productId;
    public int customerId;
    public float orderTotal;


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
    public static Order findByName(String name) {
        return find("name", name).firstResult();
    }
}
