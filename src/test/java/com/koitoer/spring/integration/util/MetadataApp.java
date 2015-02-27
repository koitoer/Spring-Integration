/**
 * 
 */
package com.koitoer.spring.integration.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;

import com.koitoer.spring.integration.util.metadata.MetadataGateway;

/**
 * @author Koitoer
 *
 */
public class MetadataApp {
    private static final String MESSAGE_STORE_HEADER = "messageId";
     
    public static void main(String[] args) throws InterruptedException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/koitoer/spring/integration-util-idem-applicationContext.xml");
         
        MetadataGateway gateway = context.getBean(MetadataGateway.class);
         
        Map<String,String> headers = new HashMap<String, String>();
        headers.put(MESSAGE_STORE_HEADER, "msg1");
        Message<String> msg1 = MessageBuilder.withPayload("msg1").copyHeaders(headers).build();
         
        headers = new HashMap<String, String>();
        headers.put(MESSAGE_STORE_HEADER, "msg2");
        Message<String> msg2 = MessageBuilder.withPayload("msg2").copyHeaders(headers).build();
         
        gateway.sendMessage(msg1);
        Thread.sleep(500);
        gateway.sendMessage(msg1);
        Thread.sleep(500);
        gateway.sendMessage(msg2);
         
        Thread.sleep(3000);
        context.close();
    }
}