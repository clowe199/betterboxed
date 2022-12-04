// import static org.junit.Assert.assertFalse;
// import static org.junit.Assert.assertTrue;
// import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import Models.Collection;

public class CollectionTest extends TestConstants {

    //probably will add some kind of before and after
    //tags, still struggling to get them to work consistently
    @Test
    public void testAddMovie() {
        Collection c = new Collection();
        // Movie m = new Movie.MovieBuilder()
        //     .movieId(TEST_MOVIE_ID)
        //     .movieName(TEST_TITLE)
        //     .releaseDate(TEST_RELEASE_DATE)
        //     .averageRating(TEST_AVG_RATING)
        //     .build();        
        assertFalse(c.getMovieList().contains(TEST_MOVIE_ID));
        c.add(TEST_MOVIE_ID);
        assertTrue(c.getMovieList().contains(TEST_MOVIE_ID));
    }

    @Test
    public void testRemove() {
        Collection c = new Collection();
        // Movie m = new Movie.MovieBuilder()
        //     .movieId(TEST_MOVIE_ID)
        //     .movieName(TEST_TITLE)
        //     .releaseDate(TEST_RELEASE_DATE)
        //     .averageRating(TEST_AVG_RATING)
        //     .build();
        c.getMovieList().add(TEST_MOVIE_ID);
        assertTrue(c.getMovieList().contains(TEST_MOVIE_ID));
        c.remove(TEST_MOVIE_ID);
        assertFalse(c.getMovieList().contains(TEST_MOVIE_ID));
    }

    @Test
    public void testContains(){
        Collection c = new Collection();
        // Movie m = new Movie.MovieBuilder()
        //     .movieId(TEST_MOVIE_ID)
        //     .movieName(TEST_TITLE)
        //     .releaseDate(TEST_RELEASE_DATE)
        //     .averageRating(TEST_AVG_RATING)
        //     .build();        
        
        c.getMovieList().add(TEST_MOVIE_ID);
        assertTrue(c.contains(TEST_MOVIE_ID));
        c.getMovieList().remove(new Integer(TEST_MOVIE_ID));
        assertFalse(c.contains(TEST_MOVIE_ID));
    }
}
