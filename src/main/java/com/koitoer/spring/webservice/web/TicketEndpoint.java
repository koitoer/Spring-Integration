package com.koitoer.spring.webservice.web;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.koitoer.spring.webservice.domain.TicketConfirmation;
import com.koitoer.spring.webservice.domain.TicketRequest;
import com.koitoer.spring.webservice.domain.TicketResponse;
import com.koitoer.spring.webservice.service.TicketService;
import com.koitoer.spring.webservice.util.DateUtils;

/**
 * @author mauricio.mena
 * @since 11/02/2015
 *
 */
@Endpoint
public class TicketEndpoint {

	/**
	 * 
	 */
	public TicketEndpoint() {
		System.out.println("Creating TicketEndpoint");
	}

	@Autowired
	private TicketService ticketService;

	private int retries;

	/**
	 * http://localhost:8080/spring-integration/tickets/ticketDefinition.wsdl
	 * @param ticketRequest
	 * @return TicketResponse
	 * @throws InterruptedException
	 */
	@PayloadRoot(localPart = "ticketRequest", namespace = "http://integration.webservice.koitoer.com/tickets")
	public @ResponsePayload
	TicketResponse order(@RequestPayload final TicketRequest ticketRequest) throws InterruptedException {
		final Calendar sessionDate = Calendar.getInstance();
		sessionDate.set(2013, 9, 26);

		final TicketConfirmation confirmation =
				ticketService.order(
						ticketRequest.getFilmId(), DateUtils.toDate(ticketRequest.getSessionDate()), ticketRequest
								.getQuantity().intValue());

		retries++;
		if (retries < 3) {
			throw new RuntimeException("not enough retries");
		}
		else {
			retries = 0;
		}

		System.out.println("System response : " + confirmation);
		return buildResponse(confirmation);
	}

	private TicketResponse buildResponse(final TicketConfirmation confirmation) {
		final TicketResponse response = new TicketResponse();
		response.setConfirmationId(confirmation.getConfirmationId());
		response.setFilmId(confirmation.getFilmId());
		response.setSessionDate(DateUtils.convertDate(confirmation.getSessionDate()));
		final BigInteger quantity = new BigInteger(Integer.toString(confirmation.getQuantity()));
		response.setQuantity(quantity);
		final BigDecimal amount = new BigDecimal(Float.toString(confirmation.getAmount()));
		response.setAmount(amount);

		return response;
	}
}