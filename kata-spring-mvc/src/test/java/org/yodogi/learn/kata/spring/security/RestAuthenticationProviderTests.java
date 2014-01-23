package org.yodogi.learn.kata.spring.security;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.yodogi.learn.kata.spring.config.AppConfig;

public class RestAuthenticationProviderTests {

	private AuthenticationProvider restAuthenticationProvider;

	@Before
	@SuppressWarnings("resource")
	public void setUp() {
		// create the spring container using the AppConfig @Configuration class
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(AppConfig.class);
		ctx.refresh();

		restAuthenticationProvider = ctx.getBean(RestAuthenticationProvider.class);
	}

	@Test
	public void testGetTicket() throws Exception {
		Authentication credential = new UsernamePasswordAuthenticationToken("OscarMuriel", "1111", null);
		Authentication handle = restAuthenticationProvider.authenticate(credential);
		assertNotNull(handle);
	}

	@Test
	public void testGetAuthenticationError() throws Exception {
		Authentication credential = new UsernamePasswordAuthenticationToken("demo", "done", null);
		try {
			restAuthenticationProvider.authenticate(credential);
			fail("Should be fail authentication process [wrong credentials]");
		} catch (AuthenticationException ex) {
			// is correct the appear of exception
		}
	}

	@Test
	public void testGetAuthenticationNullPassword() throws Exception {
		Authentication credential = new UsernamePasswordAuthenticationToken("demo", null, null);
		try {
			restAuthenticationProvider.authenticate(credential);
			fail("Should be fail authentication process [wrong credentials]");
		} catch (AuthenticationException ex) {
			// is correct the appear of exception
		}
	}

}
