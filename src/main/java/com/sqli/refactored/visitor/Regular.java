package com.sqli.refactored.visitor;

public class Regular extends Movie {

	public Regular(String name) {
		super(name);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
