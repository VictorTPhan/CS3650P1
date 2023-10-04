package project1;

import java.util.*;

public class VotingService {
    List<Student> students;
    Map<String, IAnswer> resultBoard = new HashMap<String, IAnswer>();
    Question question;

    public VotingService(List<Student> students, Question question) {
        this.students = students;
        this.question = question;

        for (Student s : students) {
            resultBoard.put(s.getUID(), null);
        }
    }

    public void askQuestion() {
        System.out.println(question.toString());
        for (Student s : students) {
            resultBoard.put(s.getUID(), s.answerQuestion(question));
        }

        System.out.println(this.toString());
    }

    public String toString() {
        String output = "";
        output += "Results: \n";

        Map<String, Integer> stats = new HashMap<String, Integer>();
        for (String potentialAnswer : question.getPotentialAnswers()) {
            stats.put(potentialAnswer, 0);
        }

        for (String studentUID : resultBoard.keySet()) {
            IAnswer answer = resultBoard.get(studentUID);
            List<String> answers = answer.getAnswer();
            for (String s : answers) {
                stats.put(s, stats.get(s) + 1);
            }
        }

        for (String potentialAnswer : stats.keySet()) {
            output += potentialAnswer + ": " + stats.get(potentialAnswer) + "\t";
            output += "\n";
        }

        output += "\nOfficial Answer: ";
        output += showOfficialAnswer() + "\n\n";

        output += showStudentAnswers();

        return output;
    }

    private String showOfficialAnswer() {
        return question.revealAnswer();
    }

    private String showStudentAnswers() {
        String output = "";
        output += "Student Answers: \n";
        output += "UID                                     Correct?\tAnswers\n";

        for (Student s : students) {
            IAnswer answer = resultBoard.get(s.getUID());
            output += s.getUID() + "\t" + question.isAnswerCorrect(answer) + "\t\t" + answer.getAnswer() + "\n";
        }

        return output;
    }
}