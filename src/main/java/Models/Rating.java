package Models;

import java.util.Random;
import java.util.UUID;

public class Rating {
    
    private String ratingId;
    private int rating;
    private int movieId;
    private String userName;


    public Rating(RatingBuilder builder){
        // ratingId = builder.ratingId;
        Random rand = new Random();
        ratingId = new UUID(rand.nextLong(), rand.nextLong()).toString();
        rating = builder.rating;
        movieId = builder.movieId;
        userName = builder.userName;
    }

    public Rating(String ratingId, int rating, int movieId, String userName){
        this.ratingId = ratingId;
        this.rating = rating;
        this.movieId = movieId;
        this.userName = userName;
    }

    /* Getter Methods */
    public String getRatingId() {
        return ratingId;
    }

    public int getRating() {
        return rating;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getUserName() {
        return userName;
    }


    /* Setter Methods */
    public void setRatingId(String ratingId) {
        this.ratingId = ratingId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }



    /* Builder Class */
    static public class RatingBuilder{
        private String ratingId;
        private int rating;
        private int movieId;
        private String userName;

        public RatingBuilder ratingId(String id){
            this.ratingId = id;
            return this;
        }

        public RatingBuilder rating(int num)
        {
            this.rating = num;
            return this;
        }

        public RatingBuilder movieId(int movie)
        {
            this.movieId = movie;
            return this;
        }

        public RatingBuilder userName(String name)
        {
            this.userName = name;
            return this;
        }

        public Rating build()
        {
            return new Rating(this);
        }
    }
}