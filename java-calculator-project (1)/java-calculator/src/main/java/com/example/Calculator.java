package com.example;

public class Calculator {

    public static double calculate(double first, String operator, double second) {
        return switch (operator) {
            case "+" -> first + second;
            case "-" -> first - second;
            case "*" -> first * second;
            case "/" -> {
                if (second == 0.0) {
                    throw new ArithmeticException("Division by zero is not allowed");
                }
                yield first / second;
            }
            default -> throw new IllegalArgumentException(
                    "Unsupported operator: " + operator + ". Use +, -, *, or /.");
        };
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("Usage: java -jar app.jar <number1> <operator> <number2>");
            System.err.println("Example: java -jar app.jar 10 + 5");
            System.exit(1);
        }

        try {
            double first = Double.parseDouble(args[0]);
            String operator = args[1];
            double second = Double.parseDouble(args[2]);

            double result = calculate(first, operator, second);
            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            System.err.println("Error: Please provide valid numbers.");
            System.exit(1);
        } catch (IllegalArgumentException | ArithmeticException e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }
}
