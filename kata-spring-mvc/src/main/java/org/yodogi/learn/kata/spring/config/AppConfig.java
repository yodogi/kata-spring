package org.yodogi.learn.kata.spring.config;

import javax.inject.Inject;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.web.client.RestTemplate;
import org.yodogi.learn.kata.spring.security.RestAuthenticationProvider;

@Configuration
@PropertySource("classpath:dynamic.properties")
public class AppConfig {

	@Inject
	Environment env;

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public @Bean
	AuthenticationProvider restAuthenticationProvider() {
		RestAuthenticationProvider restAuth = new RestAuthenticationProvider();
		// restAuth.setRestServiceUrl(env.getProperty("rest.service.url"));
		// restAuth.setRestServiceAttrTicket(env.getProperty("{rest.service.attribute.ticket"));
		return restAuth;
	}

	@SuppressWarnings("deprecation")
	public @Bean
	RestTemplate restTemplate() {
		return new RestTemplate(new HttpComponentsClientHttpRequestFactory(new DefaultHttpClient(new PoolingClientConnectionManager())));
	}

	/*
	 * <bean id="httpClient" class="org.apache.http.impl.client.DefaultHttpClient"> <constructor-arg> <bean
	 * class="org.apache.http.impl.conn.PoolingClientConnectionManager"/> </constructor-arg> </bean>
	 * 
	 * <bean id="restTemplate" class="org.springframework.web.client.RestTemplate"> <constructor-arg> <bean
	 * class="org.springframework.http.client.HttpComponentsClientHttpRequestFactory"> <constructor-arg ref="httpClient"/> </bean> </constructor-arg> </bean>
	 */
}
