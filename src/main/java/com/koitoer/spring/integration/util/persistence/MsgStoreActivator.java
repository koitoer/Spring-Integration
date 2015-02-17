/**
 * 
 */
package com.koitoer.spring.integration.util.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.Message;
import org.springframework.integration.MessageHandlingException;
import org.springframework.integration.endpoint.AbstractEndpoint;
import org.springframework.stereotype.Component;

@Component("msgStoreActivator")
public class MsgStoreActivator {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
 
 
    public void handleServiceResult(Message<?> msg) {
        logger.info("service successfully invoked. Finishing flow");
  
    }
 
}