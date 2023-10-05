package project1;

import java.util.*;

import project1.Answer.IAnswer;
import project1.Question.Question;

public class VotingService {
    List<Student> students;
    // all the answers from the students.
    // if a student ever submits a duplicate, the latest is saved.
    Map<String, IAnswer> resultBoard = new HashMap<String, IAnswer>();
    Question question;

    public VotingService(List<Student> students, Question question) {
        this.students = students;
        this.question = question;

        // each student corresponds to a key
        for (Student s : students) {
            resultBoard.put(s.getUID(), null);
        }
    }

    public void askQuestion() {
        // print out the question being asked
        System.out.println(question.toString());

        // for every student, get their answer to the question
        for (Student s : students) {
            resultBoard.put(s.getUID(), s.answerQuestion(question));
        }

        // print out the results
        System.out.println(this.toString());
    }

    public String toString() {
        String output = "";

        // Results
        output += "Results: \n";

        // stats is a hashmap of answers to frequency of answer selection, all
        // initialized to 0
        Map<String, Integer> stats = new HashMap<String, Integer>();
        for (String potentialAnswer : question.getPotentialAnswers()) {
            stats.put(potentialAnswer, 0);
        }

        // for every student, increment the stats hashmap with their selected answer
        for (String studentUID : resultBoard.keySet()) {
            IAnswer answer = resultBoard.get(studentUID);

            // all answers (single or multiple) come in as a list of strings
            List<String> answers = answer.getAnswer();
            for (String s : answers) {
                stats.put(s, stats.get(s) + 1);
            }
        }

        // print out answer and frequencies
        for (String potentialAnswer : stats.keySet()) {
            output += potentialAnswer + ": " + stats.get(potentialAnswer) + "\t";
            output += "\n";
        }

        // show the official answer
        output += "\n";
        output += showOfficialAnswer();

        // show who got it right
        output += "\n";
        output += showStudentAnswers();

        return output;
    }

    private String showOfficialAnswer() {
        String output = "Official Answer: \n";
        output += question.revealAnswer(); // prints out the answer
        output += "\n";
        return output;
    }

    private String showStudentAnswers() {
        String output = "";
        output += "Student Answers: \n";
        output += "UID                                     Correct?\tAnswers\n";

        // for every student, print out their answer and if they got it right
        for (Student s : students) {
            IAnswer answer = resultBoard.get(s.getUID());
            output += s.getUID() + "\t" + question.isAnswerCorrect(answer) + "\t\t" + answer.getAnswer() + "\n";
        }

        return output;
    }
}