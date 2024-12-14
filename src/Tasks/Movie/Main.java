package Tasks.Movie;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieApp[] movies = new MovieApp[3];

        while (true) {
            System.out.print("""
                    Press 1 to input movies
                    Press 2 to display movies and ratings
                    Press 3 to input more movies
                    Press 4 to find statistics
                    Press 5 to search movie
                    Press 6 to update rating of the movie
                    Press 7 to delete a movie
                    Press 0 to exit
                    """);

            int input = sc.nextInt();
            switch (input) {
                case 1 -> addMovie(movies);
                case 2 -> listMovie(movies);
                case 3 -> movies = addAdditional(movies);
                case 4 -> showStatictics(movies);
                case 5 -> findMovie(movies);
                case 6 -> updateRating(movies);
                case 7 -> movies = deleteMovie(movies);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Enter valid input");
            }
        }
    }

    public static void addMovie(MovieApp[] movies) {
        for (int i = 0; i < movies.length; i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter movie name:");
            String name = sc.nextLine();
            System.out.println("Enter rating");
            double rating = sc.nextDouble();
            movies[i] = new MovieApp(name, rating);
        }
    }

    public static MovieApp[] addAdditional(MovieApp[] movies) {
        Scanner sc = new Scanner(System.in);
        int prevlength = movies.length;
        System.out.print("Number of movies you want to add: ");
        int number = sc.nextInt();
        sc.nextLine(); // after int/double there is buffer empty line
        MovieApp[] newMovies = new MovieApp[movies.length + number];

        System.arraycopy(movies, 0, newMovies, 0, movies.length);

        for (int i = prevlength; i < newMovies.length; i++) {
            System.out.println("Enter movie name:");
            String name = sc.nextLine();
            System.out.println("Enter rating:");
            double rating = sc.nextDouble();
            sc.nextLine();
            newMovies[i] = new MovieApp(name, rating);
        }

        return newMovies;
    }

    public static void listMovie(MovieApp[] movies) {
        for (MovieApp m : movies) {
            System.out.println(m);
        }
    }

    public static void showStatictics(MovieApp[] movies) {
        double ratingSum = 0;
        for (int i = 0; i < movies.length; i++) {
            ratingSum += movies[i].getRating();
        }
        System.out.printf("Average rating  is: %.2f%n", ratingSum / movies.length);

        double max = movies[0].getRating();
        String maxMovie = "";

        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getRating() > max) {
                maxMovie = String.valueOf(movies[i].getName());
                ;
            }
        }

        System.out.println("Movie with maxiumum rating: " + maxMovie);

        double min = movies[0].getRating();
        String minMovie = "";

        for (int i = 0; i < movies.length; i++) {
            if (movies[i].getRating() < min) {
                minMovie = String.valueOf(movies[i].getName());
            }
        }

        System.out.println("Movie with minimum rating: " + minMovie);
    }


    public static void findMovie(MovieApp[] movies) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the movie you are searching for:");
        String name = sc.nextLine();
        for (int i = 0; i < movies.length; i++) {
            if (Objects.equals(movies[i].getName(), name)) {
                System.out.println("Name of the movie: " + movies[i].getName() + "\nRating of the movie: " + movies[i].getRating());
                return;
            }
        }

        System.out.println("Movie not found!");
    }

    public static void updateRating(MovieApp[] movies) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the movie you want to update: ");
        String name = sc.nextLine();
        for (int i = 0; i < movies.length; i++) {
            if (Objects.equals(movies[i].getName(), name)) {
                System.out.println("Name of the movie: " + movies[i].getName() + "\nRating of the movie: " + movies[i].getRating());
                System.out.print("Enter new rating: ");
                double newRating = sc.nextDouble();
                movies[i].setRating(newRating);
                return;
            }
        }
        System.out.println("Movie not found!");
    }

    public static MovieApp[] deleteMovie(MovieApp[] movies) {
        Scanner sc = new Scanner(System.in);

        MovieApp[] newMovie = new MovieApp[movies.length - 1];


        System.out.print("Enter the movie you want to update: ");
        String name = sc.nextLine();

        int i = 0, j = 0;
        while (i < movies.length) {
            if (Objects.equals(movies[i].getName(), name)) {
                i++;
                continue;
            }

            newMovie[j] = movies[i];
            i++;
            j++;
        }

        System.out.println("Movie deleted!");
        return newMovie;
    }
}





/*

To do

- add exceptions
- edge cases
- what if we have 2 movies with the same rating(how to calculate max and min)
- dd lowercase uppercase/ contains scenarios for searching
- decrease Scanner object creation
- fix issue: doesn't print name of the movie that has minimum rating sometimes
- use index in finding movies so you can reuse that code
- add code for removing movie where the movie is not listed
- improve deleteMovie method use arraycopy
- task 8
 */