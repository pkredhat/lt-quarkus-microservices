package org.xyz.mongodb.panache.entity;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;

import org.bson.types.ObjectId;

@Path("/api/customer")
@Consumes("application/json")
@Produces("application/json")
public class CustomerResource {

    @GET
    public List<Customer> list() {
        return Customer.listAll();
    }

    @GET
    @Path("/{id}")
    public Customer get(String id) {
        return Customer.findById(new ObjectId(id));
    }

    @POST
    public Response create(Customer customer) {
        customer.persist();
        return Response.status(201).build();
    }

    @PUT
    @Path("/{id}")
    public void update(String id, Customer customer) {
        System.out.println("ID PUT : " + id);
        customer.update();
    }

    @DELETE
    @Path("/{id}")
    public void delete(String id) {
        Customer customer = Customer.findById(new ObjectId(id));
        customer.delete();
    }

    @GET
    @Path("/search/{name}")
    public Customer search(String firstName) {
        return Customer.findByName(firstName);
    }

    @DELETE
    public void deleteAll(){
        Customer.deleteAll();
    }

}
