/**
 * 
 */
package com.koitoer.spring.integration.jms.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;

import com.koitoer.spring.integration.jms.domain.TicketOrder;

/**
 * @author Koitoer
 *
 */
public class SyncConsumer {

	@Autowired
	private JmsTemplate jmsTemplate;

	/**
	 * @return
	 */
	public TicketOrder receive() {
		return (TicketOrder) jmsTemplate.receiveAndConvert("test.sync.queue");
	}

	/**
	 * @param queue 
	 * @return
	 */
	public TicketOrder receive(final String queue) {
		return (TicketOrder) jmsTemplate.receiveAndConvert(queue);
	}
}