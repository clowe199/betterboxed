import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CollectionTest {
    final private String NAME = "name";
    final private int MOVIE_ID = 123;
    final private String RELEASE_DATE = "00/00/00";
    final private double AVG_RATING = 5.0;

    //probably will add some kind of before and after
    //tags, still struggling to get them to work consistently

    @Test
    void testAddMovie() {
        Collection c = new Collection();
        Movie m = new Movie(NAME, MOVIE_ID, RELEASE_DATE, AVG_RATING);
        assertFalse(c.getMovieList().contains(m));
        c.addMovie(m);
        assertTrue(c.getMovieList().contains(m));
    }

    @Test
    void testRemove() {
        Collection c = new Collection();
        Movie m = new Movie(NAME, MOVIE_ID, RELEASE_DATE, AVG_RATING);
        assertFalse(c.getMovieList().contains(m));
        c.addMovie(m);
        assertTrue(c.getMovieList().contains(m));
        c.remove(m);
        assertFalse(c.getMovieList().contains(m));
    }
}
