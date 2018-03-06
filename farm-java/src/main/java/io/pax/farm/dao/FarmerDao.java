package io.pax.farm.dao;

import java.sql.SQLException;

public class FarmerDao {


    JdbcConnector connector = new JdbcConnector();



    public static void main(String[] args) throws SQLException {
        ClientDao dao = new ClientDao();
        System.out.println(dao.listClients());

    }
}

