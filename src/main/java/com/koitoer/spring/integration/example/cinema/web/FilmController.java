package com.koitoer.spring.integration.example.cinema.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koitoer.spring.integration.example.cinema.domain.Film;
import com.koitoer.spring.integration.example.cinema.service.FilmServiceI;

/**
 * @author mauricio.mena
 * @since 26/02/2015
 *
 */
@Controller
@RequestMapping(value = "/films")
public class FilmController {

	private FilmServiceI filmService;

	@Autowired
	public FilmController(final FilmServiceI service) {
		this.filmService = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody
	Film[] getFilms() {
		return filmService.getFilms();
	}
}