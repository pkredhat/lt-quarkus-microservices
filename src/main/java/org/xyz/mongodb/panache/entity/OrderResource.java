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

@Path("/api/orders")
@Consumes("application/json")
@Produces("application/json")
public class OrderResource {

    @GET
    public List<Order> list() {
        return Order.listAll();
    }

    @GET
    @Path("/{id}")
    public Order get(String id) {
        return Order.findById(new ObjectId(id));
    }

    @POST
    public Response create(Order order) {
        order.persist();
        return Response.status(201).build();
    }

    @PUT
    @Path("/{id}")
    public void update(String id, Order order) {
        order.update();
    }

    @DELETE
    @Path("/{id}")
    public void delete(String id) {
        Order order = Order.findById(new ObjectId(id));
        order.delete();
    }

    @GET
    @Path("/search/{name}")
    public Order search(String name) {
        return Order.findByName(name);
    }

    @DELETE
    public void deleteAll(){
        Order.deleteAll();
    }

}
