package Tasks.Lab_2_Exceptions_in_Java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class exception {

    public static String inputString() {
        Scanner sc = null;
        try {
            File file = new File("/Users/shams/Desktop/loremm.txt");
            sc = new Scanner(file); // file not found exception
            sc.useDelimiter("\\Z");
            return sc.next();
        } catch (FileNotFoundException e) {
            System.out.println("File not found! Please enter content manually.");
            sc = new Scanner(System.in);
            return sc.nextLine();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }


    public static float computeSequence(String text) {
        float sum = 0;

        try {
            if (text.length() < 2) {
                throw new IllegalArgumentException("Single digit value, cannot proceed.");
            }

            for (int i = 0; i < text.length(); i++) {
                if (!Character.isDigit(text.charAt(i))) {
                    throw new NumberFormatException("Invalid input! Text has characters in it.");
                }
            }

            float lastDigit = Character.getNumericValue(text.charAt(text.length() - 1));
            if (lastDigit == 0) {
                throw new ArithmeticException("Division by zero is not allowed.");
            }

            for (int i = 0; i < text.length() - 1; i++) {
                float currentDigit = Character.getNumericValue(text.charAt(i));
                sum += currentDigit / lastDigit;
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
            return -1; // input is invalid
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return -1; // an argument issue
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
            return -1; // division by zero
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
            return -1;
        }

        return sum;
    }


    public static void main(String[] args) {
        String text = inputString();
        System.out.println(computeSequence(text));
    }
}



