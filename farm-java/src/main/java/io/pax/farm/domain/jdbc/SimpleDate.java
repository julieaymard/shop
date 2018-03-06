package io.pax.farm.domain.jdbc;

import io.pax.farm.domain.Date;

public class SimpleDate implements Date {
    int id;
    String day;
    String open;
    String close;

    public SimpleDate() {
    }

    public SimpleDate(int id, String day, String open, String close) {
        this.id = id;
        this.day = day;
        this.open = open;
        this.close = close;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    @Override
    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    @Override
    public String toString() {
        return this.day + " : " + this.open + " - " + this.close;
    }
}
