package com.bs.routes;

import com.bs.service.BrokerServiceImpl;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
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

                restConfiguration()
                        .component("servlet")
                        .bindingMode(RestBindingMode.json);

                getContext().getGlobalOptions().put("CamelJacksonEnableTypeConverter","true");
                getContext().getGlobalOptions().put("CamelJacksonTypeConverterToPojo","true");

                rest("/api")
                        .id("api-route")
                        .consumes("application/json")
                        .post("/convert")
                        .type(Payment.class)
                        .toD("direct:validateRequest");

                from("direct:validateRequest")
                        .log("${body}")
                .convertBodyTo(String.class)
                .bean(BrokerServiceImpl.class,"convert")
                .toD("aq:queue:testQueue")
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("In Processor");
                        System.out.println(exchange.getIn().getBody(String.class));
                    }
                })
                ;
            }
        };
        context.addRoutes(routeBuilder);

    }

}
