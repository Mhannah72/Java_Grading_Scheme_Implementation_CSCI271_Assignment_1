/*************************************************************************
* Project 1 for CSCI 271-001 Spring 2026
*
* Author: Malik Hannnah
* OS: Ubuntu Debian Linux 21.1
* Compiler: javac 25.0.1
* Date: January 23, 2026
*
* Purpose
* This program prompts the user for 7 of their assignment and test scores, their midterm, and final score to calculate their overall final grade using a given calculative theorem from the syllabus for CSCI271
*
*************************************************************************/

/*******************************************************************
* I declare and confirm the following:
* - I have not discussed this program code with anyone other than my
* instructor or the teaching assistants assigned to this course.
* - I have not used programming code obtained from someone else,
* or any unauthorised sources, including the Internet, either
* modified or unmodified.
* - If any source code or documentation used in my program was
* obtained from other sources, like a text book or course notes,
* I have clearly indicated that with a proper citation in the
* comments of my program.
* - I have not designed this program in such a way as to defeat or
* interfere with the normal operation of the supplied grading code.
*
* <Malik Hannah>
* <W30626500>
********************************************************************/

import java.util.Scanner;

public class CSCI271_Assignment1_MalikHannah_W30626500 {

    public static void main (String [] args)
    {
        char gradeLetter;
        double finalGrade = 0.0;
        double exams = 0.0;
        double testScore;
        double totalTestScores = 0.0;
        double midtermScore;
        double assignmentScore;
        double totalAssignmentScores = 0.0;
        double finalScore;
        int userInput1;
        int userInput2;
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the amount of assignment scores you wish for the scheme to calculate (1-7): ");
        userInput1 = scanner.nextInt();
        for (int i = 1; i <= userInput1; i++)
        {
            System.out.print("Enter assignment score " + i + ": ");
            assignmentScore = scanner.nextDouble();
            totalAssignmentScores += assignmentScore;
        }
        System.out.print("Enter the amount of test scores you wish for the scheme to calculate (1-7): ");
        userInput2 = scanner.nextInt();

        for (int i = 1; i <= userInput2; i++)
        {
            System.out.print("Enter test score " + i + ": ");
            testScore = scanner.nextInt();
            totalTestScores += testScore;
        }

        System.out.print("Enter your midterm test score out of 100: ");
        midtermScore = scanner.nextDouble();
        System.out.print("Enter your final exam score out of 100: ");
        finalScore = scanner.nextDouble();

        scanner.close();

        // Computing of averages
        double avgAssignments = totalAssignmentScores / userInput1;
        double avgTests = totalTestScores / userInput2;

        exams = getTotalExams(finalScore, midtermScore, avgTests);

        finalGrade = getFinalGrade(exams, avgAssignments, midtermScore, finalScore, totalTestScores);

        gradeLetter = getGradeLetter(finalGrade);

        //Output
         System.out.printf("%s, Final Grade: %.2f, Letter Grade: %c%n", name, finalGrade, gradeLetter);
    }


 /*****************************<getTotalExams>****************************
* Description: Calculates and returns the combined exam score using the
* syllabus weighting formula.
*
* Parameters:
*   finalScore — final exam score
*   midtermScore — midterm exam score
*   avgTests - average test score
*
* Pre:
*   - finalScore, midtermScore, and avgTests must be initialized.
*   - All scores must be valid numeric values between 0 and 100.
*
* Post:
*   - The total exam score is calculated and returned.
*   - No parameters are modified.
*
* Returns:
*   - A double representing the total exam score.
*
* Called by:
*   - main()
*
* Calls:
*   - None
************************************************************************/

    public static double getTotalExams(double finalScore, double midtermScore, double avgTests)
    {
        return (0.4 * finalScore + 0.2 * midtermScore + 0.1 * avgTests) / 70.0 * 100.0;
    }   

/*****************************<getFinalGrade>****************************
* Description: Calculates and returns the student's final course grade
* using syllabus rules based on exam performance. The formula applied
* depends on whether the combined exam score is below 60, between 60–79,
* or 80 and above.
*
* Parameters:
*   exams — combined exam score (used to determine grading formula)
*   avgAssignments - average score for total assignments
*   midtermScore — midterm exam score
*   finalScore — final exam score
*   avgTests - average test scores
*
* Pre:
*   - All parameters must be initialized.
*   - All scores must be valid numeric values between 0 and 100.
*   - exams must correctly represent the combined exam score.
*
* Post:
*   - The final course grade is calculated and returned.
*   - No parameters are modified.
*
* Returns:
*   - A double representing the student's final course grade.
*
* Called by:
*   - main()
*
* Calls:
*   - None
************************************************************************/

    public static double getFinalGrade(double exams, double avgTests, double midtermScore, double finalScore, double avgAssignments)
    {
        double finalGrade;
        double weight = ((exams - 60) / 20) * 0.3;

        if (exams < 60)
        {
            finalGrade = exams;
        }

        else if (exams < 80) {
            finalGrade = (1 - weight) * exams + (weight * avgAssignments);
        }

        else 
        {
            finalGrade = ((0.4 * finalScore) + (0.2 * midtermScore) + (0.1 * avgTests) + (0.3 * avgAssignments));
        }

        return finalGrade;
    }
 /*****************************<getGradeLetter>****************************
* Description: Determines and returns the letter grade corresponding
* to the student's final numeric grade.
*
* Parameters:
*   finalGrade — the student's calculated final course grade
*
* Pre:
*   - finalGrade must be initialized.
*   - finalGrade must contain the value returned from getFinalGrade().
*
* Post:
*   - A letter grade is determined based on finalGrade.
*   - No data is modified outside the function.
*
* Returns:
*   - A char representing the student's letter grade.
*
* Called by:
*   - main()
*
* Calls:
*   - None
************************************************************************/
    public static char getGradeLetter(double finalGrade)
    {
        if (finalGrade >= 90)
        {
            return 'A';
        }

        else if (finalGrade >= 80)
        {
            return 'B';
        }

        else if (finalGrade >= 70)
        {
            return 'C';
        }

        else if (finalGrade >= 60.0)
        {
            return 'D';
        }

        else
        {
            return 'F';
        }

    }

}