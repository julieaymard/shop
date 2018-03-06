package io.pax.farm.ws;

import io.pax.farm.dao.DateDao;
import io.pax.farm.domain.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;

@Path("dates")//chemin relatif pour avoir "http://localhost:8080/farm-java/api/clients"
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class DateWs {

    @GET
    public List<Date> getDates() throws SQLException {
        DateDao dao = new DateDao();
        return dao.listDates();
    }
}