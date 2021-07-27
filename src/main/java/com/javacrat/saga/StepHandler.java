package com.javacrat.saga;

import java.util.Map;

public interface StepHandler {

    void handle(Map<String, String> executionContext);

}
