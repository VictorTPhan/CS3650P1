package project1;

import java.util.*;

import project1.AnswerMaker.IAnswerMaker;
import project1.AnswerMaker.MultipleChoiceAnswerMaker;
import project1.AnswerMaker.SingleChoiceAnswerMaker;
import project1.Question.Question;
import project1.Question.SingleChoiceQuestion;
import project1.Question.MultipleChoiceQuestion;

// determines question type. Only used in this class.
enum QuestionType {
    SINGLE_CHOICE, MULTIPLE_CHOICE
};

public class SimulationDriver {

    // creates <size> students with an answerMaker of question type <type>
    // returns a list of the generated students
    public static List<Student> generateStudents(int size, QuestionType type) {
        List<Student> students = new ArrayList<Student>(0);
        for (int i = 0; i < size; i++) {
            // inject the corresponding answer maker into new student
            students.add(new Student(assignAnswerMaker(type)));
        }
        return students;
    }

    // depending on the question type, returns its corresponding answerMaker objet.
    public static IAnswerMaker assignAnswerMaker(QuestionType type) {
        switch (type) {
            case SINGLE_CHOICE:
                return new SingleChoiceAnswerMaker();
            case MULTIPLE_CHOICE:
                return new MultipleChoiceAnswerMaker();
            default: // will never occur
                return null;
        }
    }

    public static void main(String[] args) {
        // example of a single choice question being used
        // 1. create the question, provide question, answers, and correct answer.
        Question question = new SingleChoiceQuestion(
                "Please pick the third option.",
                new ArrayList<String>(Arrays.asList(new String[] { "No thank you.", "No", "Hi", "Bye" })),
                "Hi");
        // 2. configure voting service, provide students and question.
        VotingService service = new VotingService(generateStudents(10, QuestionType.SINGLE_CHOICE), question);
        // 3. ask question.
        service.askQuestion();

        // example of a multiple choice question being used
        // 1. create the question, provide question, answers, and correct answers.
        question = new MultipleChoiceQuestion(
                "Please pick A and D.",
                new ArrayList<String>(Arrays.asList(new String[] { "Hello", "Bye", "Dad", "World" })),
                new ArrayList<String>(Arrays.asList(new String[] { "Hello", "World" })));
        // 2. configure voting service, provide students and question.
        service = new VotingService(generateStudents(10, QuestionType.MULTIPLE_CHOICE), question);
        // 3. ask question.
        service.askQuestion();
    }
}