package com.koitoer.spring.integration.rabbitmq;

import org.springframework.integration.annotation.Gateway;

/**
 * @author mauricio.mena
 * @since 11/02/2015
 *
 */
public interface AMQPService {

	/**
	 * @param message
	 */
	@Gateway
	public void sendMessage(String message);
}