package project1.AnswerMaker;

import java.util.*;

import project1.Answer.IAnswer;
import project1.Answer.SingleChoiceAnswer;
import project1.Question.Question;

// a class that answers single choice questions with single choice answers.
public class SingleChoiceAnswerMaker implements IAnswerMaker {
    @Override
    public IAnswer answerQuestion(Question q) {
        // basically, pick a random answer from the potential answers.
        Random r = new Random();
        List<String> potentialAnswers = q.getPotentialAnswers();
        String chosenAnswer = potentialAnswers.get(r.nextInt(potentialAnswers.size()));

        // create the IAnswer object
        return new SingleChoiceAnswer(chosenAnswer);
    }
}
