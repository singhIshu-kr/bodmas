package com.practice.rule;

import com.practice.operator.MultiplicationOperator;
import com.practice.rule.BODMASRule;

import java.util.List;
import java.util.function.Predicate;

public class MultiplicationRule extends BODMASRule {
    public MultiplicationRule(MultiplicationOperator multiplicationOperator) {
        super(multiplicationOperator);
    }

    @Override
    public Predicate<List<String>> apply() {
        return request -> {
            if (request.contains("*")) {
                int operatorIndex = request.indexOf("*");
                solveAndReplace(request, operatorIndex);
            }
            return true;
        };
    }
}


