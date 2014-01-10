package org.yodogi.learn.kata.spring.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class DashboardControllerTests {

	@Test
	public void testDatePickerView() throws Exception {
		DashBoardController controller = new DashBoardController();
		ModelAndView modelAndView = controller.dashboard(null, null);
		assertEquals("dashboard", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		Date nowValue = (Date) modelAndView.getModel().get("now");
		assertNotNull(nowValue);
	}

}
