package org.yodogi.learn.kata.spring.web;

import java.security.Principal;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller("spring-security-controller")
public class SpringSecurityController {

	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	protected MessageSource messageSource;

	@RequestMapping(value = "/welcome.htm", method = RequestMethod.GET)
	public String printWelcome(ModelMap model, Principal principal) {

		String name = principal.getName();
		model.addAttribute("username", name);
		model.addAttribute("message", "Spring Security Custom Form example");

		Locale locale = LocaleContextHolder.getLocale();
		logger.info("Message trace of [message.springmvc]: " + messageSource.getMessage("AuthByAdapterProvider.incorrectKey", null, locale)); //

		logger.info("Wellcome controller login for " + name);

		return "ssecurity/hello";
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public String login(ModelMap model) {

		return "ssecurity/login";

	}

	@RequestMapping(value = "/loginfailed.htm", method = RequestMethod.GET)
	public String loginerror(ModelMap model) {

		model.addAttribute("error", "true");
		return "ssecurity/login";

	}

	@RequestMapping(value = "/logout.htm", method = RequestMethod.GET)
	public String logout(ModelMap model) {

		return "ssecurity/login";

	}

	private class Ticket {
		String ticket;
	}

}
