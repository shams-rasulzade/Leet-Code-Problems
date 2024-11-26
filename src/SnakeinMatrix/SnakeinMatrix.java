package SnakeinMatrix;

import java.util.ArrayList;
import java.util.List;

public class SnakeinMatrix {
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

    public static void main (String[] args){
        int length = 2;

        List<String> commands = new ArrayList<>();

        commands.add("RIGHT");
        commands.add("DOWN");
        System.out.println(finalPositionOfSnake(length, commands));
    }
}
