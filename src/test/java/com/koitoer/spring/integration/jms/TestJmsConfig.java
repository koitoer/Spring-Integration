/**
 * 
 */
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
import com.koitoer.spring.integration.jms.components.SyncConsumer;
import com.koitoer.spring.integration.jms.domain.TicketOrder;

@ContextConfiguration(locations = {"classpath:com/koitoer/spring/jsmConfig-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestJmsConfig {
    @Autowired
    private JmsProducer producer;
     
    @Autowired
    private SyncConsumer consumer;
     
    @Test
    public void testReceiving() throws InterruptedException, RemoteException {
        TicketOrder order = new TicketOrder(1, 5, new Date());
        //Sends the message to the jmsTemplate's default destination
        producer.convertAndSendMessage(order);
         
        Thread.sleep(2000);
         
        TicketOrder receivedOrder = consumer.receive();
        Assert.assertNotNull(receivedOrder);
        Assert.assertEquals(1, receivedOrder.getFilmId());
        Assert.assertEquals(5, receivedOrder.getQuantity());
    }
}