package project1.AnswerMaker;

import java.util.*;

import project1.Answer.IAnswer;
import project1.Answer.MultipleChoiceAnswer;
import project1.Question.Question;

// a class that answers multiple choice questions with multiple choice answers.
public class MultipleChoiceAnswerMaker implements IAnswerMaker {
    @Override
    public IAnswer answerQuestion(Question q) {
        // basically, for a question of n potential answers, select up to n (inclusive)
        // random answers.
        Random r = new Random();
        // create a copy of the potential answers
        List<String> potentialAnswers = new ArrayList<String>(q.getPotentialAnswers());
        List<String> chosenAnswers = new ArrayList<String>();

        int numSelections = r.nextInt(potentialAnswers.size() - 1) + 1;

        for (int i = 0; i < numSelections; i++) {
            int randomSelection = r.nextInt(potentialAnswers.size());

            // remove the answer from the answer bank each time to avoid duplication
            chosenAnswers.add(potentialAnswers.remove(randomSelection));
        }

        // create the IAnswer object
        return new MultipleChoiceAnswer(chosenAnswers);
    }
}
