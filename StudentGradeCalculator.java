package codeSoftIntershipTasks;

import java.util.Scanner;

class FindGrade
{
    public String getGrade(int avg)
    {
        switch (avg / 10) 
        {
            case 10:
                return "A+";
            case 9:
                return "A";
            case 8:
                return "B+";
            case 7:
                return "B";
            case 6:
                return "C";
            case 5:
                return "D";
            default:
                return "F";
        }
    }
}

public class StudentGradeCalculator
{
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
        FindGrade fg = new FindGrade();

        System.out.print("ENTER THE NUMBER OF SUBJECTS: ");
        int totSub = sc.nextInt();
        int totMarks = 0;

        for (int i = 0; i < totSub; i++) 
        {
            System.out.println("ENTER THE MARKS OBTAINED IN SUBJECT " + (i + 1));
            int marks = sc.nextInt();
            totMarks += marks;
        }

        int avg = totMarks / totSub;

        String Grade = fg.getGrade(avg);

        System.out.println("TOTAL MARKS OBTAINED :- " + totMarks);
        System.out.println("PERCENTAGE OBTAINED :- " + avg+"%");
        System.out.println("GRADE OBTAINED :- " + Grade);

        sc.close();
    }
}