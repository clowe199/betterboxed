import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Accounts.UserData;

public class UserDataTest extends TestConstants {
    private UserData data;

    @Before
    public void setup(){
        this.data = new UserData.UserDataBuilder()
        		// .password(TEST_PASSWORD)
        		.username(TEST_USERNAME)
        		// .emailAddress(TEST_ADDRESS)
        		.build();
    }

    @After
    public void cleanup(){
        data = null;
    }

    @Test
    public void testNewUserData(){
        setup();
        // assertEquals(TEST_ADDRESS, data.getEmailAddress());
        // assertArrayEquals(TEST_PASSWORD, data.getPassword());
        assertEquals(TEST_USERNAME, data.getUsername());
        assertEquals(UserData.WATCHED_TITLE, data.getWatchedList().getName());
        assertEquals(UserData.WATCH_LATER_TITLE, data.getWatchLaterList().getName());
    }

    @Test
    public void testAddAndRemoveToWatched(){
        setup();
        // Movie m = new Movie.MovieBuilder()
        //     .movieId(TEST_MOVIE_ID)
        //     .movieName(TEST_TITLE)
        //     .releaseDate(TEST_RELEASE_DATE)
        //     .averageRating(TEST_AVG_RATING)
        //     .build();
        data.addToWatched(TEST_MOVIE_ID);
        assertTrue(data.watchedContains(TEST_MOVIE_ID));
        data.removeFromWatched(TEST_MOVIE_ID);
        assertFalse(data.watchedContains(TEST_MOVIE_ID));
    }

    @Test
    public void testAddAndRemoveToWatchLater(){
        setup();
        // Movie m = new Movie.MovieBuilder()
        //     .movieId(TEST_MOVIE_ID)
        //     .movieName(TEST_TITLE)
        //     .releaseDate(TEST_RELEASE_DATE)
        //     .averageRating(TEST_AVG_RATING)
        //     .build();        
        data.addToWatchLater(TEST_MOVIE_ID);
        assertTrue(data.watchLaterContains(TEST_MOVIE_ID));
        data.removeFromWatchLater(TEST_MOVIE_ID);
        assertFalse(data.watchLaterContains(TEST_MOVIE_ID));
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
        // Movie m = new Movie.MovieBuilder()
        //     .movieId(TEST_MOVIE_ID)
        //     .movieName(TEST_TITLE)
        //     .releaseDate(TEST_RELEASE_DATE)
        //     .averageRating(TEST_AVG_RATING)
        //     .build(); 
                   
        data.addToCollection(TEST_MOVIE_ID, COLLECTION_NAME1);
        assertTrue(data.collectionContains(TEST_MOVIE_ID, COLLECTION_NAME1));

        data.removeFromCollection(TEST_MOVIE_ID, COLLECTION_NAME1);
        assertFalse(data.collectionContains(TEST_MOVIE_ID, COLLECTION_NAME1));
    }
}
