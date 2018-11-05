package com.calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try(Scanner input = new Scanner(System.in)) {
            Double firstNumber = Double.parseDouble(input.nextLine());
            Double secondNumber = Double.parseDouble(input.nextLine());
            String operation = input.nextLine();

            Calculator calculator = new Calculator();
            Double result = calculator.calculate(operation, firstNumber, secondNumber);
            System.out.println(result);
        }
    }
}
