import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CollectionTest implements TestConstants{
    // final private String NAME = "name";
    // final private int MOVIE_ID = 123;
    // final private String RELEASE_DATE = "00/00/00";
    // final private double AVG_RATING = 5.0;

    //probably will add some kind of before and after
    //tags, still struggling to get them to work consistently

    @Test
    void testAddMovie() {
        Collection c = new Collection();
        Movie m = new Movie.MovieBuilder()
            .movieId(MOVIE_ID)
            .movieName(NAME)
            .releaseDate(RELEASE_DATE)
            .averageRating(AVG_RATING)
            .build();        
        assertFalse(c.getMovieList().contains(m));
        c.add(m);
        assertTrue(c.getMovieList().contains(m));
    }

    @Test
    void testRemove() {
        Collection c = new Collection();
        Movie m = new Movie.MovieBuilder()
            .movieId(MOVIE_ID)
            .movieName(NAME)
            .releaseDate(RELEASE_DATE)
            .averageRating(AVG_RATING)
            .build();
        c.getMovieList().add(m);
        assertTrue(c.getMovieList().contains(m));
        c.remove(m);
        assertFalse(c.getMovieList().contains(m));
    }

    @Test
    void testContains(){
        Collection c = new Collection();
        Movie m = new Movie.MovieBuilder()
            .movieId(MOVIE_ID)
            .movieName(NAME)
            .releaseDate(RELEASE_DATE)
            .averageRating(AVG_RATING)
            .build();        
        
        c.getMovieList().add(m);
        assertTrue(c.contains(m));
        c.getMovieList().remove(m);
        assertFalse(c.contains(m));
    }
}
