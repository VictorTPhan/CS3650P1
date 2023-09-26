package project1;

import java.util.*;

public abstract class Question {
    protected List<String> potentialAnswers;
    protected String question;

    public Question(String question, List<String> answers) {
        this.potentialAnswers = answers;
        this.question = question;
    }

    public List<String> getPotentialAnswers() {
        return potentialAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public abstract boolean isAnswerCorrect(IAnswer answer);

    public String toString() {
        String output = "";
        output += question;
        output += "\n";
        for (int i = 0; i < potentialAnswers.size(); i++) {
            output += (i + 1) + ". " + potentialAnswers.get(i) + "\n";
        }
        return output;
    }
}