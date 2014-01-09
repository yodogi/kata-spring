package org.yodogi.learn.kata.spring.web;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KendoController {

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = "/kendo/datepicker.htm")
	public ModelAndView datePicker(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Date now = new Date();
		logger.info("Returning kendo view with " + now);

		return new ModelAndView("kendo-datepicker", "now", now);
	}

}
