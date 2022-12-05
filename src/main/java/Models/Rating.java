package Models;

import java.util.Random;
import java.util.UUID;

public class Rating {
    
    private String ratingId;
    private int rating;
    private int movieId;
    private String userName;


    public Rating(RatingBuilder builder){
        rating = builder.rating;
        movieId = builder.movieId;
        userName = builder.userName;
        ratingId = builder.ratingId;
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
        private int rating = -1;
        private int movieId;
        private String userName;
        private String ratingId;

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

        public void newId(){
            Random rand = new Random();
            ratingId = new UUID(rand.nextLong(), rand.nextLong()).toString();
            // return this;
        }

        public RatingBuilder ratingId(String ratingId){
            this.ratingId = ratingId;
            return this;
        }

        public Rating build()
        {
            if (ratingId == null)
                newId();
            return new Rating(this);
        }
    }
}