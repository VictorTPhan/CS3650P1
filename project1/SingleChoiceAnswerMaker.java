package project1;

import java.util.*;

public class SingleChoiceAnswerMaker implements IAnswerMaker {
    @Override
    public IAnswer answerQuestion(Question q) {
        Random r = new Random();
        List<String> potentialAnswers = q.getPotentialAnswers();
        String chosenAnswer = potentialAnswers.get(r.nextInt(potentialAnswers.size() - 1));
        return new SingleChoiceAnswer(chosenAnswer);
    }
}
