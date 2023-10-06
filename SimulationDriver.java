package cs3560;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class SimulationDriver {
    public static void main(String[] args) {
        
        Random random = new Random();
        // Randomly generate number of student in bound of 50
        int numStudents = random.nextInt(20, 95);
        
        List<Student> students = generateStudents(numStudents);
        System.out.println("The number of students have been generated: " + numStudents);
        
        System.out.println("\nStudents ID list: ");
        for (Student student : students) {
        	System.out.println(student.getId());
        }

        // Configure question and generate answers
        System.out.println("\nQuestion 1:");
        Question question1 = new Question("Multiple choices", Arrays.asList("A", "B", "C", "D"), true);
        VotingService votingService1 = new VotingService();
        System.out.println(question1.getType());
        votingService1.configureQuestion(question1);
        simulateVoting(votingService1, students, numStudents);
        votingService1.displayResult();

        
        System.out.println("Question 2:");
        Question question2 = new Question("Single choice", Arrays.asList("1. True", "2. False"), false);
        VotingService votingService2 = new VotingService();
        votingService2.configureQuestion(question2);
        System.out.println(question2.getType());
        simulateVoting(votingService2, students, numStudents);
        votingService2.displayResult();

        
        System.out.println("Question 3:");
        Question question3 = new Question("Multiple choices", Arrays.asList("A", "B", "C", "D", "E"), true);
        VotingService votingService3 = new VotingService();
        votingService3.configureQuestion(question3);
        System.out.println(question3.getType());
        simulateVoting(votingService3, students, numStudents);
        votingService3.displayResult();
        
        
        System.out.println("Question 4:");
        Question question4 = new Question("Single choice", Arrays.asList("1. True", "2. False"), false);
        VotingService votingService4 = new VotingService();
        votingService4.configureQuestion(question2);
        System.out.println(question4.getType());
        simulateVoting(votingService4, students, numStudents);
        votingService4.displayResult();
        
        
        System.out.println("Question 5:");
        Question question5 = new Question("Multiple choices", Arrays.asList("A", "B", "C", "D", "E"), true);
        VotingService votingService5 = new VotingService();
        votingService5.configureQuestion(question5);
        System.out.println(question5.getType());
        simulateVoting(votingService5, students, numStudents);
        votingService5.displayResult();
    }

    private static void simulateVoting(VotingService votingService, List<Student> students, int numStudents) {
        for (Student student : students) {
            List<String> selectedChoices = new ArrayList<>();
            List<String> candidateAnswers = votingService.getQuestion().getCandidateAnswers();
            if (votingService.getQuestion().allowMultipleChoices()) {
                // Randomly select the number of choices to be selected by the student
               
                String choice = candidateAnswers.get(new Random().nextInt(candidateAnswers.size()));
                selectedChoices.add(choice);
            }
            else {
                String choice = candidateAnswers.get(new Random().nextInt(candidateAnswers.size()));
                selectedChoices.add(choice);
            }

            // Submit the selected choices to the iVote Service
            student.submitAnswer(selectedChoices);
            votingService.acceptSubmission(student);
        }
    }

    private static List<Student> generateStudents(int numStudents) {
        List<Student> students = new ArrayList<>();

        for (int i = 1; i <= numStudents; i++) {
        	if (i < 10)
        		students.add(new Student("CS3560100" + Integer.toString(i)));
        	else
        		students.add(new Student("CS356010" + Integer.toString(i)));
        }

        return students;
    }
}
