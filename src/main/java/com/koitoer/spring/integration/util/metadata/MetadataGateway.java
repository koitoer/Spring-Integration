/**
 * 
 */
package com.koitoer.spring.integration.util.metadata;

import org.springframework.integration.Message;
import org.springframework.integration.annotation.Gateway;

/**
 * @author Koitoer
 *
 */
public interface MetadataGateway {

	@Gateway
	public void sendMessage(Message<String> args);
	
}
