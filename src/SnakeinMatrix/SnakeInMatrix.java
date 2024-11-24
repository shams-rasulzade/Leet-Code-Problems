package SnakeinMatrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SnakeInMatrix {
    public static int finalPositionOfSnake(int n, List<String> commands) {
        int start = 0;

        for (int i = 0; i < commands.size(); i++) {
            switch (commands.get(i)) {
                case "UP":
                    start -= n;
                    break;
                case "RIGHT":
                    start++;
                    break;
                case "DOWN":
                    start += n;
                    break;
                case "LEFT":
                    start--;
                    break;
                default:
                    System.out.println("Invalid Command: " + start);
                    break;
            }
        }
        return start;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the length of the grid: ");
        int length = sc.nextInt();
        sc.nextLine();

        List<String> list = new ArrayList<>();

        System.out.println("Enter strings one by one: ");

        while (true) {
            String input = sc.nextLine();

            // Stop if input is empty or a space
            if (input.isEmpty()) {
                break;
            }
            list.add(input.toUpperCase());
        }

        System.out.println(finalPositionOfSnake(length, list));
    }
}

