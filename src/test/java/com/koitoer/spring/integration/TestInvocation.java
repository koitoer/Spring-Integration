package com.koitoer.spring.integration;

import java.math.BigInteger;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.koitoer.spring.integration.service.TicketService;
import com.koitoer.spring.webservice.domain.TicketRequest;
import com.koitoer.spring.webservice.domain.TicketResponse;
import com.koitoer.spring.webservice.util.DateUtils;

@ContextConfiguration({"classpath:com/koitoer/spring/integration-applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestInvocation {
     
    @Autowired
    private TicketService service;
     
    @Test
    public void testInvocation() throws InterruptedException {
        TicketRequest request = new TicketRequest();
        request.setFilmId("aFilm");
        request.setQuantity(new BigInteger("3"));
        request.setSessionDate(DateUtils.convertDate(new Date()));
         
        TicketResponse response = service.invoke(request);
         
        System.out.println(response);
        Assert.assertNotNull(response);
        Assert.assertEquals("aFilm", response.getFilmId());
        Assert.assertEquals(new BigInteger("5"), response.getQuantity());
    }
}