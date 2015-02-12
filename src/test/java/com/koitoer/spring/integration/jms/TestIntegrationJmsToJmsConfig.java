package com.koitoer.spring.integration.jms;

import java.rmi.RemoteException;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koitoer.spring.integration.jms.components.OrderRepository;
import com.koitoer.spring.integration.jms.domain.TicketOrder;
import com.koitoer.spring.integration.jms.service.TicketService;
import com.koitoer.spring.webservice.domain.TicketConfirmation;

/**
 * @author mauricio.mena
 * @since 11/02/2015
 *
 */
@ContextConfiguration(locations = { "classpath:com/koitoer/spring/jms-backend-applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestIntegrationJmsToJmsConfig {

	@Autowired
	private OrderRepository repository;

	@Autowired
	private TicketService service;

	/**
	 * @throws InterruptedException
	 * @throws RemoteException
	 */
	@Test
	public void testSendToJms() throws InterruptedException, RemoteException {
		final TicketOrder order = new TicketOrder(1, 5, new Date());
		service.sendOrder(order);

		Thread.sleep(4000);

		Assert.assertEquals(1, repository.getConfirmations().size());
		Assert.assertNotNull(repository.getConfirmations().get(0));
		final TicketConfirmation conf = repository.getConfirmations().get(0);
		Assert.assertEquals("123", conf.getConfirmationId());

	}
}
