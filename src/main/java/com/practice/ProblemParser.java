package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ProblemParser {
    private ProblemValidator problemValidator;

    public ProblemParser(ProblemValidator problemValidator) {
        this.problemValidator = problemValidator;
    }

    public ArrayList<String> parse(String problemStatement) {
        String refinedStatement = problemStatement.replaceAll("[\\s*]", "");
        problemValidator.validateSpecialCharacters()
                .and(problemValidator.validateFormatOfProblem())
                .test(problemStatement);

        String[] characters = refinedStatement.split("");
        List<String> numbers = getNumbers(refinedStatement);
        List<String> operators = getOperators(characters);

        if (refinedStatement.startsWith("+") || refinedStatement.startsWith("-")) {
            String format = String.format(refinedStatement.substring(0, 1) + numbers.get(0));
            numbers.set(0, format);
            operators.remove(0);
        }
        return mergeNumbersAndOperators(numbers, operators);
    }

    private ArrayList<String> mergeNumbersAndOperators(List<String> numbers, List<String> operators) {
        ArrayList<String> bodmasQuestion = new ArrayList<>();
        AtomicInteger count = new AtomicInteger(0);
        bodmasQuestion.add(numbers.get(count.get()));
        operators.forEach(operator -> {
            bodmasQuestion.add(operator);
            bodmasQuestion.add(numbers.get(count.get() + 1));
            count.set(count.get() + 1);
        });
        return bodmasQuestion;
    }

    private List<String> getOperators(String[] characters) {
        return Arrays.stream(characters)
                .filter(character ->
                        character.matches("[-+/*]"))
                .collect(Collectors.toList());
    }

    private List<String> getNumbers(String refinedStatement) {
        return Arrays.stream(refinedStatement.split("[-+/*]"))
                .filter(character -> !character.equals(""))
                .collect(Collectors.toList());
    }
}
