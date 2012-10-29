package com.cafetux.blog.rule;

import java.util.concurrent.TimeoutException;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import com.cafetux.blog.rule.annotation.IgnoreTimeout;
import com.cafetux.blog.rule.statement.SilencerStatement;

public class TimeOutSilencerRule implements TestRule {

	public Statement apply(Statement base, Description desc) {
		try {
			if (desc.getAnnotation(IgnoreTimeout.class) != null) {
				base.evaluate();
			}
		} catch (Throwable e) {
			if (e instanceof TimeoutException) {
				base = new SilencerStatement();
			}
		}
		return base;
	}

}
