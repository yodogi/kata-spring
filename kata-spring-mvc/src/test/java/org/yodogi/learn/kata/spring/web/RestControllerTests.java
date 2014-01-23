package org.yodogi.learn.kata.spring.web;

import static org.junit.Assert.assertFalse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

public class RestControllerTests {

	private RestController controller;
	protected final Log logger = LogFactory.getLog(getClass());

	@Test
	public void testRestDataBasic() throws Exception {
		this.controller = new RestController();
		assertFalse("{}".equals(this.controller.getPendingTask()));
	}

}
