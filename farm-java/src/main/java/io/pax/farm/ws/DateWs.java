package io.pax.farm.ws;

import io.pax.farm.dao.DateDao;
import io.pax.farm.domain.Date;
import io.pax.farm.domain.jdbc.SimpleDate;

import javax.ws.rs.*;
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

    @POST
    /*return future wallet with an id*/
    public SimpleDate createDate(SimpleDate date /* sent wallet has no id*/) {

        if (date.getDay().length() < 2) {
            throw new NotAcceptableException("406 : wallet name must have at least 2 letters ");

        }

        try {
            int id = new DateDao().createDate(date.getDay(),date.getOpen(),date.getClose());


            return new SimpleDate(id, date.getDay(),date.getOpen(),date.getClose());
        } catch (SQLException e) {

            throw new ServerErrorException("Database error, sorry", 500);
        }
    }

    @DELETE
    @Path("{id}")
    //@Produces(MediaType.APPLICATION_XML)
    public int deleteDate(@PathParam("id") int id) throws SQLException {
        DateDao dao = new DateDao();
        dao.deleteDate(id);
        return id;

    }
}