package com.koitoer.spring.integration.jmx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koitoer.spring.integration.jmx.notification.JmxNotificationGateway;


/**
 * @author Koitoer
 *
 */
@ContextConfiguration(locations = { "classpath:com/koitoer/spring/jmx-applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class JmxManagementTest {

	
	@Autowired
	private   JmxNotificationGateway jmxNotificationGateway;
	
	
	@Test
	public void testJmxNotification(){
		jmxNotificationGateway.send("Message to notify");
	}


}
