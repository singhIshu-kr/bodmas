package com.practice.rule;

import com.practice.operator.ArithmeticOperator;

import java.util.List;
import java.util.function.Predicate;

public abstract class BODMASRule {
    public ArithmeticOperator arithmeticOperator;

    public BODMASRule(ArithmeticOperator arithmeticOperator) {
        this.arithmeticOperator = arithmeticOperator;
    }

    public abstract Predicate<List<String>> apply();

    public void solveAndReplace(List<String> bodmasQuestion, int i) {
        double value1 = Double.parseDouble(bodmasQuestion.get(i - 1));
        double value2 = Double.parseDouble(bodmasQuestion.get(i + 1));
        double calculate = arithmeticOperator.evaluate(value1, value2);
        bodmasQuestion.set(i, String.valueOf(calculate));
        bodmasQuestion.remove(i - 1);
        bodmasQuestion.remove(i);
    }
}

