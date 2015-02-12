package com.koitoer.spring.integration.jms;

import java.rmi.RemoteException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koitoer.spring.integration.jms.components.JmsProducer;
import com.koitoer.spring.integration.jms.components.OrderRepository;
import com.koitoer.spring.integration.jms.domain.TicketOrder;
import com.koitoer.spring.webservice.domain.TicketConfirmation;

/**
 * @author mauricio.mena
 * @since 11/02/2015
 *
 */
@ContextConfiguration(locations = { "classpath:com/koitoer/spring/jms-applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestIntegrationJms {

	@Autowired
	private JmsProducer producer;

	@Autowired
	private OrderRepository repository;

	/**
	 * @throws InterruptedException
	 * @throws RemoteException
	 */
	@Test
	public void testSendToIntegration() throws InterruptedException, RemoteException {
		final TicketOrder order = new TicketOrder(1, 5, new Date());
		// Sends the message to the jmsTemplate's default destination
		producer.convertAndSendMessage("int.sync.queue", order);

		Thread.sleep(10000);

		Assert.assertEquals(1, repository.getConfirmations().size());
		Assert.assertNotNull(repository.getConfirmations().get(0));
		final TicketConfirmation conf = repository.getConfirmations().get(0);
		System.out.println("Obtain ticketConfirmation in client : " + conf);
		Assert.assertNotNull("123", conf.getConfirmationId());
	}
}