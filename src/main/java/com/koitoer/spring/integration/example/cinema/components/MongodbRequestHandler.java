package com.koitoer.spring.integration.example.cinema.components;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.MessagingException;
import org.springframework.stereotype.Component;

import com.koitoer.spring.integration.example.cinema.service.TheaterResolver;

/**
 * @author mauricio.mena
 * @since 26/02/2015
 *
 */
@Component("mongodbRequestHandler")
public class MongodbRequestHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TheaterResolver theaterResolver;

	/**
	 * @param exc
	 * @return
	 */
	public FailedMessage handle(final MessagingException exc) {
		logger.error("Request failed. Storing to the database");

		final String theater = theaterResolver.resolve(exc);
		final FailedMessage failedMsg = new FailedMessage(new Date(), exc.getMessage(), theater);

		return failedMsg;
	}
}