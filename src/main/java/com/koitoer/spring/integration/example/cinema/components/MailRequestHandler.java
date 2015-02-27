package com.koitoer.spring.integration.example.cinema.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.MessagingException;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import com.koitoer.spring.integration.example.cinema.service.TheaterResolver;

/**
 * @author mauricio.mena
 * @since 26/02/2015
 *
 */
@Component("mailRequestHandler")
public class MailRequestHandler {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private TheaterResolver theaterResolver;

	@ServiceActivator
	public MailMessage handle(final MessagingException exc) {
		logger.error("Request failed. Sending mail");

		final MailMessage mailMsg = new SimpleMailMessage();
		mailMsg.setFrom("Theater.System");
		mailMsg.setTo("my.mail@gmail.com");
		mailMsg.setSubject("theater request failed");

		final String theater = theaterResolver.resolve(exc);
		final StringBuilder textMessage = new StringBuilder("Invocation to ").append(theater).append(" failed\n\n")
				.append("Error message was: ").append(exc.getMessage());
		mailMsg.setText(textMessage.toString());

		return mailMsg;
	}
}