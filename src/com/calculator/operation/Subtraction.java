package com.calculator.operation;

public class Subtraction implements Operation{

    private final com.calculator.Operation operation = com.calculator.Operation.SUBTRACT;

    @Override
    public boolean isApplicable(com.calculator.Operation operation) {
        return this.operation.equals(operation);
    }

    @Override
    public double calculate(double a, double b) {
        return 0;
    }
}
