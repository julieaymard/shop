package io.pax.farm.ws;

import io.pax.farm.dao.FarmerDao;
import io.pax.farm.domain.Farmer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;

@Path("farmerProducts")//chemin relatif pour avoir "http://localhost:8080/farm-java/api/clients"
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FarmerWs {

    @GET
    public Farmer getProducts() throws SQLException {
        FarmerDao dao = new FarmerDao();
        return dao.getProducts(1);
    }
}

