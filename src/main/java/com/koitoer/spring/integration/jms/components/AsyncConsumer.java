package com.koitoer.spring.integration.jms.components;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

import com.koitoer.spring.integration.jms.domain.TicketOrder;
import com.koitoer.spring.webservice.domain.TicketConfirmation;

/**
 * @author mauricio.mena
 * @since 11/02/2015
 *
 */
@Component("asyncConsumer")
public class AsyncConsumer implements MessageListener {

	@Autowired
	private JmsTemplate template;

	@Override
	public void onMessage(final Message order) {
		System.out.println("Order is received in the external system ready to send back the response");
		final Message msgOrder = order;
		TicketOrder orderObject;
		try {
			orderObject = (TicketOrder) ((ObjectMessage) order).getObject();
		}
		catch (final JMSException e) {
			throw JmsUtils.convertJmsAccessException(e);
		}
		final float amount = 5.95f * orderObject.getQuantity();
		final TicketConfirmation confirmation =
				new TicketConfirmation("321", orderObject.getFilmId(), orderObject.getOrderDate(), orderObject
						.getQuantity(), amount);

		try {
			template.convertAndSend(msgOrder.getJMSReplyTo(), confirmation, new MessagePostProcessor() {

				@Override
				public Message postProcessMessage(final Message message) throws JMSException {
					message.setJMSCorrelationID(msgOrder.getJMSCorrelationID());

					return message;
				}
			});
		}
		catch (final JMSException e) {
			throw JmsUtils.convertJmsAccessException(e);
		}
	}
}