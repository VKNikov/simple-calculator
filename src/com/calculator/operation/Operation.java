package com.calculator.operation;

public interface Operation {
    boolean isApplicable(com.calculator.Operation operation);

    double calculate(double a, double b);
}
