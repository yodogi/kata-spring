package org.yodogi.learn.kata.spring.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
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

@Controller("datepicker-controller")
@RequestMapping(value = "/kendo/")
public class KendoController {

	protected final Log logger = LogFactory.getLog(getClass());

	@RequestMapping(value = { "/datepicker.htm" }, method = RequestMethod.GET)
	public ModelAndView datePicker(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Date now = new Date();

		ModelAndView model = new ModelAndView("datepicker", "now", now);

		model.addObject("dates", getDates());

		logger.info("Returning kendo view with " + now + " for dates: " + getDates().toString());

		return model;
	}

	private ArrayList<Date> getDates() {
		Calendar cal = Calendar.getInstance();
		ArrayList<Date> dates = new ArrayList<Date>();

		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		cal.set(year, month, 11, 0, 0, 0);
		cal.set(Calendar.MILLISECOND, 0);
		dates.add(cal.getTime());

		cal.set(year, month + 1, 6, 0, 0);
		dates.add(cal.getTime());

		cal.set(year, month + 1, 27, 0, 0);
		dates.add(cal.getTime());

		cal.set(year, month - 1, 3, 0, 0);
		dates.add(cal.getTime());

		cal.set(year, month - 2, 22, 0, 0);
		dates.add(cal.getTime());

		return dates;
	}

}
