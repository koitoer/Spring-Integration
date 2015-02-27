package com.koitoer.spring.integration.example.cinema.service;

import java.util.List;

import com.koitoer.spring.integration.example.cinema.domain.Film;

/**
 * @author mauricio.mena
 * @since 26/02/2015
 *
 */
public interface FilmService {

	List<Film> getFilms();

}
