package Models;

public class Rating {
    
    private int ratingId;
    private int rating;
    private int movieId;
    private String userName;


    public Rating(RatingBuilder builder){
        ratingId = builder.ratingId;
        rating = builder.rating;
        movieId = builder.movieId;
        userName = builder.userName;
    }

    public Rating(int ratingId, int rating, int movieId, String userName){
        this.ratingId = ratingId;
        this.rating = rating;
        this.movieId = movieId;
        this.userName = userName;
    }

    /* Getter Methods */
    public int getRatingId() {
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
    public void setRatingId(int ratingId) {
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
        private int ratingId;
        private int rating;
        private int movieId;
        private String userName;

        public RatingBuilder ratingId(int id){
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