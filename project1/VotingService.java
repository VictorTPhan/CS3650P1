package project1;

import java.util.*;

public class VotingService {
    List<Student> students;
    List<Question> questions;
    QuestionType questionType; // I'm not sure if this is going to be used
    Map<String, List<Boolean>> resultBoard = new HashMap<String, List<Boolean>>();

    public VotingService(List<Student> students, QuestionType questionType, List<Question> questions) {
        this.students = students;
        this.questions = questions;
        this.questionType = questionType;

        for (Student student : this.students) {
            resultBoard.put(student.getUID(), new ArrayList<Boolean>());
        }
    }

    public void beginTest() {
        for (int i = 0; i < questions.size(); i++) {
            askQuestion(i + 1, questions.get(i));
        }
        System.out.println(this.toString());
    }

    public void askQuestion(int questionNum, Question q) {
        System.out.println(questionNum + ". " + q.toString());
        for (Student student : this.students) {
            resultBoard.get(student.getUID()).add(q.isAnswerCorrect(student.answerQuestion(q)));
        }
    }

    public String toString() {
        String output = "";
        output += "Results \n";
        output += "Student ID" + "\t";

        for (int i = 0; i < questions.size(); i++) {
            output += (i + 1) + "\t";
        }

        output += "\n";

        for (String UID : resultBoard.keySet()) {
            output += UID + "\t";
            for (Boolean b : resultBoard.get(UID)) {
                output += b + "\t";
            }
            output += "\n";
        }
        return output;
    }
}