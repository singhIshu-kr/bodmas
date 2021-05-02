package com.practice.operator;

import com.practice.operator.ArithmeticOperator;

public class SubtractionOperator implements ArithmeticOperator {
    @Override
    public double evaluate(double value1, double value2) {
        return value1 - value2;
    }
}
