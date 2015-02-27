package com.koitoer.spring.integration.example.cinema.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.koitoer.spring.integration.example.cinema.domain.Film;
import com.koitoer.spring.integration.example.cinema.domain.FilmResponse;
import com.koitoer.spring.integration.example.cinema.service.FilmServiceSOAP;

/**
 * @author mauricio.mena
 * @since 26/02/2015
 *
 */
@Endpoint
public class FilmEndpoint {

	/**
	 * 
	 */
	public FilmEndpoint() {
		System.out.println("FilmEndpoint");
	}

	@Autowired
	private FilmServiceSOAP filmService;

	/**
	 * @return
	 */
	@PayloadRoot(localPart = "filmRequest", namespace = "http://integration.webservice.koitoer.com/films")
	public @ResponsePayload
	FilmResponse getFilms() {
		System.out.println("sss");
		return buildResponse();
	}

	private FilmResponse buildResponse() {
		final FilmResponse response = new FilmResponse();
		for (final Film film : filmService.getFilms()) {
			response.getFilm().add(film);
		}
		return response;
	}
}