package project1;

import java.util.*;

public class Student {
    private IAnswerMaker answerMaker;
    private String UID;

    public Student(IAnswerMaker answerMaker) {
        this.answerMaker = answerMaker;
        this.UID = UUID.randomUUID().toString();
    }

    public IAnswer answerQuestion(Question q) {
        return answerMaker.answerQuestion(q);
    }

    public String getUID() {
        return UID;
    }
}
