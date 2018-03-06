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

    public int createProduct(String name, int price, int farmer_id) throws SQLException {
        String query = "INSERT INTO product (name, price, farmer_id) VALUES (?,?,?)";
        System.out.println(query);

        Connection conn = this.connector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, name);
        statement.setInt(2, price);
        statement.setInt(3, farmer_id);

        statement.executeUpdate();

        ResultSet keys = statement.getGeneratedKeys();
        keys.next();

        int id = keys.getInt(1);

        statement.close();
        conn.close();

        return id;
    }
    public void deleteProduct(int productId) throws SQLException {

        String query = "DELETE  FROM product WHERE id=?";
        //System.out.println(query);


        Connection conn = this.connector.getConnection();
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1,productId);
        statement.executeUpdate();
        statement.close();
        conn.close();

    }

    public static void main(String[] args) throws SQLException {
       ProductDao dao = new ProductDao();
        System.out.println(dao.listProducts());
        dao.createProduct("milk", 15, 1);
        //dao.deleteProduct(4);

    }
}
