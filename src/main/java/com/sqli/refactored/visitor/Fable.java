package com.sqli.refactored.visitor;

public class Fable extends Movie {

	public Fable(String name) {
		super(name);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
