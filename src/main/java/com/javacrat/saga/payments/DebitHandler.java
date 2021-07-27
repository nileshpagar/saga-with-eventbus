package com.javacrat.saga.payments;

import com.javacrat.saga.StepHandler;

import java.util.Map;

public class DebitHandler implements StepHandler {
    @Override
    public void handle(Map<String, String> executionContext) {
        System.out.println("called DebitHandler for " + executionContext.get("PAYMENT_ID"));
    }
}
