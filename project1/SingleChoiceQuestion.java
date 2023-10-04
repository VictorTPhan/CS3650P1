package project1;

import java.util.*;

public class SingleChoiceQuestion extends Question {
    String officialAnswer;

    public SingleChoiceQuestion(String question, List<String> potentialAnswers, String officialAnswer) {
        super(question, potentialAnswers);
        this.officialAnswer = officialAnswer;
    }

    @Override
    public boolean isAnswerCorrect(IAnswer answer) {
        String submittedAnswer = answer.getAnswer().get(0);
        return submittedAnswer.equals(officialAnswer);
    }

    @Override
    public String revealAnswer() {
        return officialAnswer;
    }
}
