import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Test;

import Models.Rating;

public class RatingTest extends TestConstants{
    private Rating ratingTest;

    @Test
    public void testNewRating(){
        this.ratingTest = new Rating.RatingBuilder()
               .rating(RATING)
               .movieId(SEARCH_MOVIE_ID)
               .userName(USERNAME_STRING)
               .build();

        assertEquals(TEST_RATING_ID.length(), ratingTest.getRatingId().length());
        assertEquals(RATING, ratingTest.getRating());
        assertEquals(SEARCH_MOVIE_ID, ratingTest.getMovieId());
        assertEquals(USERNAME_STRING, ratingTest.getUserName());
    }

    @Test
    public void testOldRating(){
        this.ratingTest = new Rating.RatingBuilder()
            .ratingId(TEST_RATING_ID)
            .rating(RATING)
            .movieId(SEARCH_MOVIE_ID)
            .userName(USERNAME_STRING)
            .build();

        assertEquals(TEST_RATING_ID, ratingTest.getRatingId());
        assertEquals(RATING, ratingTest.getRating());
        assertEquals(SEARCH_MOVIE_ID, ratingTest.getMovieId());
        assertEquals(USERNAME_STRING, ratingTest.getUserName());
    }

    @After
    public void cleanup(){
        ratingTest = null;
    }
}
