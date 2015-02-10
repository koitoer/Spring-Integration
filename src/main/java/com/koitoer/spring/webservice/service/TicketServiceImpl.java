package com.koitoer.spring.webservice.service;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.koitoer.spring.webservice.domain.TicketConfirmation;

@Service
public class TicketServiceImpl implements TicketService {
 
    @Override
    public TicketConfirmation order(String filmId, Date sessionDate, int quantity) {
        float amount = 5.95f * quantity;
        TicketConfirmation confirmation = new TicketConfirmation(filmId, sessionDate, quantity, amount);
         
        return confirmation;
    }
}