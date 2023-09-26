package project1;

import java.util.*;

public class MultipleChoiceQuestion extends Question {
    Set<String> officialAnswers;

    public MultipleChoiceQuestion(String question, List<String> potentialAnswers, List<String> officialAnswers) {
        super(question, potentialAnswers);
        this.officialAnswers = new HashSet<>(officialAnswers);
    }

    public boolean isAnswerCorrect(IAnswer answer) {
        Set<String> submittedAnswers = new HashSet<String>(answer.getAnswer());
        return officialAnswers.equals(submittedAnswers);
    }
}