package project1.Question;

import java.util.*;

import project1.Answer.IAnswer;

// a question that can only have one correct answer.
public class SingleChoiceQuestion extends Question {
    String officialAnswer;

    public SingleChoiceQuestion(String question, List<String> potentialAnswers, String officialAnswer) {
        super(question, potentialAnswers);
        this.officialAnswer = officialAnswer;
    }

    // regardless of question type, answers are given as strings of lists
    // for a single choice question, the list is of length 0, and we just need the
    // first element
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
