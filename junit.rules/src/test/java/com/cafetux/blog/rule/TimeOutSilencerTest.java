package com.cafetux.blog.rule;

import java.util.concurrent.TimeoutException;

import org.junit.Rule;
import org.junit.Test;

import com.cafetux.blog.rule.annotation.IgnoreTimeout;

public class TimeOutSilencerTest {

	@Rule
	public TimeOutSilencerRule timeOutRule = new TimeOutSilencerRule();

	@Test(expected = IllegalArgumentException.class)
	@IgnoreTimeout
	public void test_that_throw_exception_not_silenced() throws Exception {
		throw new IllegalArgumentException("je ne veux pas être ignorée !");
	}

	@Test
	@IgnoreTimeout
	public void test_that_throw_timeout_exception() throws Exception {
		throw new TimeoutException("tango charly le server ne répond plus");
	}

	@Test(expected = TimeoutException.class)
	public void test_that_throw_timeout_exception_but_not_ignored()
			throws Exception {
		throw new TimeoutException("tango charly le server ne répond plus");
	}

}
