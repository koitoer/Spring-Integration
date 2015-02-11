/**
 * 
 */
package com.koitoer.spring.integration.service;

import org.springframework.integration.annotation.Gateway;

import com.koitoer.spring.webservice.domain.TicketRequest;

/**
 * @author Koitoer
 *
 */
public interface AsyncTicketService {
    @Gateway
    public void invoke(TicketRequest request);
}