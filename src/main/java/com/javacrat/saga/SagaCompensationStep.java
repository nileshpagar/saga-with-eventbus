package com.javacrat.saga;

public class SagaCompensationStep extends SagaStep {

    private SagaStep forStep;

    public SagaCompensationStep(String id, String name, Class<StepHandler> stepHandlerClass) {
        super(id, name, stepHandlerClass);
        this.forStep = forStep;
    }

}
