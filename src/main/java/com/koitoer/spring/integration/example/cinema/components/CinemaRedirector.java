package com.koitoer.spring.integration.example.cinema.components;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.Router;
import org.springframework.stereotype.Component;

@Component("cinemaRedirector")
public class CinemaRedirector {

	private static final String CINEMA_EGYPTIAN_CHANNEL = "egyptianRequestChannel";
	private static final String CINEMA_PANTAGES_CHANNEL = "pantagesRequestChannel";
	private static final String QUIT_REQUEST_CHANNEL = "quitRequestChannel";

	@Router
	public String redirectMessage(final Message<String> msg) {
		final String payload = msg.getPayload();

		if ("1".equals(payload)) {
			return CinemaRedirector.CINEMA_EGYPTIAN_CHANNEL;
		}
		else if ("2".equals(payload)) {
			return CinemaRedirector.CINEMA_PANTAGES_CHANNEL;
		}

		return CinemaRedirector.QUIT_REQUEST_CHANNEL;
	}
}