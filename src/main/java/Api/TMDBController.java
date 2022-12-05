package Api;
import java.util.List;

import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.TmdbMovies;
import info.movito.themoviedbapi.TmdbPeople;
import info.movito.themoviedbapi.TmdbSearch;
import info.movito.themoviedbapi.TmdbPeople.PersonResultsPage;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.core.MovieResultsPage;
import info.movito.themoviedbapi.model.people.Person;
import info.movito.themoviedbapi.model.people.PersonPeople;

public class TMDBController extends ApiKey {
    private static final String ENGLISH_LANG = "en";
    private TmdbApi api;
    private TmdbMovies movies;
    private TmdbSearch search;
    private TmdbPeople people;

    public TMDBController(){
        api = new TmdbApi(apiKey);
        movies = api.getMovies();
        search = new TmdbSearch(api);
        people = api.getPeople();
    }

    public MovieDb getMovieData(int movieId){
       return movies.getMovie(movieId, ENGLISH_LANG);    
    }

    public List<MovieDb> searchMovieName(String movieName){
        MovieResultsPage mrp = search.searchMovie(movieName, 0, ENGLISH_LANG, false, 0);
        List<MovieDb> list = mrp.getResults();
        return list;
    }

    public PersonPeople getPersonData(int personId){
        return people.getPersonInfo(personId);    
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

    public static void main(String[] args) {
        TMDBController controller = new TMDBController();
        System.out.println(controller.getPersonData(74568));
        System.out.println(controller.getPersonData(74568).getBiography());

    }
}
