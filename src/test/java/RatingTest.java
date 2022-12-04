import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Models.Rating;

public class RatingTest extends TestConstants{
    private Rating ratingTest;

    @Before
    public void setup(){
        this.ratingTest = new Rating.RatingBuilder()
               .rating(RATING)
               .movieId(SEARCH_MOVIE_ID)
               .userName(USERNAME_STRING)
               .build();

    }

    @Test
    public void testRatingBuilder(){
        // assertEquals(RATING_ID, ratingTest.getRatingId()); // randomly generated id needs a different test
        assertEquals(RATING, ratingTest.getRating());
        assertEquals(SEARCH_MOVIE_ID, ratingTest.getMovieId());
        assertEquals(USERNAME_STRING, ratingTest.getUserName());
    }

    @After
    public void cleanup(){
        ratingTest = null;
    }
}
