/**
 * 
 */
package com.koitoer.spring.integration.util.persistence;

import org.springframework.integration.annotation.Gateway;

/**
 * @author Koitoer
 *
 */
public interface MsgStoreGateway {

	@Gateway
	public void send(String args);
	
}
