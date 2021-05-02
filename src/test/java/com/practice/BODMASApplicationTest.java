package com.practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BODMASApplicationTest {
    BODMASSolver bodmasSolver = mock(BODMASSolver.class);
    ProblemParser problemParser = mock(ProblemParser.class);

    @Test
    public void shouldReturnAnswerAfterSolvingBODMAS() {
        BODMASApplication bodmasApplication = new BODMASApplication(bodmasSolver, problemParser);
        List<String> bodmasQuestion = Arrays.asList("1", "+", "1");
        ArrayList<String> question = new ArrayList<>(bodmasQuestion);
        when(problemParser.parse("1+1")).thenReturn(question);
        when(bodmasSolver.solveBodmas(question)).thenReturn("2.0");
        assertEquals("2.0", bodmasApplication.solveBodmas("1+1"));
    }
}