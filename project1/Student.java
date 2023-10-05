package project1;

import java.util.*;

import project1.Answer.IAnswer;
import project1.AnswerMaker.IAnswerMaker;
import project1.Question.Question;

// A class that is configured with an answerMaker.
// this is essentially a container for an answerMaker that has a UID attached to it.
public class Student {
    private IAnswerMaker answerMaker;
    private String UID;

    public Student(IAnswerMaker answerMaker) {
        this.answerMaker = answerMaker;

        // generate a UUID
        this.UID = UUID.randomUUID().toString();
    }

    // simply call on the composed answerMaker
    public IAnswer answerQuestion(Question q) {
        return answerMaker.answerQuestion(q);
    }

    public String getUID() {
        return UID;
    }
}
