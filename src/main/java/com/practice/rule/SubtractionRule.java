package com.practice.rule;

import com.practice.operator.SubtractionOperator;

import java.util.List;
import java.util.function.Predicate;

public class SubtractionRule extends BODMASRule {
    public SubtractionRule(SubtractionOperator subtractionOperator) {
        super(subtractionOperator);
    }

    @Override
    public Predicate<List<String>> apply() {
        return request -> {
            if (request.contains("-")) {
                int operatorIndex = request.indexOf("-");
                solveAndReplace(request, operatorIndex);
            }
            return true;
        };
    }
}

