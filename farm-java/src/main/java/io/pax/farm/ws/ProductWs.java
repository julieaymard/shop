package io.pax.farm.ws;


import io.pax.farm.dao.ProductDao;

import io.pax.farm.domain.Farmer;
import io.pax.farm.domain.Product;
import io.pax.farm.domain.jdbc.SimpleFarmer;
import io.pax.farm.domain.jdbc.SimpleProduct;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("products")//chemin relatif pour avoir "http://localhost:8080/farm-java/api/clients"
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductWs {

    @GET
    public List<Product> getProducts() throws SQLException {
        ProductDao dao = new ProductDao();
        return dao.listProducts();
    }

    @POST
    /*return future wallet with an id*/
    public SimpleProduct createProduct(SimpleProduct product /* sent wallet has no id*/) {
        Farmer farmer = product.getFarmer();
        if (farmer == null) {
            throw new NotAcceptableException("406 no user id sent");
        }
        if (product.getName().length() < 2) {
            throw new NotAcceptableException("406 : wallet name must have at least 2 letters ");

        }

        try {
            int id = new ProductDao().createProduct(product.getName(),product.getPrice(),farmer.getId());
            Farmer boundFarmer = product.getFarmer();
            SimpleFarmer simpleFarmer = new SimpleFarmer(boundFarmer.getId(),boundFarmer.getName());
            return new SimpleProduct(id, product.getName(),product.getPrice(),simpleFarmer);
        } catch (SQLException e) {

            throw new ServerErrorException("Database error, sorry", 500);
        }
    }

    @DELETE
    @Path("/{id}")
    //@Produces(MediaType.APPLICATION_XML)
    public int deleteProduct(@PathParam("id") int id) throws SQLException {
        ProductDao dao = new ProductDao();
        dao.deleteProduct(id);
        return id;


    }


}
