/**
 * 
 */
package com.koitoer.spring.integration.util.bus;

import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.stereotype.Component;

/**
 * @author Koitoer
 *
 */
@Component("controlbusBean")
public class ControlBusBean {
 
    @ManagedOperation
    public String greet(String name) {
        return "Hello " + name;
    }
}