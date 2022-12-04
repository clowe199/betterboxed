import Rating.Rating;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RatingTest extends TestConstants{
    private Rating ratingTest;

    @Before
    public void setup(){
        this.ratingTest = new Rating.RatingBuilder()
               .ratingId(RATING_ID)
               .rating(RATING)
               .movieId(SEARCH_MOVIE_ID)
               .userName(USERNAME)
               .build();

    }

    @Test
    public void testRatingBuilder(){
        assertEquals(RATING_ID, ratingTest.getRatingId());
        assertEquals(RATING, ratingTest.getRating());
        assertEquals(SEARCH_MOVIE_ID, ratingTest.getMovieId());
        assertEquals(USERNAME, ratingTest.getUserName());
    }

    @After
    public void cleanup(){
        ratingTest = null;
    }
}
