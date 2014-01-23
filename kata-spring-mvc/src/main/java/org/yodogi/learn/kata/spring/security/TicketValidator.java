package org.yodogi.learn.kata.spring.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TicketValidator {

	private final Pattern pattern;
	private Matcher matcher;

	private static final String TICKET_PATTERN = "^TICKET_[0-9a-f]{40}";

	public TicketValidator() {
		pattern = Pattern.compile(TICKET_PATTERN);
	}

	/**
	 * Validate ticket with regular expression
	 * 
	 * @param ticket
	 *            ticket for validation
	 * @return true valid ticket, false invalid ticket
	 */
	public boolean validate(final String ticket) {
		matcher = pattern.matcher(ticket);
		return matcher.matches();

	}

}
