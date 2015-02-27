/**
 * 
 */
package com.koitoer.spring.integration.util.metadata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.Message;
import org.springframework.stereotype.Component;

/**
 * @author Koitoer
 *
 */
@Component("metadataActivator")
public class MetadataActivator {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
 
    public void process(Message<String> msg) {
        logger.info("Message processed: {}", msg.getPayload());
    }
     
    public void discard(Message<String> msg) {
        logger.info("Message discarded: {}", msg.getPayload());
    }
}
