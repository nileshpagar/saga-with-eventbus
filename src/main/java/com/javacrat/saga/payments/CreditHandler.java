package com.javacrat.saga.payments;

import com.javacrat.saga.StepHandler;

import java.util.Map;

public class CreditHandler implements StepHandler {
    @Override
    public void handle(Map<String, String> executionContext) {
        System.out.println("called CreditHandler for " + executionContext.get("PAYMENT_ID"));
    }
}
