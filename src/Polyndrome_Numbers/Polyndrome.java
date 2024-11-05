package Polyndrome_Numbers;

import java.util.Scanner;

public class Polyndrome {

    public static boolean polyndrome(int n){

        if (n < 0) return false;
        int reverse = 0, original = n;


        while (n != 0){
            reverse = reverse * 10 + n%10;
            n= n / 10;
        }

        return (reverse == original);
    }

    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number to check: ");
        int number = scanner.nextInt();
        if (polyndrome(number)) {
            System.out.println("The number " + number + " is polyndrome!");
        }

        else System.out.println("The number " + number + " is not polyndrome");

    }

}