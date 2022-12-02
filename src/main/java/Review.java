public class Review {
    private double rating; //-1 if no number associated
    private String userName;
    private int movieId;
    private int reviewId;

    public Review(double rating, String userName, int movieId) {
        this.rating = rating;
        this.userName = userName;
        this.movieId = movieId;
        reviewId = 1; //gonna need to check SQL to get a new id I think? Kyle do want to handle this one?
    }

    public Review(String userName, int movieId){
        this(-1, userName, movieId);
    }

    public double getRating() {
        return rating;
    }
    public String getUserName() {
        return userName;
    }
    public int getMovieId() {
        return movieId;
    }
    public int getReviewId() {
        return reviewId;
    }
    

    
}
