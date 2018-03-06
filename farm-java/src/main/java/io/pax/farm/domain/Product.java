package io.pax.farm.domain;

public interface Product {

    int getId();
    String getName();
    int getPrice();


    Client getClient();

    Farmer getFarmer();

}
