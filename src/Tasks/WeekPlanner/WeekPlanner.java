package Tasks.WeekPlanner;

import java.util.Scanner;

public class WeekPlanner {

    public static String[][] createschedule() {
        Scanner sc = new Scanner(System.in);

        String[][] schedule = {{"Monday", ""}, {"Tuesday", ""}, {"Wednesday", ""}, {"Thursday", ""}, {"Friday", ""}, {"Saturday", ""}, {"Sunday", ""}};

        for (int i = 0; i < schedule.length; i++) {
            System.out.print("Enter the task for " + schedule[i][0] + ": ");
            schedule[i][1] = sc.nextLine();
        }

        System.out.println("Schedule is created!");
        return schedule;
    }

    public static String[][] reschedule(String[][] schedule, String day) {
        Scanner sc = new Scanner(System.in);
        boolean dayFound = false;

        for (int i = 0; i < schedule.length; i++) {
            if (schedule[i][0].equalsIgnoreCase(day)) {
                System.out.print("Enter the task: ");
                schedule[i][1] = sc.nextLine();
                System.out.println("Schedule is changed!");
                dayFound = true;
                break;
            }
        }
        if (!dayFound) {
            System.out.println("Input is incorrect, please, try again!");
        }
        return schedule;
    }

    public static int getDayIndex(String day) {
        String[] days = {"MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY"};
        for (int i = 0; i < days.length; i++) {
            if (days[i].equals(day)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Hello, please create your schedule first!");
        String[][] schedule = createschedule();

        while (true) {
            System.out.println("Enter a day of the week, 'Reschedule [day]/ Change [day]', or 'Exit':");
            String input = sc.nextLine().trim().toUpperCase();
            String day = input.split(" ")[0];


            switch (day) {
                case "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "SUNDAY" -> {
                    int dayIndex = getDayIndex(day.split(" ")[0]);
                    if (dayIndex != -1) {
                        System.out.println("Your tasks for " + schedule[dayIndex][0] + ": " + schedule[dayIndex][1]);
                    } else {
                        System.out.println("Invalid day of the week.");
                    }
                }
                case "EXIT" -> {
                    return;
                }
                case "RESCHEDULE", "CHANGE" -> {
                    reschedule(schedule, input.split(" ")[1]);
                }
                default -> System.out.println("Invalid day. Please try again.");

            }
        }
    }
}