package io.pax.farm.domain.jdbc;

import io.pax.farm.domain.Client;
import io.pax.farm.domain.Command;
import io.pax.farm.domain.Product;

import java.util.List;

public class SimpleClient implements Client {
    int id;
    String mail;
   // List<Command> commends;

    List<Product> products;




    public SimpleClient() {
    }

    public SimpleClient(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    /*public SimpleClient(int id, String mail, List<Command> commends) {
        this.id = id;
        this.mail = mail;
        this.commends = commends;
    }*/

    public SimpleClient(int id, String mail, List<Product> products) {
        this.id = id;
        this.mail = mail;
        this.products = products;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getMail() {
        return this.mail;
    }

   /* public List<Command> getCommends() {
        return commends;
    }*/

    @Override
    public String toString() {
        return this.mail;
    }

    public List<Product> getProducts() {
        return products;
    }
}
