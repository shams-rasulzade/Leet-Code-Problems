package LeetCode.Numbers.Smallest_Positive_Integer;

import java.util.Scanner;

public class SPI {

    public static int smallestMultiple(int n) {
        // If n is multiple of 2 return n
        // if not return 2 * n.
        return (n % 2 == 0) ? n : 2 * n;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.print("Enter value to find Least Common Multiple: ");
        n = scanner.nextInt();
        System.out.println("Smallest multiple of " + n + " and 2: " + smallestMultiple(n));

    }
}