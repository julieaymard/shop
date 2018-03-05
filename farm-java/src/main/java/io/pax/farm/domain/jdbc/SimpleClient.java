package io.pax.farm.domain.jdbc;

import io.pax.farm.domain.Client;

public class SimpleClient implements Client {
    int id;
    String mail;

    public SimpleClient() {
    }

    public SimpleClient(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getMail() {
        return this.mail;
    }

    @Override
    public String toString() {
        return this.mail;
    }
}
