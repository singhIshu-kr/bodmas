package com.practice;

import com.practice.exception.InvalidCharactersPresentException;
import com.practice.exception.InvalidProblemFormatException;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProblemValidator {
    public Predicate<String> validateSpecialCharacters() {
        return problem -> {
            Pattern alphabetPattern = Pattern.compile("[A-Za-z]");
            Pattern specialCharacters = Pattern.compile("[!@#$%&()_=|<>?{}]");
            Matcher alphabetMatcher = alphabetPattern.matcher(problem);
            Matcher specialCharacterMatcher = specialCharacters.matcher(problem);
            if (alphabetMatcher.find() || specialCharacterMatcher.find()) {
                throw new InvalidCharactersPresentException("Problem should not contain any special characters");
            }
            return true;
        };
    }

    public Predicate<String> validateFormatOfProblem() {
        return problem -> {
            Pattern problemFormat = Pattern.compile("([-+]?((\\d+([.]\\d{1,2})?)[-+*/])+(\\d+([.][\\d]{1,2})?)$)");
            Matcher problemStatementMatcher = problemFormat.matcher(problem);
            if (!problemStatementMatcher.find()) {
                throw new InvalidProblemFormatException("Problem is in invalid format");
            }
            return true;
        };
    }
}
