/**
 * 
 */
package com.koitoer.spring.integration.util;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.MessageChannel;
import org.springframework.integration.support.MessageBuilder;

/**
 * @author Koitoer
 *
 */
public class ControlBusApp {
    public static void main(String[] args) throws InterruptedException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/koitoer/spring/integration-util-bus-applicationContext.xml");
        MessageChannel channel = context.getBean("entryChannel", MessageChannel.class);
         
        Message<String> msg = MessageBuilder.withPayload("@controlbusBean.greet('World!')").build();
        channel.send(msg);
         
        Thread.sleep(3000);
        context.close();
    }
}