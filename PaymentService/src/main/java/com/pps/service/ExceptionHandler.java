package com.pps.service;

import com.pps.model.PaymentException;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.component.bean.validator.BeanValidationException;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ExceptionHandler {

    public PaymentException handleException(BeanValidationException exception){
        Set<ConstraintViolation<Object>> constraintViolations = exception.getConstraintViolations();
        PaymentException paymentException = new PaymentException();
        List<PaymentException.Errors> errorsList = new ArrayList<>();
        for (ConstraintViolation constraintViolation:constraintViolations){
            PaymentException.Errors errors = new PaymentException.Errors();
            errors.setFieldName(String.valueOf(constraintViolation.getPropertyPath()));
            errors.setDescription(String.valueOf(constraintViolation.getMessage()));
            errorsList.add(errors);
        }
        paymentException.setErrors(errorsList);
        return  paymentException;
    }
}
