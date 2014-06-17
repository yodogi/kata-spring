package org.yodogi.learn.kata.spring.config;

import javax.inject.Inject;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@PropertySource("classpath:dynamic.properties")
public class AppConfig {

	@Inject
	Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	@SuppressWarnings("deprecation")
	public @Bean
	RestTemplate restTemplate() {
		return new RestTemplate(new HttpComponentsClientHttpRequestFactory(new DefaultHttpClient(new PoolingClientConnectionManager())));
	}

	public @Bean
	ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages/messages");
		messageSource.setCacheSeconds(0);
		return messageSource;
	}

	public @Bean
	AjaxTimeOutRediectFilter ajaxTimeOutRediectFilter() {
		AjaxTimeOutRediectFilter filter = new AjaxTimeOutRediectFilter();
		filter.setCustomSessionExpiredErrorCode(901);
		return filter;
	}

}
