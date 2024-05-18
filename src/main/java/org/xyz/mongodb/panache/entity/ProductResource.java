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

@Path("/api/products")
@Consumes("application/json")
@Produces("application/json")
public class ProductResource {

    @GET
    public List<Product> list() {
        return Product.listAll();
    }

    @GET
    @Path("/{id}")
    public Product get(String id) {
        return Product.findById(new ObjectId(id));
    }

    @POST
    public Response create(Product product) {
        product.persist();
        return Response.status(201).build();
    }

    @PUT
    @Path("/{id}")
    public void update(String id, Product product) {
        product.update();
    }

    @DELETE
    @Path("/{id}")
    public void delete(String id) {
        Product product = Product.findById(new ObjectId(id));
        product.delete();
    }

    @GET
    @Path("/search/{name}")
    public Product search(String name) {
        return Product.findByName(name);
    }

    @DELETE
    public void deleteAll(){
        Product.deleteAll();
    }

}
