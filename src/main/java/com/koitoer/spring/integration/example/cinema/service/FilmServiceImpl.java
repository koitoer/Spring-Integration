package com.koitoer.spring.integration.example.cinema.service;

import org.springframework.stereotype.Service;

import com.koitoer.spring.integration.example.cinema.domain.Film;

/**
 * @author mauricio.mena
 * @since 26/02/2015
 *
 */
@Service("filmService")
public class FilmServiceImpl implements FilmServiceI {

	@Override
	public Film[] getFilms() {
		final Film film1 = new Film(1, "Bladerunner", "10am");
		final Film film2 = new Film(2, "Gran Torino", "12pm");

		return new Film[] { film1, film2 };
	}
}
