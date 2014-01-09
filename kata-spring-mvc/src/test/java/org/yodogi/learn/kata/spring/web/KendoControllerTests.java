package org.yodogi.learn.kata.spring.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class KendoControllerTests {

	@Test
	public void testDatePickerView() throws Exception {
		KendoController controller = new KendoController();
		ModelAndView modelAndView = controller.datePicker(null, null);
		assertEquals("kendo-datepicker", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		Date nowValue = (Date) modelAndView.getModel().get("now");
		assertNotNull(nowValue);
	}

}
