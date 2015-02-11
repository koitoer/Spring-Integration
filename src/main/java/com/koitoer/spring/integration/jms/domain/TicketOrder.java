/**
 * 
 */
package com.koitoer.spring.integration.jms.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Koitoer
 *
 */
public class TicketOrder implements Serializable {

	private int filmId;
	private int quantity;
	private Date date;
	/**
	 * @param filmId
	 * @param quantity
	 * @param date
	 */
	public TicketOrder(int filmId, int quantity, Date date) {
		super();
		this.filmId = filmId;
		this.quantity = quantity;
		this.date = date;
	}
	/**
	 * @return the filmId
	 */
	public int getFilmId() {
		return filmId;
	}
	/**
	 * @param filmId the filmId to set
	 */
	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}
	/**
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	

	

}
