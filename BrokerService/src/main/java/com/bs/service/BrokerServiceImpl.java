package com.bs.service;

import com.bs.routes.Payment;
import org.apache.camel.Exchange;
import org.json.JSONObject;
import org.json.XML;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;

public class BrokerServiceImpl {

    public void convert(Exchange ex) throws JAXBException {
        String str = ex.getIn().getBody(String.class);
        JSONObject jsonObject = new JSONObject(str);
        String resp = XML.toString(jsonObject);

        ex.getIn().setBody(resp);
    }
}
