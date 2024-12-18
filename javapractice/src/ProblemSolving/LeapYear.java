package ProblemSolving;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter the loop number: ");
        int lp = cin.nextInt();
        for(int i=0; i<=lp; i++)
        {

            System.out.println("Enter the year: ");
            int year = cin.nextInt();

            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                System.out.println(year + "is a leap year");
            } else {
                System.out.println(year + "is not a leap year");
            }

        }
    }
}
