package Find_Max;

import java.util.Arrays;
import java.util.Scanner;

public class Findmax {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter the length of the array: ");
            int n = scanner.nextInt();
            int[] arr = new int[n];

            int max = 0;

            System.out.println("Enter the elements of the array: ");
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println("Your Array: ");
            for (int i = 0; i < n; i++) {
                if (max < arr[i]) max = arr[i];
            }


            System.out.println("The max value of the array: " + max);


        }
}
