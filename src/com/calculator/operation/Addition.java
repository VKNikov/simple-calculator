package com.calculator.operation;

public class Addition implements Operation {

    private final com.calculator.Operation operation = com.calculator.Operation.ADD;

    @Override
    public boolean isApplicable(com.calculator.Operation operation) {
        return this.operation.equals(operation);
    }

    @Override
    public double calculate(double a, double b) {
        return operation.calculate(a, b);
    }
}
