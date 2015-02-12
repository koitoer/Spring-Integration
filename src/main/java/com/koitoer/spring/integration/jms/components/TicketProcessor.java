package com.koitoer.spring.integration.jms.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.koitoer.spring.integration.jms.domain.TicketOrder;
import com.koitoer.spring.webservice.domain.TicketConfirmation;

/**
 * @author mauricio.mena
 * @since 11/02/2015
 *
 */
@Component("ticketProcessor")
public class TicketProcessor {

	private static final Logger logger = LoggerFactory.getLogger(TicketProcessor.class);
	private static final String ERROR_INVALID_ID = "Order ID is invalid";

	@Autowired
	private OrderRepository orderRepository;

	/**
	 * @param order
	 */
	public void processOrder(final TicketOrder order) {
		TicketProcessor.logger.info("Processing order {}", order.getFilmId());

		if (isInvalidOrder(order)) {
			TicketProcessor.logger.info("Error while processing order [{}]", TicketProcessor.ERROR_INVALID_ID);
			throw new InvalidOrderException(TicketProcessor.ERROR_INVALID_ID);
		}

		final float amount = 5.95f * order.getQuantity();

		final TicketConfirmation confirmation =
				new TicketConfirmation(String.valueOf(order.getFilmId()), order.getOrderDate(), order.getQuantity(),
						amount);
		orderRepository.confirmOrder(confirmation);
	}

	/**
	* @param confirmation
	*/
	public void registerOrderConfirmation(final TicketConfirmation confirmation) {
		orderRepository.confirmOrder(confirmation);
	}

	private boolean isInvalidOrder(final TicketOrder order) {
		if (order.getFilmId() == -1) {
			return true;
		}
		return false;
	}
}