import info.movito.themoviedbapi.TmdbAccount;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbMovies.MovieMethod;
import info.movito.themoviedbapi.model.MovieDb;


public class TMDBController {
    private TmdbApi apiKey;
    private TmdbAccount userAccount;
    private TmdbMovies movies;
    private String key;
    private String query;

    public TMDBController(String key){
        apiKey = new TmdbApi(key);
    }

    public void getMovieData(int movieId){
        movies = apiKey.getMovies();
        movies.getMovie(movieId, "en", MovieMethod.credits, MovieMethod.images, MovieMethod.similar);
    }

    
    public void searchMovieName(String movieName){
        query = "https://api.themoviedb.org/3/search/movie?api_key=" + key + "&query=" + movieName;
        System.out.println(query);
    }

/*
    public static void main(String[] args) {
        TMDBController controller = new TMDBController("7f8fa1bf325f4325f96ae5abae237bd1");

        controller.searchMovieName("The Dark Knight");
        controller.getMovieData(464052);
    }
    */
}
