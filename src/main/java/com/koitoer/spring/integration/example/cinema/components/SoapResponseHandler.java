package com.koitoer.spring.integration.example.cinema.components;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.koitoer.spring.integration.example.cinema.domain.Film;
import com.koitoer.spring.integration.example.cinema.domain.FilmResponse;

@Component("soapResponseHandler")
public class SoapResponseHandler {

	private static final String NEW_LINE = "\n";

	@ServiceActivator
	public String handle(final Message<FilmResponse> msg) {
		final FilmResponse response = msg.getPayload();

		final StringBuilder resp = new StringBuilder(SoapResponseHandler.NEW_LINE);
		if (response.getFilm().size() > 0) {
			resp.append("Returned films:" + SoapResponseHandler.NEW_LINE);
		}
		else {
			resp.append("No films returned" + SoapResponseHandler.NEW_LINE);
		}

		for (final Film f : response.getFilm()) {
			resp.append(f.getName()).append(SoapResponseHandler.NEW_LINE);
		}

		return resp.toString();
	}
}