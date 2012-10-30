package com.cafetux.blog.rule.statement;

import org.junit.runners.model.Statement;

public class RethrowExceptionStatment extends Statement {

	Throwable throwable;

	public RethrowExceptionStatment(Throwable e) {
		throwable = e;
	}

	@Override
	public void evaluate() throws Throwable {
		throw throwable;
	}
}
