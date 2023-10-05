package project1.Answer;

import java.util.*;

// an answer for a single choice question.
public class SingleChoiceAnswer implements IAnswer {
    private String answer;

    // provided by the class that instantiates this; this class serves only as a
    // container
    public SingleChoiceAnswer(String answer) {
        this.answer = answer;
    }

    // since all answers must be in the form of a list of strings, take our singular
    // answer and put it into a 1-element long list
    public List<String> getAnswer() {
        return Arrays.asList(answer);
    }
}
