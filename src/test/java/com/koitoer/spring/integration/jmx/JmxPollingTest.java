/**
 * 
 */
package com.koitoer.spring.integration.jmx;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koitoer.spring.integration.jmx.mbean.JmxOperationMBean;
import com.koitoer.spring.integration.jmx.notification.JmxNotificationGateway;

/**
 * @author Koitoer
 *
 */
@ContextConfiguration(locations = { "classpath:com/koitoer/spring/jmx-polling-applicationContext.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class JmxPollingTest {
	
	@Autowired
	private JmxNotificationGateway jmxOperationGateway;
	
	@Test
	public void pollMBean() throws InterruptedException{
		Thread.sleep(5000);
	}

	
	@Test
	public void invokingMbeanOperation() throws InterruptedException{
		jmxOperationGateway.send("World");
        Thread.sleep(10000);
	}
	
	@Test
	public void exportMbeanTest() throws InterruptedException{
		jmxOperationGateway.send("message 1");
	    Thread.sleep(50000);
	    jmxOperationGateway.send("message 2");
	    Thread.sleep(50000);
	    jmxOperationGateway.send("message 3");
	}
}
