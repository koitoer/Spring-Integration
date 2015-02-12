package com.koitoer.spring.webservice.service;

import java.util.Date;

import org.springframework.integration.annotation.Gateway;

import com.koitoer.spring.webservice.domain.TicketConfirmation;

public interface TicketService {
	 
    public TicketConfirmation order(String filmId, Date sessionDate, int quantity);
}