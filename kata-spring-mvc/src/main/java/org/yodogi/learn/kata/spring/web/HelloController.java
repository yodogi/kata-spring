package org.yodogi.learn.kata.spring.web;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

@Controller
public class HelloController extends AbstractController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	protected MessageSource messageSource;

	@Override
	@RequestMapping(value = "/hello.htm")
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String now = new Date().toString();
		logger.info("Returning hello view with " + now);

		Locale locale = LocaleContextHolder.getLocale();
		logger.info("Message trace of [message.springmvc]: " + messageSource.getMessage("message.springmvc", null, locale));

		return new ModelAndView("hello", "now", now);
	}
}
