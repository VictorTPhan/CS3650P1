package project1;

import java.util.*;

enum QuestionType {
    SINGLE_CHOICE, MULTIPLE_CHOICE
};

public class SimulationDriver {
    static List<Question> questions = new ArrayList<Question>();

    public static QuestionType assignQuestionType() {
        Random r = new Random();
        return QuestionType.values()[r.nextInt(QuestionType.values().length - 1)];
    }

    public static List<Student> generateStudents(int size, QuestionType type) {
        List<Student> students = new ArrayList<Student>(0);
        for (int i = 0; i < size; i++) {
            students.add(new Student(assignAnswerMaker(type)));
        }
        return students;
    }

    public static IAnswerMaker assignAnswerMaker(QuestionType type) {
        switch (type) {
            case SINGLE_CHOICE:
                return new SingleChoiceAnswerMaker();
            case MULTIPLE_CHOICE:
                return new MultipleChoiceAnswerMaker();
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        QuestionType type = QuestionType.MULTIPLE_CHOICE;
        questions.add(
                new MultipleChoiceQuestion(
                        "Please pick B.",
                        new ArrayList<String>(Arrays.asList(new String[] { "Bruh", "No", "Hi", "Bye" })),
                        new ArrayList<String>(Arrays.asList(new String[] { "Bruh", "No" }))));
        questions.add(
                new MultipleChoiceQuestion(
                        "Please pick A.",
                        new ArrayList<String>(Arrays.asList(new String[] { "1", "2", "3", "4" })),
                        new ArrayList<String>(Arrays.asList(new String[] { "1", "2" }))));

        VotingService service = new VotingService(generateStudents(10, type), type, questions);
        service.beginTest();
    }
}

/*
 * 2 types of answers: single choice and multiple choice
 * minimum classes
 * Student
 * have a UID
 * Question
 * VotingService
 * configured with a question type and candidate answers
 * each student can only submit one answer, if multiple answers are given,
 * accept the most recent.
 * can output the statistics of submission results.
 * SimulationDriver
 * contains a main method
 * randomly generates IDs and answers for group of students
 * create a question type and configure answers
 * configure question for iVote service
 * randomly generate students and their answers
 * submit all student's answers to iVote service
 * call Voting Serice output
 * other subclasses or interfaces may be required.
 */