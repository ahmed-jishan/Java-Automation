package ProblemSolving;

import java.util.Scanner;

public class MaxNumber {
    public static void max_num(int a, int b, int c)
    {
        if(a>=b && a>=c)
        {
            System.out.println(a);
        }
        else if(b>=a && b>=c)
        {
            System.out.println(b);
        }
        else if (a==b && b==c)
        {
            System.out.println(a);
        }
        else
        {
            System.out.println(c);
        }

    }
    public static void main(String[] args)
    {

        Scanner cin = new Scanner(System.in);
        int lp = cin.nextInt();
        for (int i = 1; i <= lp; i++)
        {
            System.out.println("Enter the three numbers: ");
            int a = cin.nextInt();
            int b = cin.nextInt();
            int c = cin.nextInt();
            max_num(a, b, c);
        }
    }
}
