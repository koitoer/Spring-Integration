package com.koitoer.spring.integration.example.cinema.model;

import org.springframework.context.ApplicationEvent;

/**
 * @author mauricio.mena
 * @since 26/02/2015
 *
 */
public class ShutdownEvent extends ApplicationEvent {

	private static final long serialVersionUID = -198696884593684436L;

	public ShutdownEvent(final Object source) {
		super(source);
	}

	public ShutdownEvent(final Object source, final String message) {
		super(source);
	}

	@Override
	public String toString() {
		return "Shutdown event";
	}
}
