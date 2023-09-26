package project1;

import java.util.*;

public class SingleChoiceAnswer implements IAnswer {
    private String answer;

    public SingleChoiceAnswer(String answer) {
        this.answer = answer;
    }

    public List<String> getAnswer() {
        return Arrays.asList(answer);
    }
}
