package Tasks.Movie;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
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
                    Press 8 to sort movies
                    Press 0 to exit
                    """);

            int input = sc.nextInt();
            sc.nextLine();

            switch (input) {
                case 1 -> addMovie(movies);
                case 2 -> listMovie(movies);
                case 3 -> movies = addAdditional(movies);
                case 4 -> showStatistics(movies);
                case 5 -> findMovie(movies);
                case 6 -> updateRating(movies);
                case 7 -> movies = deleteMovie(movies);
                case 8 -> sortMovies(movies);
                case 0 -> {
                    return;
                }
                default -> System.out.println("Enter valid input");
            }
        }
    }

    public static void addMovie(MovieApp[] movies) {
        for (int i = 0; i < movies.length; i++) {
            System.out.println("Enter movie name:");
            String name = sc.nextLine();
            System.out.println("Enter rating");
            double rating = sc.nextDouble();
            sc.nextLine();
            movies[i] = new MovieApp(name, rating);
        }
    }

    public static MovieApp[] addAdditional(MovieApp[] movies) {
        int prevlength = movies.length;
        System.out.print("Number of movies you want to add: ");
        int number = sc.nextInt();
        sc.nextLine(); // after int/double there is buffer/empty line
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

    public static void showStatistics(MovieApp[] movies) {
        double ratingSum = 0;
        for (MovieApp movie : movies) {
            ratingSum += movie.getRating();
        }
        System.out.printf("Average rating  is: %.2f%n", ratingSum / movies.length);

        // Min  / Max
        double max = movies[0].getRating();
        String maxMovie = movies[0].getName();
        double min = movies[0].getRating();
        String minMovie = movies[0].getName();

        for (int i = 1; i < movies.length; i++) {
            if (movies[i].getRating() > max) {
                max = movies[i].getRating();
                maxMovie = movies[i].getName();
            }
            if (movies[i].getRating() < min) {
                min = movies[i].getRating();
                minMovie = movies[i].getName();
            }
        }

        System.out.println("Movie with maximum rating: " + maxMovie + " (" + max + ")");
        System.out.println("Movie with minimum rating: " + minMovie + " (" + min + ")");
    }


    public static int findMovie(MovieApp[] movies) {
        int index = 0;
        System.out.println("Enter the movie you are searching for:");
        String name = sc.nextLine();
        for (int i = 0; i < movies.length; i++) {
            if (Objects.equals(movies[i].getName(), name)) {
                System.out.println("Name of the movie: " + movies[i].getName() + "\nRating of the movie: " + movies[i].getRating());
                index = i;
                return index;
            }
        }

        System.out.println("Movie not found!");
        return -1;
    }

    public static void updateRating(MovieApp[] movies) {
        int index = findMovie(movies);
        if (!(index == -1)) {
            System.out.print("Enter new rating: ");
            double newRating = sc.nextDouble();
            movies[index].setRating(newRating);
        }
    }

    public static MovieApp[] deleteMovie(MovieApp[] movies) {
        int index = findMovie(movies);

        if (!(index == -1)) {
            MovieApp[] newMovie = new MovieApp[movies.length - 1];
            int i = 0, j = 0;
            while (i < movies.length) {
                if (i == index) {
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
        return movies;
    }

    public static void sortMovies(MovieApp[] movies) {
        int i, j;
        double temp;
        boolean swapped;
        for (i = 0; i < movies.length - 1; i++) {
            swapped = false;
            for (j = 0; j < movies.length - i - 1; j++) {
                if (movies[j].getRating() > movies[j + 1].getRating()) {
                    temp = movies[j].getRating();
                    movies[j].setRating(movies[j + 1].getRating());
                    movies[j + 1].setRating(temp);
                    swapped = true;
                }
            }

            if (swapped == false)
                break;
        }

        System.out.println("Movie list is sorted!");
        listMovie(movies);
    }
}


/*

To do

- add exceptions
- edge cases
- what if we have 2 movies with the same rating(how to calculate max and min)
- lowercase uppercase/ contains scenarios for searching
- improve deleteMovie method use arraycopy
- sorting - swap so it will start from higher rating to lower
 */