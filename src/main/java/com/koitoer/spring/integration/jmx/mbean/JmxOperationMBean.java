/**
 * 
 */
package com.koitoer.spring.integration.jmx.mbean;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * @author Koitoer
 *
 */
@Component("operationMbean")
@ManagedResource
public class JmxOperationMBean {
     
    @ManagedOperation
    public String hello(String name) {
        return "Hello " + name;
    }
}
