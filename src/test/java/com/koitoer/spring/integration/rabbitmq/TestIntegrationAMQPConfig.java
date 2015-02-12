package com.koitoer.spring.integration.rabbitmq;

import java.rmi.RemoteException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author mauricio.mena
 * @since 11/02/2015
 *
 */
@ContextConfiguration(locations = { "classpath:com/koitoer/spring/rabbitMq-applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestIntegrationAMQPConfig {

	@Autowired
	private AMQPService service;

	/**
	 * @throws InterruptedException
	 * @throws RemoteException
	 */
	@Test
	public void testSendToJms() throws InterruptedException, RemoteException {
		final String msg = "hello";

		service.sendMessage(msg);

		Thread.sleep(2000);
	}
}