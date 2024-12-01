package LeetCode.Numbers.Fibonacci_Numbers;

import java.util.Scanner;

public class Fibonacci{

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        int n ;

        do {
            System.out.print("Enter value: ");
            n = scanner.nextInt();
        }
        while ( n < 0  || n > 30);;
        System.out.println("Result: F(" + n + ") = " + fib(n));
    }

}

