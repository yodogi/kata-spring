package org.yodogi.learn.kata.spring.web;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

public class HelloControllerTests {

	protected final Log logger = LogFactory.getLog(getClass());

	private static final String app_context_path = "src/main/webapp/WEB-INF/spring/";
	private static final ApplicationContext app_context = new FileSystemXmlApplicationContext(app_context_path + "servlet-context.xml");

	@Test
	public void testHandleRequestView() throws Exception {
		HelloController controller = (HelloController) app_context.getBean("helloController");
		ModelAndView modelAndView = controller.handleRequestInternal(null, null);
		assertEquals("hello", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		String nowValue = (String) modelAndView.getModel().get("now");
		assertNotNull(nowValue);
	}

	@Test
	public void testMessageResource() throws Exception {
		MessageSource messageSource = (MessageSource) app_context.getBean("messageSource");
		Locale locale = LocaleContextHolder.getLocale();
		logger.info("Message trace of [message.springmvc]: " + messageSource.getMessage("message.springmvc", null, locale)); //

	}

}
