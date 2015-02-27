package com.koitoer.spring.integration.example.cinema.components;

import java.io.Serializable;
import java.util.Date;

/**
 * @author mauricio.mena
 * @since 26/02/2015
 *
 */
public class FailedMessage implements Serializable {

	private static final long serialVersionUID = 4411815706008283621L;

	private final Date requestDate;
	private final String messsage;
	private final String theater;

	public FailedMessage(final Date requestDate, final String message, final String theater) {
		this.requestDate = requestDate;
		this.messsage = message;
		this.theater = theater;
	}

	public Date getRequestDate() {
		return new Date(requestDate.getTime());
	}

	public String getMessage() {
		return this.messsage;
	}

	public String getTheater() {
		return this.theater;
	}
}