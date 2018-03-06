package io.pax.farm.dao;

import io.pax.farm.domain.Farmer;
import io.pax.farm.domain.Product;
import io.pax.farm.domain.jdbc.SimpleFarmer;
import io.pax.farm.domain.jdbc.SimpleProduct;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FarmerDao {


    JdbcConnector connector = new JdbcConnector();

    public Farmer getProducts (int farmerId) throws SQLException {

        Connection connection = connector.getConnection();
        String query = "SELECT * FROM product  p RIGHT JOIN farmer f ON p.farmer_id=f.id WHERE f.id =?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, farmerId);
        ResultSet set = statement.executeQuery();
        Farmer farmer = null;

        List<Product> products = new ArrayList<>();
        while (set.next()) {
            String farmerName = set.getString("f.name");

            farmer = new SimpleFarmer(farmerId, farmerName, products);
            int productId = set.getInt("p.id");
            String productName= set.getString("p.name");
            int productPrice = set.getInt("p.price");
            if (productId> 0) {
                Product product = new SimpleProduct(productId, productName,  productPrice);
                products.add(product);
            }
        }

        set.close();
        statement.close();
        System.out.println(products);
        return farmer;
    }



    public static void main(String[] args) throws SQLException {
        FarmerDao dao = new FarmerDao();
        dao.getProducts(1);
    }
}

