package com.koitoer.spring.integration.example.cinema.components;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.koitoer.spring.integration.example.cinema.domain.Film;

/**
 * @author mauricio.mena
 * @since 26/02/2015
 *
 */
@Component("restResponseHandler")
public class RestResponseHandler {

	private static final String NEW_LINE = "\n";

	/**
	 * @param msg
	 * @return
	 */
	@ServiceActivator
	public String handle(final Message<Film[]> msg) {
		final Film[] films = msg.getPayload();

		final StringBuilder response = new StringBuilder(RestResponseHandler.NEW_LINE);
		if (films.length > 0) {
			response.append("Returned films:" + RestResponseHandler.NEW_LINE);
		}
		else {
			response.append("No films returned" + RestResponseHandler.NEW_LINE);
		}

		for (final Film f : films) {
			response.append(f.getName()).append(RestResponseHandler.NEW_LINE);
		}

		return response.toString();
	}
}