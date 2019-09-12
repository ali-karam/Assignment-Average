
import java.util.Scanner;

/**
 * This program calculates student grades for students enrolled in the computer
 * science class, and also provides a class average.
 *
 * @author Ali Al-Karam
 */
public class AssignmentGrades {

    public static void main(String[] args) {
        //Declare Variables
        Scanner kbd = new Scanner(System.in);
        String studentNum;
        int sum = 0;
        int minimum = 100;
        double sumClass = 0;
        int numStudents = 0;
        int assignmentScore;
        double totalScore;
        double classAverage;
        final int NUM_ASSIGNMENT = 6;

        //Introduction
        printIntroduction();

        //While loop that gets a student number and quits if you leave blank
        System.out.print("Enter a student number or leave blank to quit: ");
        studentNum = kbd.nextLine();
        while (!studentNum.equals("")) {
            System.out.print("Enter " + studentNum + "'s "
                + NUM_ASSIGNMENT + " assignment scores: ");

            //For loop that takes assignment scores
            for (int i = 1; i <= NUM_ASSIGNMENT; i++) {
                assignmentScore = kbd.nextInt();
                sum += assignmentScore;

                //If statement that obtains lowest score
                if (assignmentScore <= minimum) {
                    minimum = assignmentScore;
                }
            }

            //Clean up input and print student grade
            kbd.nextLine();
            System.out.println();
            totalScore = (double) (sum - minimum) / (NUM_ASSIGNMENT - 1);
            System.out.print("Student " + studentNum + ": "
                + totalScore + "%");
            sum = 0;
            minimum = 100;

            //Count students and sum their scores
            ++numStudents;
            sumClass += totalScore;

            //Pause and check if user wants to continue
            pause(kbd);
            System.out.print("Enter a student number or leave blank to quit: ");
            studentNum = kbd.nextLine();

        }

        //Print class average after while loop
        if (numStudents != 0) {
            classAverage = sumClass / numStudents;
            System.out.println("\nClass Average: " + classAverage + "%");
        }

    }

    //Introduction method
    private static void printIntroduction() {
        System.out.println("This program calculates the overall assignment "
            + "score, \ngiven individual assignment scores for students"
            + "\nenrolled in computer science, and will also provide a"
            + "\nclass average.");
        System.out.println();
        System.out.println("Made by Ali Al-Karam");
        System.out.println("--------------------------------\n");

    }

    //Pause method
    private static void pause(Scanner kbd) {
        System.out.print("\n\n" + "Press Enter key to continue...");
        kbd.nextLine();
        System.out.println("");

    }

}
