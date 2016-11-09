package com.sqli.refactored.visitor;

public interface Visitor {

	void visit(Fable fable);

	void visit(NewRelease newRelease);

	void visit(Regular regular);

}
