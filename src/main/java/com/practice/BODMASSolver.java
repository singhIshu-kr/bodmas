package com.practice;


import com.practice.rule.AdditionRule;
import com.practice.rule.DivisionRule;
import com.practice.rule.MultiplicationRule;
import com.practice.rule.SubtractionRule;

import java.util.ArrayList;

public class BODMASSolver {

    private final DivisionRule divisionRule;
    private final MultiplicationRule multiplicationRule;
    private final AdditionRule additionRule;
    private SubtractionRule subtractionRule;

    public BODMASSolver(DivisionRule divisionRule,
                        MultiplicationRule multiplicationRule,
                        AdditionRule additionRule,
                        SubtractionRule subtractionRule) {
        this.divisionRule = divisionRule;
        this.multiplicationRule = multiplicationRule;
        this.additionRule = additionRule;
        this.subtractionRule = subtractionRule;
    }

    public String solveBodmas(ArrayList<String> bodmasQuestion) {
        for (int i = 0; i < bodmasQuestion.size(); i++) {
            divisionRule.apply()
                    .and(multiplicationRule.apply())
                    .and(additionRule.apply())
                    .and(subtractionRule.apply())
                    .test(bodmasQuestion);
        }
        System.out.println("Final Answer: ");
        return bodmasQuestion.get(0);
    }
}
