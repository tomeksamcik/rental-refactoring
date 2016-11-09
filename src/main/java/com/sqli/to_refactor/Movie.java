package com.sqli.to_refactor;

public class Movie extends DomainObject {
    public static final int CHILDREN = 2;
    public static final int  REGULAR = 0;
    public static final int  NEW_RELEASE = 1;


    private int priceCode;

    public Movie(String name, int priceCode) {
        name = name;
        priceCode = priceCode;
    }

    public int priceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }
}
