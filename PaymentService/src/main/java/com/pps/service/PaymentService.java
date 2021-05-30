package com.pps.service;

import com.pps.model.Payment;
import org.apache.camel.Exchange;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.Entity;

@Component
public class PaymentService {

    public void sendToBs(Exchange ex){
        String payment = ex.getIn().getBody(String.class);
        String uri = "http://localhost:8081/brokerService/api/convert";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity(uri, payment, String.class);
        System.out.println(stringResponseEntity.getBody());
        ex.getIn().setBody(stringResponseEntity.getBody());
    }
}
