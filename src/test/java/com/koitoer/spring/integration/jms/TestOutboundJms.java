package com.koitoer.spring.integration.jms;

import java.rmi.RemoteException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koitoer.spring.integration.jms.components.SyncConsumer;
import com.koitoer.spring.integration.jms.domain.TicketOrder;
import com.koitoer.spring.integration.jms.service.TicketService;

/**
 * @author mauricio.mena
 * @since 11/02/2015
 *
 */
@ContextConfiguration(locations = { "classpath:com/koitoer/spring/jms-outbound-applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestOutboundJms {

	@Autowired
	private SyncConsumer consumer;

	@Autowired
	private TicketService service;

	/**
	 * @throws InterruptedException
	 * @throws RemoteException
	 */
	@Test
	public void testSendToJms() throws InterruptedException, RemoteException {
		final TicketOrder order = new TicketOrder(1, 5, new Date());
		System.out.println("Order ready to be sent : " + order);
		service.sendOrder(order);

		final TicketOrder receivedOrder = consumer.receive("to.jms.queue");
		System.out.println("Received ticketOrder : " + receivedOrder);
		Assert.assertNotNull(receivedOrder);
		Assert.assertEquals(1, receivedOrder.getFilmId());
		Assert.assertEquals(5, receivedOrder.getQuantity());
	}
}