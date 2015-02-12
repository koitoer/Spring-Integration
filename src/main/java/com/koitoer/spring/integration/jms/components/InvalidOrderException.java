package com.koitoer.spring.integration.jms.components;

/**
 * @author mauricio.mena
 * @since 11/02/2015
 *
 */
public class InvalidOrderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param errorInvalidId
	 */
	public InvalidOrderException(final String errorInvalidId) {
		super(errorInvalidId);
	}

}
