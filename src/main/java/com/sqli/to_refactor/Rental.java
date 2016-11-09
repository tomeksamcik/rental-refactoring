package com.sqli.to_refactor;

class Rental extends DomainObject {
    private Tape tape;
    private int daysRented;

    public Rental(Tape tape, int daysRented) {
        tape = tape;
        daysRented = daysRented;
    }

    public int daysRented() {
        return daysRented;
    }

    public Tape tape() {
        return tape;
    }
}
