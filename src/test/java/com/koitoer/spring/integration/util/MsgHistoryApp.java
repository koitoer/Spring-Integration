/**
 * 
 */
package com.koitoer.spring.integration.util;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Koitoer
 *
 */
public class MsgHistoryApp {


	/**
	 * @param args
	 */
	    public static void main(String[] args) throws InterruptedException {
	        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/koitoer/spring/integration-util-applicationContext.xml");
	         
	        HistoryGateway gateway = context.getBean(HistoryGateway.class);
	        gateway.send("myTest");
	        Thread.sleep(1000);
	        context.close();
	    }
	}

