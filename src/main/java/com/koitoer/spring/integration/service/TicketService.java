/**
 * 
 */
package com.koitoer.spring.integration.service;

import java.util.Date;

import org.springframework.integration.annotation.Gateway;

import com.koitoer.spring.webservice.domain.TicketConfirmation;
import com.koitoer.spring.webservice.domain.TicketRequest;
import com.koitoer.spring.webservice.domain.TicketResponse;

/**
 * @author Koitoer
 *
 */
public interface TicketService {
	
	@Gateway
	public TicketResponse invoke(TicketRequest request);
}
