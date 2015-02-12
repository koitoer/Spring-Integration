/**
 * 
 */
package com.koitoer.spring.integration.jms.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.core.JmsTemplate;

import com.koitoer.spring.integration.jms.domain.TicketOrder;

/**
 * @author Koitoer
 *
 */
public class JmsProducer {

	@Autowired
	@Qualifier("jmsTemplate")
	private JmsTemplate jmsTemplate;

	/**
	 * @param order
	 */
	public void convertAndSendMessage(final TicketOrder order) {
		jmsTemplate.convertAndSend(order);
	}

	/**
	 * @param destination
	 * @param order
	 */
	public void convertAndSendMessage(final String destination, final TicketOrder order) {
		jmsTemplate.convertAndSend(destination, order);
	}
}