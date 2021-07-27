package com.javacrat.saga;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SagaStep {
    private String name;
    private String id;
    private Class<StepHandler> stepHandlerClass;
    public SagaCompensationStep compensationStep;

    public SagaStep(String id, String name, Class<StepHandler> stepHandlerClass) {
        this.id = id;
        this.name = name;
        this.stepHandlerClass = stepHandlerClass;
    }

    public void setCompensationStep(SagaCompensationStep compensationStep) {
        this.compensationStep = compensationStep;
    }

    public SagaCompensationStep getCompensationStep() {
        return compensationStep;
    }
}
