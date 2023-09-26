package project1;

import java.util.*;

public class MultipleChoiceAnswer implements IAnswer {
    private List<String> answers;

    public MultipleChoiceAnswer(List<String> answers) {
        this.answers = answers;
    }

    public List<String> getAnswer() {
        return answers;
    }
}
