/**
 * 
 */
package com.koitoer.spring.integration.jmx.mbean;

import java.util.Random;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

/**
 * @author Koitoer
 *
 */
@Component("pollingMbean")
@ManagedResource
public class JmxPollingMBean {
     
    @ManagedAttribute
    public int getNumber() {
        Random rnd = new Random();
        int randomNum = rnd.nextInt(100);
        return randomNum;
    }
}