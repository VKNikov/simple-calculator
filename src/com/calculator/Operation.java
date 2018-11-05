package com.calculator;

public enum Operation {
    ADD {
        @Override
        public double calculate(double firstNumber, double secondNumber) {
            return firstNumber + secondNumber;
        }
    },
    SUBTRACT {
        @Override
        public double calculate(double firstNumber, double secondNumber) {
            return firstNumber - secondNumber;
        }
    },
    MULTIPLY {
        @Override
        public double calculate(double firstNumber, double secondNumber) {
            return firstNumber * secondNumber;
        }
    },
    DIVIDE {
        @Override
        public double calculate(double firstNumber, double secondNumber) {
            return firstNumber / secondNumber;
        }
    };

    public abstract double calculate(double firstNumber, double secondNumber);
}
