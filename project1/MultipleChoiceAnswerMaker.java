package project1;

import java.util.*;

public class MultipleChoiceAnswerMaker implements IAnswerMaker {
    @Override
    public IAnswer answerQuestion(Question q) {
        Random r = new Random();
        List<String> potentialAnswers = q.getPotentialAnswers();
        List<String> chosenAnswers = new ArrayList<String>();

        int numSelections = r.nextInt(potentialAnswers.size() - 1);
        for (int i = 0; i < numSelections; i++) {
            int randomSelection = r.nextInt(potentialAnswers.size() - 1);
            chosenAnswers.add(potentialAnswers.remove(randomSelection));
        }

        return new MultipleChoiceAnswer(chosenAnswers);
    }
}