package com.pps.routes;

import com.pps.model.Payment;
import com.pps.service.ExceptionHandler;
import com.pps.service.PaymentService;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.bean.validator.BeanValidationException;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiRoute  {

    @Autowired
    CamelContext context;

    public void startRoutes() throws Exception {

        RouteBuilder routeBuilder = new RouteBuilder() {
            @Override
            public void configure() throws Exception {

                onException(BeanValidationException.class)
                        .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
                        .bean(ExceptionHandler.class,"handleException(${exception})")
                        .handled(true);

                restConfiguration()
                        .component("servlet")
                        .bindingMode(RestBindingMode.json);

                getContext().getGlobalOptions().put("CamelJacksonEnableTypeConverter","true");
                getContext().getGlobalOptions().put("CamelJacksonTypeConverterToPojo","true");

                rest("/api")
                        .id("api-route")
                        .consumes("application/json")
                        .post("/fraudCheck")
                        .type(Payment.class)
                        .to("direct:validateRequest");

                from("direct:validateRequest")
                        .to("bean-validator://x")
                        .bean(PaymentService.class,"sendToBs");

            }
        };
        context.addRoutes(routeBuilder);

    }

}
