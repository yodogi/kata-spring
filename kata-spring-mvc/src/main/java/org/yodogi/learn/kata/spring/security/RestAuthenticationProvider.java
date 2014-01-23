package org.yodogi.learn.kata.spring.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestAuthenticationProvider implements AuthenticationProvider {

	protected final Log logger = LogFactory.getLog(getClass());

	@Value("${rest.service.url}")
	private String restServiceUrl;

	@Value("${rest.service.attribute.ticket}")
	private String restServiceAttrTicket;

	@Autowired
	private RestTemplate restTemplate;

	public Authentication authenticate(Authentication credentials) throws AuthenticationException {
		String username = credentials.getName();
		String password = (String) credentials.getCredentials();

		String ticket = authenticateByUserPass(username, password);
		if (ticket == null) {
			throw new BadCredentialsException("Invalid credentials for " + username);
		}

		List<Role> authorities = new ArrayList<Role>();

		Role rol = new Role();
		rol.setName(Role.user_role);
		authorities.add(rol);

		return new UsernamePasswordAuthenticationToken(username, password, authorities);
	}

	public boolean supports(Class<?> credentials) {
		return true;
	}

	private String authenticateByUserPass(String username, String password) {
		try {
			String ticket_session_url = restServiceUrl + "/authentication/getTicket?username={user}&password={pass}";

			logger.info("try access to [ " + String.format(ticket_session_url, username, password) + " ]...");

			String result = this.restTemplate.getForObject(ticket_session_url, String.class, username, password);

			return parserTicket(result);

		} catch (RestClientException ex) {
			logger.error("RestClientException: " + ex.getMessage());
		}

		return null;
	}

	private String parserTicket(String json_ticket) {
		try {
			JsonFactory jfactory = new JsonFactory();
			JsonParser jParser = jfactory.createJsonParser(json_ticket);
			while (jParser.nextToken() != JsonToken.END_OBJECT) {
				String fieldname = jParser.getCurrentName();
				if (this.restServiceAttrTicket.equals(fieldname)) {
					jParser.nextToken();
					json_ticket = jParser.getText();
					logger.info(this.restServiceAttrTicket + " [ " + json_ticket + " ]");
				}
			}
			jParser.close();

			TicketValidator validator = new TicketValidator();
			return validator.validate(json_ticket) ? json_ticket : null;

		} catch (JsonParseException ex) {
			logger.error("JsonParseException(" + ex.getClass().getName() + "): " + ex.getMessage());
		} catch (IOException ex) {
			logger.error("IOException(" + ex.getClass().getName() + "): " + ex.getMessage());
		}

		return null;
	}

}
