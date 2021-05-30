package com.fraudcheck.application.routes;


import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiRoute {

    @Autowired
    CamelContext context;

    public void startRoutes() throws Exception {

        RouteBuilder routeBuilder = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("aq:queue:testQueue")
                        .log("${body}")
                .log("In Fraud Check")
                .setBody(simple("From Fraudcheck"));

            }
        };
        context.addRoutes(routeBuilder);

    }

}
