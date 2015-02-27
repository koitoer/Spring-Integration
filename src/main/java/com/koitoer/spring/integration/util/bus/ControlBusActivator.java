/**
 * 
 */
package com.koitoer.spring.integration.util.bus;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.Message;
import org.springframework.stereotype.Component;

/**
 * @author Koitoer
 *
 */
@Component("controlbusActivator")
public class ControlBusActivator {

	 private Logger logger = LoggerFactory.getLogger(this.getClass());
	 
	    public void process(Message<String> msg) {
	        logger.info("Message processed: {}", msg.getPayload());
	    }
	     
	 
}


