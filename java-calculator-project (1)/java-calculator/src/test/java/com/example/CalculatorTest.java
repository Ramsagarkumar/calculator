package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void addsNumbers() {
        assertEquals(15.0, Calculator.calculate(10, "+", 5));
    }

    @Test
    void subtractsNumbers() {
        assertEquals(5.0, Calculator.calculate(10, "-", 5));
    }

    @Test
    void multipliesNumbers() {
        assertEquals(50.0, Calculator.calculate(10, "*", 5));
    }

    @Test
    void dividesNumbers() {
        assertEquals(2.0, Calculator.calculate(10, "/", 5));
    }

    @Test
    void divisionByZeroThrowsException() {
        assertThrows(ArithmeticException.class,
                () -> Calculator.calculate(10, "/", 0));
    }

    @Test
    void unsupportedOperatorThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> Calculator.calculate(10, "%", 5));
    }
}
