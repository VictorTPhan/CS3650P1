package project1.Question;

import java.util.*;

import project1.Answer.IAnswer;

// a question that can have multiple answers.
public class MultipleChoiceQuestion extends Question {
    Set<String> officialAnswers;

    public MultipleChoiceQuestion(String question, List<String> potentialAnswers, List<String> officialAnswers) {
        super(question, potentialAnswers);
        this.officialAnswers = new HashSet<>(officialAnswers);
    }

    // regardless of question type, answers are given as strings of lists
    // for ease of comparison, the official answers are a set. So, to compare, we
    // need to turn the answer list into a set and compare for equality
    public boolean isAnswerCorrect(IAnswer answer) {
        Set<String> submittedAnswers = new HashSet<String>(answer.getAnswer());
        return officialAnswers.equals(submittedAnswers);
    }

    @Override
    public String revealAnswer() {
        return officialAnswers.toString();
    }
}