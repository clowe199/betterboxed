import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Models.Movie;

public class MovieTest extends TestConstants {
    
    private Movie m = null;

    @Before
    public void setup(){
        m = new Movie.MovieBuilder()
            .movieId(TEST_MOVIE_ID)
            .movieName(TEST_TITLE)
            .releaseDate(TEST_RELEASE_DATE)
            .averageRating(TEST_AVG_RATING)
            .build();    
    }

    @After
    public void cleanup(){
        m = null;
    }

    @Test
    public void testCreateMovie() {
        m = new Movie.MovieBuilder()
            .movieId(TEST_MOVIE_ID)
            .movieName(TEST_TITLE)
            .releaseDate(TEST_RELEASE_DATE)
            .averageRating(TEST_AVG_RATING)
            .build();
        assertEquals(TEST_TITLE, m.getMovieName());
        assertEquals(TEST_MOVIE_ID, m.getMovieId());
        assertEquals(TEST_RELEASE_DATE, m.getReleaseDate());
        assertEquals(TEST_AVG_RATING, m.getAverageRating());

    }

    //test creat via MovieDb Constructor

}
