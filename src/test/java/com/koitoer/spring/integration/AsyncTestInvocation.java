package com.koitoer.spring.integration;

import java.math.BigInteger;
import java.util.Date;
import java.util.concurrent.ExecutionException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koitoer.spring.integration.service.AsyncTicketService;
import com.koitoer.spring.integration.service.TicketService;
import com.koitoer.spring.webservice.domain.TicketRequest;
import com.koitoer.spring.webservice.domain.TicketResponse;
import com.koitoer.spring.webservice.util.DateUtils;

@ContextConfiguration({"classpath:com/koitoer/spring/async-integration-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class AsyncTestInvocation {
     
    @Autowired
    private AsyncTicketService service;
 
        @Test
        public void testInvocation() throws InterruptedException, ExecutionException {
            TicketRequest request = new TicketRequest();
            request.setFilmId("aFilm");
            request.setQuantity(new BigInteger("3"));
            request.setSessionDate(DateUtils.convertDate(new Date()));
             
            service.invoke(request);
            Thread.sleep(80000);
        }
    }
