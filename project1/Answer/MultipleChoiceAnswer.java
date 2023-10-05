package project1.Answer;

import java.util.*;

// an answer for a multiple choice question.
public class MultipleChoiceAnswer implements IAnswer {
    private List<String> answers;

    // provided by the class that instantiates this; this class serves only as a
    // container
    public MultipleChoiceAnswer(List<String> answers) {
        this.answers = answers;
    }

    public List<String> getAnswer() {
        return answers;
    }
}
