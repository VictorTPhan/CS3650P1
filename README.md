# CS3650P1
 
In this project, we have a Java system that allows a user to create a question and simulate student responses to it by emulating a polling system.

The project is architected as follows:

- Question -- can be of two types: a SingleChoiceQuestion or MultipleChoiceQuestion. In charge of maintaining question, potential answers, correct answer, and performing grading.
- Answer -- can be of two types: a SingleChoiceAnswer or MultipleChoiceAnswer. Simply a container that is fed into a Question object for grading.
- AnswerMaker -- can be of two types: a SingleChoiceAnswerMaker or MultipleChoiceAnswerMaker. When given a Question object, will return an Answer object.
- Student -- a container for an AnswerMaker with a UID.
- VotingService -- contains a question and a list of students, asks them questions, and shows the results.
- SimulationDriver -- configures the VotingService by making students and the question.