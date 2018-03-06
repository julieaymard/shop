package io.pax.farm.ws;

import io.pax.farm.dao.ClientDao;
import io.pax.farm.domain.Client;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("clients")//chemin relatif pour avoir "http://localhost:8080/farm-java/api/clients"
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ClientWs {

    @GET
    public List<Client> getClients() throws SQLException {
        ClientDao dao = new ClientDao();
        return dao.listClients();
    }

    @GET
    @Path("{id}") //this is a pathparam
    public Client getClient(@PathParam("id") int client_id) throws SQLException {
        return new ClientDao().findClientWithCommends(client_id);
    }
}