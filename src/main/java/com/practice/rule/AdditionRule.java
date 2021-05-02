package com.practice.rule;

import com.practice.operator.AdditionOperator;

import java.util.List;
import java.util.function.Predicate;

public class AdditionRule extends BODMASRule {
    public AdditionRule(AdditionOperator additionOperator) {
        super(additionOperator);
    }

    @Override
    public Predicate<List<String>> apply() {
        return request -> {
            if (request.contains("+")) {
                int operatorIndex = request.indexOf("+");
                solveAndReplace(request, operatorIndex);
            }
            return true;
        };
    }
}

