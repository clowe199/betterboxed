import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.After;
// import org.junit.Before;
import org.junit.jupiter.api.Test;

public class MovieTest {
    
    private Movie m = null;
    final private String NAME = "name";
    final private int MOVIE_ID = 123;
    final private String RELEASE_DATE = "00/00/00";
    final private double AVG_RATING = 5.0;

    // @Before
    // public void setup(){
    //     m = new Movie(NAME, MOVIE_ID, RELEASE_DATE, AVG_RATING);
    // }

    // @After
    // public void cleanup(){
    //     m = null;
    // }

    @Test
    void testCreateMovie() {
        m = new Movie(NAME, MOVIE_ID, RELEASE_DATE, AVG_RATING);
        assertEquals(NAME, m.getMovieName());
        assertEquals(MOVIE_ID, m.getMovieId());
        assertEquals(RELEASE_DATE, m.getReleaseDate());
        assertEquals(AVG_RATING, m.getAverageRating());

    }

}
