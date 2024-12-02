package Tasks.WeekPlanner;

import java.util.Scanner;

public class WeekPlanner {

    public static String[][] createscedule() {
        Scanner sc = new Scanner(System.in);

        String[][] schedule = {{"Monday", ""}, {"Tuesday", ""}, {"Wednesday", ""}, {"Thursday", ""}, {"Friday", ""}, {"Saturday", ""}, {"Sunday", ""}};

        for (int i = 0; i < schedule.length; i++) {
            System.out.print("Enter the task for " + schedule[i][0] + ": ");
            schedule[i][1] = sc.nextLine();
        }

        System.out.println("Schedule is created!");
        return schedule;
    }

    public static String[][] reschedule(String[][] schedule) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter the day of the week to change: ");
            String day = sc.nextLine().trim();

            for (int i = 0; i < schedule.length; i++) {
                if (schedule[i][0].equalsIgnoreCase(day)) {
                    System.out.print("Enter the task: ");
                    schedule[i][1] = sc.nextLine();
                    System.out.println("Schedule is changed!");
                    return schedule;
                }
            }
            System.out.println("Input is incorrect, please, try again!");
        }
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, please create your schedule first!");
        String[][] schedule = createscedule();


        while (true) {
            System.out.println("Please, enter: \n 1. Day of the week to see schedule \n 2. 'Reschedule' to change task list \n 3. 'Exit' to exit from the program ");
            String day = sc.nextLine().trim();
            if (day.equalsIgnoreCase("EXIT")) break;
            else if (day.equalsIgnoreCase("RESCHEDULE")) {
                reschedule(schedule);
                continue;
            }

            switch (day.toUpperCase()) {
                case "MONDAY" -> System.out.println("Your tasks for Monday: " + schedule[0][1]);
                case "TUESDAY" -> System.out.println("Your tasks for Tuesday: " + schedule[1][1]);
                case "WEDNESDAY" -> System.out.println("Your tasks for Wednesday: " + schedule[2][1]);
                case "THURSDAY" -> System.out.println("Your tasks for Thursday: " + schedule[3][1]);
                case "FRIDAY" -> System.out.println("Your tasks for Friday: " + schedule[4][1]);
                case "SATURDAY" -> System.out.println("Your tasks for Saturday: " + schedule[5][1]);
                case "SUNDAY" -> System.out.println("Your tasks for Sunday: " + schedule[6][1]);
                default -> System.out.println("Sorry, I don't understand you, please try again");
            }
        }
    }
}