package com.example;

public class Calculator {

    public static double calculate(double a, String operator, double b) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java -jar app.jar 10 + 5");
            System.exit(1);
        }

        double a = Double.parseDouble(args[0]);
        String operator = args[1];
        double b = Double.parseDouble(args[2]);

        System.out.println("Result: " + calculate(a, operator, b));
    }
}
