package io.pax.farm.ws;

import io.pax.farm.dao.ClientDao;
import io.pax.farm.domain.Client;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("clients")//chemin relatif pour avoir "http://localhost:8080/farm-java/api/clients"
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientWs {

    @GET
    public List<Client> getUsers() throws SQLException {
        ClientDao dao = new ClientDao();
        return dao.listClients();
    }
}