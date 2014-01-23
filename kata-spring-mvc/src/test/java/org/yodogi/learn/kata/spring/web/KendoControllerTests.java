package org.yodogi.learn.kata.spring.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class KendoControllerTests {

	private KendoController controller;

	@Test
	public void testDatePickerView() throws Exception {
		this.controller = new KendoController();
		ModelAndView modelAndView = controller.datePicker(null, null);
		assertEquals("kendo/datepicker", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		Date nowValue = (Date) modelAndView.getModel().get("now");
		assertNotNull(nowValue);
		ArrayList<Date> datesValue = (ArrayList<Date>) modelAndView.getModel().get("dates");
		assertNotNull(datesValue);
	}

	@Test
	public void testPanelbarView() throws Exception {
		this.controller = new KendoController();
		ModelAndView modelAndView = controller.panelbar(null, null);
		assertEquals("kendo/panelbar", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		assertNull(modelAndView.getModel().get("now"));
	}

	@Test
	public void datasource() throws Exception {
		this.controller = new KendoController();
		ModelAndView modelAndView = controller.datasource(null, null);
		assertEquals("kendo/datasource", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		assertNull(modelAndView.getModel().get("now"));
	}

	@Test
	public void testDashboardView() throws Exception {
		this.controller = new KendoController();
		ModelAndView modelAndView = controller.dashboard(null, null);
		assertEquals("kendo/dashboard", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		Date nowValue = (Date) modelAndView.getModel().get("now");
		assertNotNull(nowValue);
	}

}
