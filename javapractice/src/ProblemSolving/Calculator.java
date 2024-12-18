package ProblemSolving;

import java.util.Scanner;

public class Calculator {
    public static void call(String condition, int a, int b)
    {
        if(condition.equals("+")){
            System.out.println(a+b);
        }
        else if(condition.equals("-")){
            System.out.println(a-b);
        }
        else if(condition.equals("*")){
            System.out.println(a*b);
        }
        else if(condition.equals("/")){
            System.out.println(a/b);
        }
    }

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter the numbers: ");
        int a = cin.nextInt();
        String condition = cin.next();
        //call(condition,a,0);
        //System.out.println("Enter the second number: ");
        int b = cin.nextInt();
         call(condition,a,b);
    }
}


