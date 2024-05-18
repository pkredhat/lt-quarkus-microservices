package org.xyz.mongodb.panache.entity;

import java.time.LocalDate;
//import java.util.List;

import org.bson.codecs.pojo.annotations.BsonProperty;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "Customers")
public class Customer extends PanacheMongoEntity {
    
    @BsonProperty("firstName")      // will be persisted as a 'firstName' field in MongoDB
    public String name;

    @BsonProperty("lastName")
    public String surname;

    public String address;

    public String phoneNumber;

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
    public static Customer findByName(String name) {
        return find("name", name).firstResult();
    }

    public static Customer findByLastName(String surname) {
        return find("surname", surname).firstResult();
    }

    // public static List<Person> findAlive() {
    //     return list("status", Status.LIVING);
    // }

    // public static void deleteLoics() {
    //     delete("name", "Loïc");
    // }
}
