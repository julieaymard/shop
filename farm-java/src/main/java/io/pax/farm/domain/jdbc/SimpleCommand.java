package io.pax.farm.domain.jdbc;

import io.pax.farm.domain.Command;

public class SimpleCommand implements Command {
    int client_id;
    int product_id;
    SimpleClient client;
    SimpleProduct product;

    public SimpleCommand() {
    }

    public SimpleCommand(int client_id) {
        this.client_id = client_id;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public SimpleClient getClient() {
        return client;
    }

    public void setClient(SimpleClient client) {
        this.client = client;
    }

    public SimpleProduct getProduct() {
        return product;
    }

    public void setProduct(SimpleProduct product) {
        this.product = product;
    }

    @Override
    public int getClient_Id() {
        return client_id;
    }

    @Override
    public int getProduct_Id() {
        return product_id;
    }
}
