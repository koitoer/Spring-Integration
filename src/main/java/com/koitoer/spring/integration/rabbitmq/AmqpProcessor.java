package com.koitoer.spring.integration.rabbitmq;

import org.springframework.integration.Message;
import org.springframework.stereotype.Component;

/**
 * @author mauricio.mena
 * @since 11/02/2015
 *
 */
@Component("amqpProcessor")
public class AmqpProcessor {

	/**
	 * @param msg
	 */
	public void process(final Message<String> msg) {
		System.out.println("Message received: " + msg.getPayload());
	}
}