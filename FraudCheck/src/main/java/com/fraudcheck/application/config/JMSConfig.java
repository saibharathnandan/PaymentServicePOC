package com.fraudcheck.application.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

@Component
public class JMSConfig {

    @Autowired
    CamelContext context;

    public void initializeMqConnection(){
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        context.addComponent("aq", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
    }
}
