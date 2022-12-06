import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

import Models.Collection;

public class CollectionTest extends TestConstants {

    @Test
    public void testAddMovie() {
        Collection c = new Collection(COLLECTION_NAME1);
        assertFalse(c.getMovieList().contains(TEST_MOVIE_ID));
        c.add(TEST_MOVIE_ID);
        assertTrue(c.getMovieList().contains(TEST_MOVIE_ID));
    }

    @Test
    public void testRemove() {
        Collection c = new Collection();
        c.getMovieList().add(TEST_MOVIE_ID);
        assertTrue(c.getMovieList().contains(TEST_MOVIE_ID));
        c.remove(TEST_MOVIE_ID);
        assertFalse(c.getMovieList().contains(TEST_MOVIE_ID));
    }

    @Test
    public void testContains(){
        Collection c = new Collection();        
        c.add(TEST_MOVIE_ID);
        assertTrue(c.contains(TEST_MOVIE_ID));
        c.remove((TEST_MOVIE_ID));
        assertFalse(c.contains(TEST_MOVIE_ID));
    }
}
