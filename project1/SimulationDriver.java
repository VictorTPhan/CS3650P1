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
        Question question = new SingleChoiceQuestion(
                "Please pick the third option.",
                new ArrayList<String>(Arrays.asList(new String[] { "No thank you.", "No", "Hi", "Bye" })),
                "Hi");

        VotingService service = new VotingService(generateStudents(10, QuestionType.SINGLE_CHOICE), question);
        service.askQuestion();

        question = new MultipleChoiceQuestion(
                "Please pick A and D.",
                new ArrayList<String>(Arrays.asList(new String[] { "Hello", "Bye", "Dad", "World" })),
                new ArrayList<String>(Arrays.asList(new String[] { "Hello", "World" })));
        service = new VotingService(generateStudents(10, QuestionType.MULTIPLE_CHOICE), question);
        service.askQuestion();
    }
}