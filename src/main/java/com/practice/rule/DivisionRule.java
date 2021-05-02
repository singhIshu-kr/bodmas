package com.practice.rule;

import com.practice.operator.DivisionOperator;

import java.util.List;
import java.util.function.Predicate;

public class DivisionRule extends BODMASRule {
    public DivisionRule(DivisionOperator divisionOperator) {
        super(divisionOperator);
    }

    @Override
    public Predicate<List<String>> apply() {
        return request -> {
            if (request.contains("/")) {
                int operatorIndex = request.indexOf("/");
                solveAndReplace(request, operatorIndex);
            }
            return true;
        };
    }
}
