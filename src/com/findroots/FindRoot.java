package com.findroots;
import java.util.Scanner;

public class FindRoot {
    public static void returnRoot(double a, double b, double c){

        double D = (Math.pow(b, 2) - 4* a * c);

        if (D > 0.0){
            double root1 = (-b + Math.sqrt(D) ) /  2 * a;
            double root2 = (-b - Math.sqrt(D) ) /  2 * a;
            System.out.println("The roots are: " + root1 + "and " + root2);
        }

        else if (D==0){
            double root = -b  /  2 * a;
            System.out.println("The root is: " + root);
        }

        else System.out.println("Equation has no real roots!");

    }

    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter coefficients to find the roots: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        returnRoot(a,b,c);
    }
}
