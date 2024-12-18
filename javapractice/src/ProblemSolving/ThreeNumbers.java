package ProblemSolving;

import java.util.Scanner;

public class ThreeNumbers {

    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter the three numbers: ");
        int a = cin.nextInt();
        int b = cin.nextInt();
        int c = cin.nextInt();
        if(a>=b && a >=c)
        {
            System.out.println(a+ "is the biggest number");
        }
        else if (b>=a && b>=c)
        {
            System.out.println(b+ "is the biggest number");
        }
        else if (c>=a && c>=b)
        {
            System.out.println(c+ "is the biggest number");
        }
        else
        {
            System.out.println("Something different scenario");
        }

    }
}
