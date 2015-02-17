/**
 * 
 */
package com.koitoer.spring.integration.util;

import org.springframework.integration.annotation.Gateway;

/**
 * @author Koitoer
 *
 */
public interface HistoryGateway {

	@Gateway
	public void send(String args);
	
}
