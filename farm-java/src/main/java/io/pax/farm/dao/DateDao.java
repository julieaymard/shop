package io.pax.farm.dao;

import io.pax.farm.domain.Date;
import io.pax.farm.domain.jdbc.SimpleDate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DateDao {
    JdbcConnector connector = new JdbcConnector();

    public List<Date> listDates() throws SQLException {
        List<Date> dates = new ArrayList<>();
        Connection conn = this.connector.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM date");


        while (rs.next()) {
            int id = rs.getInt("id");
            String day = rs.getString("day");
            String open = rs.getString("open");
            String close = rs.getString("close");


            dates.add(new SimpleDate(id, day, open, close));
        }

        rs.close();
        stmt.close();
        conn.close();

        return dates;
    }

    public static void main(String[] args) throws SQLException {
        DateDao dao = new DateDao();
        System.out.println( dao.listDates());


    }
}
