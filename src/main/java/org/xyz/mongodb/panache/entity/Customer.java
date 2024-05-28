package org.xyz.mongodb.panache.entity;

import java.time.LocalDate;
//import java.util.List;

import org.bson.codecs.pojo.annotations.BsonProperty;
import io.quarkus.mongodb.panache.common.MongoEntity;
import io.quarkus.mongodb.panache.PanacheMongoEntity;

@MongoEntity(collection = "customers")
public class Customer extends PanacheMongoEntity {
    
    @BsonProperty("firstName")      // will be persisted as a 'firstName' field in MongoDB
    public String firstName;

    @BsonProperty("lastName")
    public String lastName;

    @BsonProperty("address")
    public String address;

    @BsonProperty("phoneNumber")
    public String phoneNumber;

    @BsonProperty("created")
    public LocalDate created;


    //--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
    // GETTERS AND SETTERS

    // return name as lowercase in the model
    public String getFirstName() {
        return firstName.toLowerCase();
    }

    // store all names in uppercase in the DB
    public void setFirstName(String firstName) {
        this.firstName = firstName.toUpperCase();
    }

    //--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*
    // entity methods
    public static Customer findByName(String firstName) {
        return find("firstName", firstName).firstResult();
    }

    public static Customer findByLastName(String lastName) {
        return find("lastName", lastName).firstResult();
    }
}
