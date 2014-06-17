package org.yodogi.learn.kata.spring.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.yodogi.learn.kata.spring.data.Tag;
import org.yodogi.learn.kata.spring.exception.CustomGenericException;

@Controller("hello-controller")
public class HelloController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	protected MessageSource messageSource;

	private final List<Tag> data = new ArrayList<Tag>();

	HelloController() {
		// init data for testing
		data.add(new Tag(1, "ruby"));
		data.add(new Tag(2, "rails"));
		data.add(new Tag(3, "c / c++"));
		data.add(new Tag(4, ".net"));
		data.add(new Tag(5, "python"));
		data.add(new Tag(6, "java"));
		data.add(new Tag(7, "javascript"));
		data.add(new Tag(8, "jscript"));

	}

	@RequestMapping(value = "/hello.htm", method = RequestMethod.GET)
	public ModelAndView handleRequestWelcome(ModelMap model) {

		String now = new Date().toString();
		logger.info("Returning hello view with " + now);

		Locale locale = LocaleContextHolder.getLocale();
		logger.info("Message trace of [message.springmvc]: " + messageSource.getMessage("message.springmvc", null, locale));
		logger.info(">>>>>>>>>>>>  " + locale.getVariant());
		logger.info(">>>>>>>>>>>>  " + locale.getDisplayLanguage());
		logger.info(">>>>>>>>>>>>  " + locale.getDefault());
		logger.info(">>>>>>>>>>>>  " + locale);

		return new ModelAndView("hello", "now", now);
	}

	@RequestMapping(value = { "/gettags.htm" }, method = RequestMethod.GET)
	public @ResponseBody
	List<Tag> getTags(@RequestParam String tagName) {

		List<Tag> result = new ArrayList<Tag>();

		// iterate a list and filter by tagName
		for (Tag tag : data) {
			if (tag.getTagName().contains(tagName)) {
				result.add(tag);
			}
		}

		return result;

	}

	@RequestMapping(value = "/exception.htm")
	protected ModelAndView handleGenerateCustomException() throws Exception {
		throw new CustomGenericException("E888", "This is custom message - ABC");
	}

	@ExceptionHandler(CustomGenericException.class)
	public ModelAndView handleCustomException(CustomGenericException ex) {

		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("exception", ex);
		return model;

	}

	@ExceptionHandler(Exception.class)
	public ModelAndView handleAllException(Exception ex) {

		ModelAndView model = new ModelAndView("error/generic_error");
		model.addObject("exception", ex);
		return model;

	}

}
