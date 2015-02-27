package com.koitoer.spring.integration.example.cinema.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.koitoer.spring.integration.example.cinema.domain.Film;

@Service
public class FilmServiceSOAP implements FilmService {

	@Override
	public List<Film> getFilms() {
		final List<Film> films = new ArrayList<Film>();

		Film film = new Film();
		film.setId(new BigInteger(("1")));
		film.setName("The Good, the Bad and the Uggly");
		film.setShowtime("6pm");
		films.add(film);

		film = new Film();
		film.setId(new BigInteger(("2")));
		film.setName("The Empire strikes back");
		film.setShowtime("8pm");
		films.add(film);

		return films;
	}
}