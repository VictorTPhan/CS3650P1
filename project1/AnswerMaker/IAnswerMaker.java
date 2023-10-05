package project1.AnswerMaker;

import project1.Answer.IAnswer;
import project1.Question.Question;

// an interface for answer makers. Given a question, return an IAnswer object.
public interface IAnswerMaker {
    IAnswer answerQuestion(Question q);
}
