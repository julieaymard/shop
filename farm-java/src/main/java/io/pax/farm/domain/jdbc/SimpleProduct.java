package io.pax.farm.domain.jdbc;


import io.pax.farm.domain.Client;
import io.pax.farm.domain.Farmer;
import io.pax.farm.domain.Product;

public class SimpleProduct implements Product {
    int id;
    String name;
    int price;

    SimpleClient client;

    SimpleFarmer farmer;


    public SimpleProduct() {
    }

    public SimpleProduct(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }


    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public Client getClient() {
        return client;
    }

    @Override
    public Farmer getFarmer() {
        return farmer;
    }

    @Override
    public String toString() {
        return this.name + " " + this.price;
    }
}
