package Tasks.Movie;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MovieApp[] movies = new MovieApp[3];

        while(true){
            System.out.println("Press\n1 - to input movies\n2 - to display movies and ratings\n0 - to exit");

            int input = sc.nextInt();
            switch(input){
                case 1 -> addMovie(movies);
                case 2 -> listMovie(movies);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Enter valid input");
            }
        }
    }


    public static void addMovie(MovieApp[] mov){
        for(int i = 0; i< 3 ; i++){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter movie name:");
            String name = sc.nextLine();
            System.out.println("Enter rating");
            double rating = sc.nextDouble();
            mov[i] =  new MovieApp(name, rating);
        }
    }

    public static void listMovie(MovieApp[] movi){
        for (MovieApp m : movi) {
            System.out.println(m);
        }
    }
}



