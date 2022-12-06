package Api;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Api.TMDBController;
import Constants.TestConstants;
import Models.LocalPerson;
import Models.Movie;
import info.movito.themoviedbapi.model.MovieDb;
import info.movito.themoviedbapi.model.people.Person;
import info.movito.themoviedbapi.model.people.PersonCredit;
import info.movito.themoviedbapi.model.people.PersonCredits;


public class TMDBControllerTest extends TestConstants{

    // Testing Variables
    private TMDBController controller;

    // Initialize the controller
    @Before
    public void before(){
        controller = new TMDBController();
    }

    @After
    public void cleanup(){
        controller = null;
    }

    @Test
    public void testGetMovieData(){
        MovieDb m = controller.getMovieData(SEARCH_MOVIE_ID);
        assertEquals(SEARCH_MOVIE_ID, m.getId());
        assertTrue(m.getVoteAverage() >= 0 && m.getVoteAverage() <= 10);
        assertEquals(SEARCH_TITLE, m.getTitle());
        assertEquals(SEARCH_RELEASE_DATE, m.getReleaseDate());
    }

    @Test
    public void testSearchMovieName(){
        List<MovieDb> list = controller.searchMovieName(SEARCH_MOVIE_QUERY);
        MovieDb m = list.get(0);
        assertEquals(SEARCH_MOVIE_ID, m.getId());
        assertTrue(m.getVoteAverage() >= 0 && m.getVoteAverage() <= 10);
        assertEquals(SEARCH_TITLE, m.getTitle());
        assertEquals(SEARCH_RELEASE_DATE, m.getReleaseDate());
    }

    @Test
    public void testGetPersonData(){
        PersonCredits p = controller.getPersonData(SEARCH_PERSON_ID);
        List<Integer> movieIds = new ArrayList<Integer>();
        List<PersonCredit> list = p.getCast();
        for (PersonCredit credit : list) {
            movieIds.add(credit.getId());
        }
        assertTrue(movieIds.contains(SEARCH_MOVIE_ID));
    }

    @Test
    public void testSearchPerson(){
        List<Person> list = controller.searchPerson(SEARCH_PERSON_QUERY);
        LocalPerson p = new LocalPerson(list.get(0));
        assertEquals(SEARCH_PERSON_ID, p.getId());
        assertEquals(SEARCH_PERSON_NAME, p.getName());
    }

    @Test
    public void testGetSimilarMovies(){
        List<MovieDb> list = controller.getSimilarMovies(SEARCH_MOVIE_ID);
        assertTrue(list.size() > 0); //nothing else is consistent about this method other than that it returns movies
        assertFalse(list.equals(null));

    }

    @Test
    public void testGetHighlyRatedMovies(){
        List<MovieDb> list = controller.getHighlyRatedMovies();
        assertTrue(list.size() > 0); //nothing else is consistent about this method other than that it returns movies
        assertFalse(list.equals(null));
    }

}
