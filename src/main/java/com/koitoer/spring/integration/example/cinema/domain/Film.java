package com.koitoer.spring.integration.example.cinema.domain;

import java.io.Serializable;
import java.math.BigInteger;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author mauricio.mena
 * @since 26/02/2015
 *
 */
@XmlRootElement
public class Film implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private BigInteger id;
	private String name;
	private String showtime;

	public Film(final int i, final String name, final String showtime) {
		this.id = BigInteger.valueOf(i);
		this.name = name;
		this.showtime = showtime;

	}

	public Film() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the id
	 */
	public BigInteger getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(final BigInteger id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @return the showtime
	 */
	public String getShowtime() {
		return showtime;
	}

	/**
	 * @param showtime the showtime to set
	 */
	public void setShowtime(final String showtime) {
		this.showtime = showtime;
	}

}
