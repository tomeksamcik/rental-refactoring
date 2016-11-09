package com.sqli.refactored.visitor;

public class NewRelease extends Movie {

	public NewRelease(String name) {
		super(name);
	}

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}
