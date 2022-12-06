package Api;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
        Movie m = new Movie(controller.getMovieData(SEARCH_MOVIE_ID));
        assertEquals(SEARCH_MOVIE_ID, m.getMovieId());
        assertTrue(m.getAverageRating() >= 0 && m.getAverageRating() <= 10);
        assertEquals(SEARCH_TITLE, m.getMovieName());
        assertEquals(SEARCH_RELEASE_DATE, m.getReleaseDate());
    }

    @Test
    public void testSearchMovieName(){
        List<MovieDb> list = controller.searchMovieName(SEARCH_MOVIE_QUERY);
        Movie m = new Movie(list.get(0));
        assertEquals(SEARCH_MOVIE_ID, m.getMovieId());
        assertTrue(m.getAverageRating() >= 0 && m.getAverageRating() <= 10);
        assertEquals(SEARCH_TITLE, m.getMovieName());
        assertEquals(SEARCH_RELEASE_DATE, m.getReleaseDate());
    }

    @Test
    public void testSearchPersonName(){
        List<Person> list = controller.searchPerson(SEARCH_PERSON_QUERY);
        LocalPerson p = new LocalPerson(list.get(0));
        assertEquals(SEARCH_PERSON_ID, p.getId());
        assertEquals(SEARCH_PERSON_NAME, p.getName());
    }

    @Test //not really sure how to test this one, this is what I've got for now -Nathan
    public void testGetHighlyRatedMovies(){
        List<MovieDb> list = controller.getHighlyRatedMovies();
        assertFalse(list.equals(null));
    }

    //maybe add test cases for edge cases: empty query and the such

}
