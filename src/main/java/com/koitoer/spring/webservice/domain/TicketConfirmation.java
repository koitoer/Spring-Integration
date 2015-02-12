package com.koitoer.spring.webservice.domain;

import java.util.Date;
import java.util.UUID;

public final class TicketConfirmation {

	private String confirmationId;
	private String filmId;
	private int quantity;
	private Date sessionDate;
	private float amount;

	public TicketConfirmation(final String filmId, final Date sessionDate, final int quantity, final float amount) {
		this.confirmationId = UUID.randomUUID().toString();
		this.filmId = filmId;
		this.sessionDate = new Date(sessionDate.getTime());
		this.quantity = quantity;
		this.amount = amount;
	}

	public String getConfirmationId() {
		return confirmationId;
	}

	public String getFilmId() {
		return filmId;
	}

	public int getQuantity() {
		return quantity;
	}

	public Date getSessionDate() {
		return new Date(sessionDate.getTime());
	}

	public float getAmount() {
		return amount;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TicketConfirmation [confirmationId=" + confirmationId
				+ ", filmId=" + filmId + ", quantity=" + quantity
				+ ", sessionDate=" + sessionDate + ", amount=" + amount + "]";
	}

}