package io.pax.farm.dao;

import io.pax.farm.domain.Client;
import io.pax.farm.domain.Product;
import io.pax.farm.domain.jdbc.SimpleClient;
import io.pax.farm.domain.jdbc.SimpleProduct;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {

    JdbcConnector connector = new JdbcConnector();

    public List<Product> listProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        Connection conn = this.connector.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM product");


        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            int price = rs.getInt("price");

            products.add(new SimpleProduct(id, name, price));
        }

        rs.close();
        stmt.close();
        conn.close();

        return products;
    }



    public static void main(String[] args) throws SQLException {
       ProductDao dao = new ProductDao();
        System.out.println(dao.listProducts());
       // dao.createProduct("")

    }
}
