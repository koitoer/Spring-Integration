package com.koitoer.spring.integration.jms.components;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.koitoer.spring.webservice.domain.TicketConfirmation;

/**
 * @author mauricio.mena
 * @since 11/02/2015
 *
 */
@Component
public class OrderRepository {

	private List<TicketConfirmation> listOfConfirmations = new ArrayList<TicketConfirmation>();

	/**
	 * @param confirmation
	 */
	public void confirmOrder(final TicketConfirmation confirmation) {
		listOfConfirmations.add(confirmation);
		System.out.println("Order is confirmed -> " + confirmation);

	}

	/**
	 * @return
	 */
	public List<TicketConfirmation> getConfirmations() {
		return listOfConfirmations;
	}

}
