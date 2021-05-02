package com.practice;


import com.practice.operator.AdditionOperator;
import com.practice.operator.DivisionOperator;
import com.practice.operator.MultiplicationOperator;
import com.practice.operator.SubtractionOperator;
import com.practice.rule.AdditionRule;
import com.practice.rule.DivisionRule;
import com.practice.rule.MultiplicationRule;
import com.practice.rule.SubtractionRule;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class BODMASSolverTest {

    private DivisionOperator divisionOperator = new DivisionOperator();
    private AdditionOperator additionOperator = new AdditionOperator();
    private MultiplicationOperator multiplicationOperator = new MultiplicationOperator();
    private SubtractionOperator subtractionOperator = new SubtractionOperator();

    private DivisionRule divisionRule = new DivisionRule(divisionOperator);
    private MultiplicationRule multiplicationRule = new MultiplicationRule(multiplicationOperator);
    private AdditionRule additionRule = new AdditionRule(additionOperator);
    private SubtractionRule subtractionRule = new SubtractionRule(subtractionOperator);
    private BODMASSolver BODMASSolver = new BODMASSolver(divisionRule,
            multiplicationRule,
            additionRule,
            subtractionRule);

    @Test
    public void shouldSolveAllTheDivisionAndReturnValidQuotient() {
        ArrayList<String> question = new ArrayList<>();
        question.addAll(Arrays.asList("4", "/", "2", "*", "2", "+", "1", "-", "3"));
        assertEquals("2.0", BODMASSolver.solveBodmas(question));
    }

    @Test
    public void shouldReturnAnsWhenProblemStartWithMinus() {
        ArrayList<String> question = new ArrayList<>();
        question.addAll(Arrays.asList("-41", "-", "10"));
        assertEquals("-51.0", BODMASSolver.solveBodmas(question));
    }

    @Test
    public void shouldReturnAnsWhenProblemStartWithPlus() {
        ArrayList<String> question = new ArrayList<>();
        question.addAll(Arrays.asList("+45", "-", "10", "/", "2"));
        assertEquals("40.0", BODMASSolver.solveBodmas(question));
    }
}