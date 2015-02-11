/**
 * 
 */
package com.koitoer.spring.integration.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.Message;
import org.springframework.integration.MessageHandlingException;
import org.springframework.integration.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

@Component("clientServiceActivator")
public class ClientServiceActivator {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
 
    @Autowired
    @Qualifier("retryAdapter")
    private AbstractEndpoint retryAdapter;
     
    private Message<?> message;
 
    public void handleServiceResult(Message<?> msg) {
        logger.info("service successfully invoked. Finishing flow");
        retryAdapter.stop();
    }
 
    public void retryFailedInvocation(Message<?> msg) {
        logger.info("Service invocation failed. Activating retry trigger...");
        MessageHandlingException exc = (MessageHandlingException) msg.getPayload();
        this.message = exc.getFailedMessage();
        retryAdapter.start();
    }
 
    public Message<?> retryInvocation() {
        logger.info("Retrying service invocation...");
 
        return message;
    }
 
    public void handleFailedInvocation(MessageHandlingException exception) {
        logger.info("Maximum number of retries reached. Finishing flow.");
        retryAdapter.stop();
    }
}