package io.pax.farm.dao;

import io.pax.farm.domain.Date;
import io.pax.farm.domain.jdbc.SimpleDate;

import java.sql.*;
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
    public int createDate(String day, String open, String close) throws SQLException {
        String query = "INSERT INTO date (day, open, close) VALUES (?,?,?)";
        System.out.println(query);

        Connection conn = this.connector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, day);
        statement.setString(2, open);
        statement.setString(3, close);

        statement.executeUpdate();

        ResultSet keys = statement.getGeneratedKeys();
        keys.next();

        int id = keys.getInt(1);

        statement.close();
        conn.close();

        return id;
    }

    public int deleteDate(int dateId) throws SQLException {

        String query = "DELETE  FROM date WHERE id=?";
        //System.out.println(query);


        Connection conn = this.connector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1,dateId);
        statement.executeUpdate();
        statement.close();
        conn.close();

        return dateId;
    }


    public static void main(String[] args) throws SQLException {
        DateDao dao = new DateDao();
        System.out.println( dao.listDates());
        //dao.createDate("myDay", "myOpenning", "myClosing");
        //dao.deleteDate(6);
    }
}
