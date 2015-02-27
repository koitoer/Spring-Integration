/**
 * 
 */
package com.koitoer.spring.integration.util;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.koitoer.spring.integration.util.persistence.MsgStoreGateway;

/**
 * @author Koitoer
 *
 */
public class MsgStoreApp {
    public static void main(String[] args) throws InterruptedException {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath:com/koitoer/spring/integration-persistence-applicationContext.xml");
        MsgStoreGateway gateway = context.getBean(MsgStoreGateway.class);
        gateway.send("myMessage");
        Thread.sleep(300000);
        context.close();
    }
}