import java.util.List;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.TmdbPeople.PersonResultsPage;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.people.Person;

public class TMDBController {
    private TmdbApi apiKey;
    private TmdbMovies movies;
    private TmdbSearch tSearch;
    private static final String key = "7f8fa1bf325f4325f96ae5abae237bd1";

    public TMDBController(){
        apiKey = new TmdbApi(key);
        movies = apiKey.getMovies();
        tSearch = new TmdbSearch(apiKey);
    }

    public Movie getMovieData(int movieId){
        MovieDb movie = movies.getMovie(movieId, "en");
        Movie testMovie = new Movie(movie);
        return testMovie;    
    }

    public List<MovieDb> searchMovieName(String movieName){
        MovieResultsPage mrp = tSearch.searchMovie(movieName, 0, "en", false, 0);
        List<MovieDb> list = mrp.getResults();
        return list;
    }

    public List<Person> searchPerson(String personName){        
        PersonResultsPage prp = tSearch.searchPerson(personName, false, 0);
        List<Person> list = prp.getResults();
        return list;        
    }

    public List<MovieDb> getSimilarMovies(int movieId) {
        MovieResultsPage mrp = movies.getSimilarMovies(movieId, key, null);
        return mrp.getResults();
    }

    public List<MovieDb> getHighlyRatedMovies(){
        MovieResultsPage mrp = movies.getTopRatedMovies("en", 0);
        return mrp.getResults();
    }    
}
