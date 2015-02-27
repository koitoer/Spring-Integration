package com.koitoer.spring.integration.example.cinema.components;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.koitoer.spring.integration.example.cinema.TheaterApp;
import com.koitoer.spring.integration.example.cinema.model.ShutdownEvent;

/**
 * @author mauricio.mena
 * @since 26/02/2015
 *
 */
@Component("shutdownListener")
public class ShutdownListener implements ApplicationListener<ShutdownEvent> {

	@Override
	public void onApplicationEvent(final ShutdownEvent event) {
		TheaterApp.shutdown();
	}
}