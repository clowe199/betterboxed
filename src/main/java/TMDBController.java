import info.movito.themoviedbapi.TmdbAccount;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbKeywords;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbMovies.MovieMethod;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;


public class TMDBController {
    private TmdbApi apiKey;
    private TmdbAccount userAccount;
    private TmdbMovies movies;
    private MovieDb movie;
    private String key;
    private String query;

    public void TMDBController(String newKey){
        apiKey = new TmdbApi(newKey);
        setKey(newKey);
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void getResponse(){
        MovieMethod search = new Tmdb;
        movie = movies.getMovie(464052, "en", search);
        System.out.println(movie);
    }

    public void getMovieData(int movieId){
        movie = movies.getMovie(movieId, "en");
    }

    public void searchMovieName(String movieName){
        MovieResultsPage resultsPage;
        //TmdbKeywords keyword = new TmdbKeywords(apiKey);
        resultsPage = keyword.getKeywordMovies(movieName, "en", 1);
    }
    

    public static void main(String args[]){
        TMDBController myController = new TMDBController();
        myController.getMovieData(464052);

        myController.searchMovieName("Marvel");
    }
}
