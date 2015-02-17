/**
 * 
 */
package com.koitoer.spring.integration.jmx.service;

import javax.management.Notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.Message;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component("notificationHandler")
public class NotificationHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String NOTIFICATION_TYPE_HEADER = "jmx_notificationType";
     
    public void receive(Message<Notification> msg) {
        logger.info("Notification received: {}", msg.getPayload().getType());
    }
     
    public Message<Notification> buildNotification(Message<String> msg) {
        Notification notification = new Notification(msg.getPayload(), this, 0);
        System.out.println("Creating notification");
        return MessageBuilder.withPayload(notification)
                .copyHeadersIfAbsent(msg.getHeaders()).setHeader(NOTIFICATION_TYPE_HEADER, "myJmxNotification").build();
    }
}