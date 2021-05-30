package com.bs.listener;


import com.bs.config.JMSConfig;
import com.bs.routes.ApiRoute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    JMSConfig jmsConfig;

    @Autowired
    ApiRoute apiRoute;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("after startup initializing connection");
        jmsConfig.initializeMqConnection();
        System.out.println("initialization Completed");
        try {
            apiRoute.startRoutes();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
