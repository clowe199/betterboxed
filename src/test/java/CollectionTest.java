// import static org.junit.Assert.assertFalse;
// import static org.junit.Assert.assertTrue;
// import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class CollectionTest extends TestConstants {

    //probably will add some kind of before and after
    //tags, still struggling to get them to work consistently
    @Test
    public void testAddMovie() {
        Collection c = new Collection();
        Movie m = new Movie.MovieBuilder()
            .movieId(TEST_MOVIE_ID)
            .movieName(TEST_TITLE)
            .releaseDate(TEST_RELEASE_DATE)
            .averageRating(TEST_AVG_RATING)
            .build();        
        assertFalse(c.getMovieList().contains(m));
        c.add(m);
        assertTrue(c.getMovieList().contains(m));
    }

    @Test
    public void testRemove() {
        Collection c = new Collection();
        Movie m = new Movie.MovieBuilder()
            .movieId(TEST_MOVIE_ID)
            .movieName(TEST_TITLE)
            .releaseDate(TEST_RELEASE_DATE)
            .averageRating(TEST_AVG_RATING)
            .build();
        c.getMovieList().add(m);
        assertTrue(c.getMovieList().contains(m));
        c.remove(m);
        assertFalse(c.getMovieList().contains(m));
    }

    @Test
    public void testContains(){
        Collection c = new Collection();
        Movie m = new Movie.MovieBuilder()
            .movieId(TEST_MOVIE_ID)
            .movieName(TEST_TITLE)
            .releaseDate(TEST_RELEASE_DATE)
            .averageRating(TEST_AVG_RATING)
            .build();        
        
        c.getMovieList().add(m);
        assertTrue(c.contains(m));
        c.getMovieList().remove(m);
        assertFalse(c.contains(m));
    }
}
