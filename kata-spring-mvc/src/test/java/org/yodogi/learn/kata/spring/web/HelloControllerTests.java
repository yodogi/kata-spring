package org.yodogi.learn.kata.spring.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class HelloControllerTests {

	@Test
	public void testHandleRequestView() throws Exception {
		HelloController controller = new HelloController();
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("hello.jsp", modelAndView.getViewName());
	}

}
