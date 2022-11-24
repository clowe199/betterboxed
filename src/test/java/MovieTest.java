import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.After;
// import org.junit.Before;
import org.junit.jupiter.api.Test;

public class MovieTest implements TestConstants {
    
    private Movie m = null;

    // @Before
    // public void setup(){
    //     m = new Movie.MovieBuilder()
    //         .movieId(MOVIE_ID)
    //         .movieName(NAME)
    //         .releaseDate(RELEASE_DATE)
    //         .averageRating(AVG_RATING)
    //         .build();    
    // }

    // @After
    // public void cleanup(){
    //     m = null;
    // }

    @Test
    void testCreateMovie() {
        m = new Movie.MovieBuilder()
            .movieId(MOVIE_ID)
            .movieName(NAME)
            .releaseDate(RELEASE_DATE)
            .averageRating(AVG_RATING)
            .build();
        assertEquals(NAME, m.getMovieName());
        assertEquals(MOVIE_ID, m.getMovieId());
        assertEquals(RELEASE_DATE, m.getReleaseDate());
        assertEquals(AVG_RATING, m.getAverageRating());

    }

}
