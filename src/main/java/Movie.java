public class Movie {
    private String movieName;
    private int movieId;
    private String releaseDate;
    private double averageRating;
    // private List<Comment> commentList;

    public Movie(String name, int id, String releaseDate, double averageRating){
        movieName = name;
        movieId = id;
        this.releaseDate = releaseDate;
        this.averageRating = averageRating;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public String getMovieName(){
        return movieName;
    }
}
