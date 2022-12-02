import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

public class UserDataTest extends TestConstants {
    private UserData data;

    @Before
    public void setup(){
        this.data = new UserData.UserDataBuilder()
        		.password(new char[] {'p','a','s','s'})
        		.username(new char[] {'u','s','e','r'})
        		.emailAddress("address")
        		.build();
    }

    @After
    public void cleanup(){
        data = null;
    }

    @Test
    public void testNewUserData(){
        setup();
        assertEquals("address", data.getEmailAddress());
        assertArrayEquals(new char[] {'p','a','s','s'}, data.getPassword());
        assertArrayEquals(new char[] {'u','s','e','r'}, data.getUsername());
        assertEquals(UserData.WATCHED_TITLE, data.getWatchedList().getName());
        assertEquals(UserData.WATCH_LATER_TITLE, data.getWatchLaterList().getName());
    }

    @Test
    public void testAddAndRemoveToWatched(){
        setup();
        Movie m = new Movie.MovieBuilder()
            .movieId(MOVIE_ID)
            .movieName(NAME)
            .releaseDate(RELEASE_DATE)
            .averageRating(AVG_RATING)
            .build();
        data.addToWatched(m);
        assertTrue(data.watchedContains(m));
        data.removeFromWatched(m);
        assertFalse(data.watchedContains(m));
    }

    @Test
    public void testAddAndRemoveToWatchLater(){
        setup();
        Movie m = new Movie.MovieBuilder()
            .movieId(MOVIE_ID)
            .movieName(NAME)
            .releaseDate(RELEASE_DATE)
            .averageRating(AVG_RATING)
            .build();        
        data.addToWatchLater(m);
        assertTrue(data.watchLaterContains(m));
        data.removeFromWatchLater(m);
        assertFalse(data.watchLaterContains(m));
    }

    @Test
    public void testAddAndRemoveCollection(){
        setup();
        data.addCollection(COLLECTION_NAME1);
        data.addCollection(COLLECTION_NAME1);
        data.addCollection(COLLECTION_NAME2);
        data.addCollection(COLLECTION_NAME3);

        assertTrue(data.containsCollection(COLLECTION_NAME1));
        assertTrue(data.containsCollection(COLLECTION_NAME2));
        assertTrue(data.containsCollection(COLLECTION_NAME3));
        assertFalse(data.containsCollection(COLLECTION_NAME4));

        data.removeCollection(COLLECTION_NAME1);
        data.removeCollection(COLLECTION_NAME2);
        data.removeCollection(COLLECTION_NAME4);

        assertFalse(data.containsCollection(COLLECTION_NAME1));
        assertFalse(data.containsCollection(COLLECTION_NAME2));
        assertTrue(data.containsCollection(COLLECTION_NAME3));
        assertFalse(data.containsCollection(COLLECTION_NAME4));
    }

    @Test
    public void testAddAndRemoveFromCollection(){
        setup();
        data.addCollection(COLLECTION_NAME1);
        Movie m = new Movie.MovieBuilder()
            .movieId(MOVIE_ID)
            .movieName(NAME)
            .releaseDate(RELEASE_DATE)
            .averageRating(AVG_RATING)
            .build(); 
                   
        data.addToCollection(m, COLLECTION_NAME1);
        assertTrue(data.collectionContains(m, COLLECTION_NAME1));

        data.removeFromCollection(m, COLLECTION_NAME1);
        assertFalse(data.collectionContains(m, COLLECTION_NAME1));
    }
}
