package com.koitoer.spring.integration.example.cinema.domain;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author mauricio.mena
 * @since 26/02/2015
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class FilmResponse {

	@XmlElement
	private List<Film> film = new ArrayList<Film>();

	/**
	 * @return the film
	 */
	public List<Film> getFilm() {
		return film;
	}

	/**
	 * @param film the film to set
	 */
	public void setFilm(final List<Film> film) {
		this.film = film;
	}

}
