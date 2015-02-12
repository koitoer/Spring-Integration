package com.koitoer.spring.integration.jms.service;

import org.springframework.integration.annotation.Gateway;

import com.koitoer.spring.integration.jms.domain.TicketOrder;

/**
 * @author mauricio.mena
 * @since 11/02/2015
 *
 */
public interface TicketService {

	/**
	 * @param order
	 */
	@Gateway
	public void sendOrder(TicketOrder order);

}
