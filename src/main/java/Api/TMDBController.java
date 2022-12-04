package Api;
import java.util.List;

import Models.Movie;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.TmdbPeople.PersonResultsPage;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.people.Person;

public class TMDBController extends ApiKey {
    private static final String ENGLISH_LANG = "en";
    private TmdbApi api;
    private TmdbMovies movies;
    private TmdbSearch search;

    public TMDBController(){
        api = new TmdbApi(apiKey);
        movies = api.getMovies();
        search = new TmdbSearch(api);
    }

    public Movie getMovieData(int movieId){
        MovieDb movie = movies.getMovie(movieId, ENGLISH_LANG);
        Movie testMovie = new Movie(movie);
        return testMovie;    
    }

    public List<MovieDb> searchMovieName(String movieName){
        MovieResultsPage mrp = search.searchMovie(movieName, 0, ENGLISH_LANG, false, 0);
        List<MovieDb> list = mrp.getResults();
        return list;
    }

    public List<Person> searchPerson(String personName){        
        PersonResultsPage prp = search.searchPerson(personName, false, 0);
        List<Person> list = prp.getResults();
        return list;        
    }

    public List<MovieDb> getSimilarMovies(int movieId) {
        MovieResultsPage mrp = movies.getSimilarMovies(movieId, apiKey, null);
        return mrp.getResults();
    }

    public List<MovieDb> getHighlyRatedMovies(){
        MovieResultsPage mrp = movies.getTopRatedMovies(ENGLISH_LANG, 0);
        return mrp.getResults();
    }    
}
