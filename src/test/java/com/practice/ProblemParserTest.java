package com.practice;


import com.practice.exception.InvalidCharactersPresentException;
import com.practice.exception.InvalidProblemFormatException;
import com.sun.media.sound.InvalidFormatException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProblemParserTest {
    private ProblemValidator problemValidator = new ProblemValidator();
    private ProblemParser problemParser = new ProblemParser(problemValidator);

    @Test
    public void shouldReturnArrayWithSequentialOperandsWithOperator() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("1", "+", "2", "+", "3", "/", "211", "+", "2"));
        assertEquals(expected, problemParser.parse("1    +2+  3/211+2"));
    }

    @Test
    public void shouldAppendPlusOrMinusInFrontOfTheFirstNumberIfProblemStatementHasPlusOrMinusInStart() {
        ArrayList<String> expected = new ArrayList<>(Arrays.asList("-1", "+", "2", "+", "3", "/", "211", "+", "2"));
        assertEquals(expected, problemParser.parse("-1+2+3/211+2"));
    }

    @Test
    public void shouldThrowErrorWhenProblemContainsAlphabests() {
        InvalidCharactersPresentException actual = assertThrows(
                InvalidCharactersPresentException.class, () -> problemParser.parse("-1+2+3/21a1+2"));
        assertEquals("Problem should not contain any special characters", actual.getMessage());
    }

    @Test
    public void shouldThrowErrorWhenProblemIsInInvalidFormat() {
        InvalidProblemFormatException actual = assertThrows(
                InvalidProblemFormatException.class, () -> problemParser.parse("-1+2+3/211++2"));
        assertEquals("Problem is in invalid format", actual.getMessage());
    }

}