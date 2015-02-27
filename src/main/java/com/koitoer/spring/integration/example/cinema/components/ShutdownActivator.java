package com.koitoer.spring.integration.example.cinema.components;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import com.koitoer.spring.integration.example.cinema.model.ShutdownEvent;

@Component("shutdownActivator")
public class ShutdownActivator {

	@ServiceActivator
	public ShutdownEvent createEvent(final Message<String> msg) {
		return new ShutdownEvent(this);
	}
}