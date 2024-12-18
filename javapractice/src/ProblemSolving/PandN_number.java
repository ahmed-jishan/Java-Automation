package ProblemSolving;

import java.util.Scanner;

public class PandN_number {

    public static void main(String[] args)
    {
        Scanner cin = new Scanner(System.in);
        System.out.println("Enter the loop number: ");
        int lp = cin.nextInt();
        for(int i=0; i<=lp; i++) {
            System.out.println("Enter the number: ");
            int num = cin.nextInt();
            if (num >= 0) {
                System.out.println(num + "is the positive number");
            } else {
                System.out.println(num + "is the negative number");
            }
        }

    }
}
