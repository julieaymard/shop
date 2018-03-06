package io.pax.farm.domain.jdbc;

import io.pax.farm.domain.Farmer;
import io.pax.farm.domain.Product;

import java.util.List;

public class SimpleFarmer implements Farmer {
    int id;
    String name;

    List<Product> products;

    public SimpleFarmer() {
    }

    public SimpleFarmer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public SimpleFarmer(int id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public List<Product> getProducts() {
        return products;
    }
}
