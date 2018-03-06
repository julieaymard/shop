package io.pax.farm.dao;

import io.pax.farm.domain.Client;
import io.pax.farm.domain.Command;
import io.pax.farm.domain.Product;
import io.pax.farm.domain.jdbc.SimpleClient;
import io.pax.farm.domain.jdbc.SimpleCommand;
import io.pax.farm.domain.jdbc.SimpleProduct;

import java.sql.*;
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

  public Client findClientWithCommends(int client_id) throws SQLException {
        Connection connection = connector.getConnection();
        String query = "SELECT * FROM commend cmd JOIN client c ON cmd.client_id = c.id INNER JOIN product p ON cmd.product_id = p.id WHERE c.id =?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, client_id);

        ResultSet set = statement.executeQuery();

        Client client = null;
        //pro tip: always init lists
        List<Product> products = new ArrayList<>();

        while(set.next()){
            String clientMail = set.getString("c.mail");

            client = new SimpleClient(client_id, clientMail, products);

            int productId = set.getInt("p.id");
            String productName = set.getString("p.name");
            int productPrice = set.getInt("p.price");


            if(productId > 0){
                Product product = new SimpleProduct(productId, productName, productPrice );
                products.add(product);
                System.out.println(products);
            }
        }
        set.close();
        statement.close();
        connection.close();

        return client;
    }


    public static void main(String[] args) throws SQLException {
        ClientDao dao = new ClientDao();
       dao.findClientWithCommends(1);

    }
}
