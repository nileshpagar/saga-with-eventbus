package com.javacrat.saga;

import java.util.HashMap;

public class SagaExecutionRuntime {

    public static SagaExecutionRuntime getInstance() {
        return new SagaExecutionRuntime();
    }

    public void startSaga(Saga saga, HashMap<String, String> executionContext) {

    }
}
