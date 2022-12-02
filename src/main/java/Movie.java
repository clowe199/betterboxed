import java.util.List;

import info.movito.themoviedbapi.model.Genre;
import info.movito.themoviedbapi.model.MovieDb;

public class Movie {
    private String movieName;
    private int movieId;
    private String releaseDate;
    private double averageRating;
    private List<Genre> genres;
    // private List<Comment> comments;
    // private List<Comment> commentList;

    public Movie(MovieBuilder b){
        movieName = b.movieName;
        movieId = b.movieId;
        this.releaseDate = b.releaseDate;
        this.averageRating = b.averageRating;
    }

    public Movie(MovieDb mdb){
        movieName = mdb.getTitle();
        movieId = mdb.getId();
        releaseDate = mdb.getReleaseDate();
        averageRating = mdb.getVoteAverage();
        genres = mdb.getGenres();
        // comments = new List<Comment>();
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

    public List<Genre> getGenres(){
        return genres;
    }

    public String toString(){
        return movieName + "; id: " + movieId + "; release: " + releaseDate 
            + "; avg rating: " + averageRating + "; \ngenres: " + genres;
    }

    static public class MovieBuilder {
        private String movieName;
        private int movieId;
        private String releaseDate;
        private double averageRating;

        public MovieBuilder movieName(String user)
        {
            this.movieName = user;
            return this;
        }

        public MovieBuilder movieId(int id)
        {
            this.movieId = id;
            return this;
        }

        public MovieBuilder releaseDate(String date)
        {
            this.releaseDate = date;
            return this;
        }

        public MovieBuilder averageRating(double rating)
        {
            this.averageRating = rating;
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }
    }

}