package com.calculator;

import com.calculator.operation.Operation;

import java.util.Set;

public class Calculator {

    private static Set<Operation> operations = load();

    private static Set<Operation> load() {
        OperationLoader loader = new OperationLoader();
        return loader.load();
    }

    public double calculate(String operation, double a, double b){
        for (Operation operational : operations) {
            if (operational.isApplicable(com.calculator.Operation.valueOf(operation.toUpperCase()))) {
                return operational.calculate(a, b);
            }
        }

        return 0;
    }

}
