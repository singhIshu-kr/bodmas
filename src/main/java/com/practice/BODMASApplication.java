package com.practice;

import java.util.ArrayList;

public class BODMASApplication {
    private BODMASSolver bodmasSolver;
    private ProblemParser problemParser;

    public BODMASApplication(BODMASSolver bodmasSolver,
                             ProblemParser problemParser) {
        this.bodmasSolver = bodmasSolver;
        this.problemParser = problemParser;
    }

    public String solveBodmas(String problemStatement) {
        ArrayList<String> bodmasQuestion = problemParser.parse(problemStatement);
        return bodmasSolver.solveBodmas(bodmasQuestion);
    }
}
