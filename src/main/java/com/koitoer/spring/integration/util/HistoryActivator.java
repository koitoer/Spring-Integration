/**
 * 
 */
package com.koitoer.spring.integration.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.Message;
import org.springframework.integration.history.MessageHistory;
import org.springframework.stereotype.Component;

/**
 * @author Koitoer
 *
 */
@Component("historyActivator")
public class HistoryActivator {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
 
    public void handle(Message<String> msg) {
        MessageHistory msgHistory = msg.getHeaders().get(MessageHistory.HEADER_NAME, MessageHistory.class);
        if (msgHistory != null) {
            logger.info("Components visited: {}", msgHistory.toString());
        }
    }
}