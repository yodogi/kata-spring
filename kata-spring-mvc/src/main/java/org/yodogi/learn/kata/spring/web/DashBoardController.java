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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller("dashboard-controller")
@RequestMapping(value = "/dashboard/")
public class DashBoardController {

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = { "/index.htm" }, method = RequestMethod.GET)
	public ModelAndView dashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Date now = new Date();

		ModelAndView model = new ModelAndView("dashboard", "now", now);

		logger.info("Returning kendo view with " + now);

		return model;
	}

}
