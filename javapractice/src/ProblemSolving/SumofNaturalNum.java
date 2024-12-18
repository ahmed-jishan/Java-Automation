package ProblemSolving;

import java.util.Scanner;

public class SumofNaturalNum {
    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int n = cin.nextInt();
        //int sum = n* (n+1)/2; //formula
        int sum = 0;
        for(int i=0; i<=n; i++)//by loop
        {
            sum += i;

        }

        System.out.println(sum);

    }
}
