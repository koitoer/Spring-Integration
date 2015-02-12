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
	private Date orderDate;

	/**
	 * @param filmId
	 * @param quantity
	 * @param date
	 */
	public TicketOrder(final int filmId, final int quantity, final Date date) {
		super();
		this.filmId = filmId;
		this.quantity = quantity;
		this.orderDate = date;
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
	public void setFilmId(final int filmId) {
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
	public void setQuantity(final int quantity) {
		this.quantity = quantity;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(final Date orderDate) {
		this.orderDate = orderDate;
	}

}
