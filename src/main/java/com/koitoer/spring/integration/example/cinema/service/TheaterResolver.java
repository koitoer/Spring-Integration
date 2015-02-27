package com.koitoer.spring.integration.example.cinema.service;

import org.springframework.integration.MessagingException;
import org.springframework.stereotype.Component;

/**
 * @author mauricio.mena
 * @since 26/02/2015
 *
 */
@Component
public class TheaterResolver {

	public String resolve(final MessagingException exc) {
		return "Just a string";
	}

}
