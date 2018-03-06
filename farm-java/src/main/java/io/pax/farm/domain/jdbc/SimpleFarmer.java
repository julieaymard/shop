package io.pax.farm.domain.jdbc;

import io.pax.farm.domain.Farmer;

public class SimpleFarmer implements Farmer {
    int id;
    String name;

    public SimpleFarmer() {
    }

    public SimpleFarmer(int id, String name) {
        this.id = id;
        this.name = name;
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
}
