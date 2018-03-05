package io.pax.farm.dao;

import io.pax.farm.domain.Client;
import io.pax.farm.domain.jdbc.SimpleClient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {

    JdbcConnector connector = new JdbcConnector();

    public List<Client> listClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        Connection conn = this.connector.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM client");


        while (rs.next()) {
            String mail = rs.getString("mail");
            int id = rs.getInt("id");

            clients.add(new SimpleClient(id, mail));
        }

        rs.close();
        stmt.close();
        conn.close();

        return clients;
    }

    public static void main(String[] args) throws SQLException {
        ClientDao dao = new ClientDao();
        System.out.println(dao.listClients());

    }
}
