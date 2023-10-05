package project1.Question;

import java.util.*;

import project1.Answer.IAnswer;

// abstract class due to need for shared code
public abstract class Question {
    protected List<String> potentialAnswers;
    protected String question;

    public Question(String question, List<String> answers) {
        this.potentialAnswers = answers;
        this.question = question;
    }

    public List<String> getPotentialAnswers() {
        return potentialAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public String toString() {
        String output = "";
        output += question; // display question
        output += "\n";

        // print out all answers, labeled from A onwards
        char answerLetter = 'A';
        answerLetter--;
        for (int i = 0; i < potentialAnswers.size(); i++) {
            answerLetter++;
            output += answerLetter + ". " + potentialAnswers.get(i) + "\n";
        }
        return output;
    }

    // to be implemented by subclasses
    public abstract boolean isAnswerCorrect(IAnswer answer);

    // to be implemented by subclasses
    public abstract String revealAnswer();
}