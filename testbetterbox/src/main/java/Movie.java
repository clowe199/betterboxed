public class Movie {
    private String movieName;
    private int movieId;
    private String releaseDate;
    private double averageRating;
    // private List<Comment> commentList;

    public Movie(MovieBuilder b){
        movieName = b.movieName;
        movieId = b.movieId;
        this.releaseDate = b.releaseDate;
        this.averageRating = b.averageRating;
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