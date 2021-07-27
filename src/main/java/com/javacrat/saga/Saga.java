package com.javacrat.saga;

import com.javacrat.saga.payments.CreditHandler;
import com.javacrat.saga.payments.DebitHandler;
import com.javacrat.saga.payments.ReverseDebitHandler;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.UUID;

public class Saga {

    private String id;
    private String name;
    private LinkedList<SagaStep> steps = new LinkedList<>();
    private Class<Exception> triggerCompensationOn;

    public static Saga define() {
        return new Saga(UUID.randomUUID().toString());
    }

    public Saga(String id) {
        this.id = id;
    }

    public Saga name(String name) {
        this.name = name;
        return this;
    }

    public Saga step(String name, Class handlerClass) {
        SagaStep sagaStep = new SagaStep(UUID.randomUUID().toString(), name, handlerClass);
        if (sagaStep != null)
            steps.add(sagaStep);
        return this;
    }

    public Saga compensationStep(String name, Class handlerClass) {
        SagaCompensationStep compensationStep = new SagaCompensationStep(UUID.randomUUID().toString(), name, handlerClass);
        steps.getLast().setCompensationStep(compensationStep);
        return this;
    }

    public Saga done() {
        return this;
    }

    public Saga triggerCompensationOn(Class<Exception> exceptionClass) {
        this.triggerCompensationOn = exceptionClass;
        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LinkedList<SagaStep> getSteps() {
        return steps;
    }

    public Class<Exception> getTriggerCompensationOn() {
        return triggerCompensationOn;
    }

    public static void main(String[] args) {
        Saga saga = Saga.define()
                .name("make-payment")
                .step("DEBIT", DebitHandler.class)
                .compensationStep("REVERSE", ReverseDebitHandler.class)
                .step("CREDIT", CreditHandler.class)
                .triggerCompensationOn(Exception.class)
                .done();

        HashMap<String, String> executionContext = new HashMap<>();
        executionContext.put("PAYMENT_ID", UUID.randomUUID().toString());
        SagaExecutionRuntime.getInstance()
                .startSaga(saga, executionContext);
    }

}
