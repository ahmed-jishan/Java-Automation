package ProblemSolving;

import java.util.Scanner;

public class EvenOdd {
    public static void even_odd (int num)//custom method
    {
        if(num%2==0)
        {
            System.out.println(num+"is even");
        }
        else
        {
            System.out.println(num+"is odd");
        }
    }
    public static void main(String[] args)//main method
    {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter the loop number: ");
        int lp = cin.nextInt();
        for (int i = 1; i <= lp; i++)
        {
            System.out.println("Enter the number: ");
            int num = cin.nextInt();
            even_odd(num);
        }
    }
}
