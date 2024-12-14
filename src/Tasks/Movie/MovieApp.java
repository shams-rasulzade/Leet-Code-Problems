package Tasks.Movie;

public class MovieApp {
    private String name;
    private double rating;

    public MovieApp(String name, double rating){
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
       this.rating = rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}