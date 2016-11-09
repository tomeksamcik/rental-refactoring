package com.sqli.to_refactor;


public class Tape extends DomainObject
{
    public Movie movie() {
        return movie;
    }
    public Tape(String serialNumber, Movie movie) {
        serialNumber = serialNumber;
        movie = movie;
    }
    private String serialNumber;
    private Movie movie;
}