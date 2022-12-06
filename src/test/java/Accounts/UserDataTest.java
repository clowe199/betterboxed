package Accounts;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Constants.TestConstants;

public class UserDataTest extends TestConstants {
    private UserData data;

    @Before
    public void setup(){
        data = new UserData.UserDataBuilder()
        		.username(TEST_USERNAME)
        		.build();
    }

    @After
    public void cleanup(){
        data = null;
    }

    @Test
    public void testNewUserData(){
        setup();
        assertEquals(TEST_USERNAME, data.getUsername());
        assertEquals(UserData.WATCHED_TITLE, data.getWatchedList().getName());
        assertEquals(UserData.WATCH_LATER_TITLE, data.getWatchLaterList().getName());
    }

    @Test
    public void testAddToWatched(){
        setup();
        assertFalse(data.getWatchedList().contains(TEST_MOVIE_ID));
        data.addToWatched(TEST_MOVIE_ID);
        assertTrue(data.getWatchedList().contains(TEST_MOVIE_ID));
    }
    @Test
    public void testAddAndRemoveToWatched(){
        setup();
        assertFalse(data.watchedContains(TEST_MOVIE_ID));
        data.addToWatched(TEST_MOVIE_ID);
        assertTrue(data.watchedContains(TEST_MOVIE_ID));
        data.removeFromWatched(TEST_MOVIE_ID);
        assertFalse(data.watchedContains(TEST_MOVIE_ID));
    }
    @Test
    public void testWatchedContains(){
        setup();
        assertFalse(data.watchedContains(TEST_MOVIE_ID));
        data.addToWatched(TEST_MOVIE_ID);
        assertTrue(data.watchedContains(TEST_MOVIE_ID));
    }

    @Test
    public void testAddToWatchLater(){
        setup();
        data.addToWatchLater(TEST_MOVIE_ID);
        assertTrue(data.watchLaterContains(TEST_MOVIE_ID));
    }
    @Test
    public void testAddAndRemoveToWatchLater(){
        setup();
        data.addToWatchLater(TEST_MOVIE_ID);
        assertTrue(data.watchLaterContains(TEST_MOVIE_ID));
        data.removeFromWatchLater(TEST_MOVIE_ID);
        assertFalse(data.watchLaterContains(TEST_MOVIE_ID));
    }
    @Test
    public void testWatchLaterContains(){
        setup();
        assertFalse(data.getWatchLaterList().contains(TEST_MOVIE_ID));
        data.addToWatchLater(TEST_MOVIE_ID);
        assertTrue(data.getWatchLaterList().contains(TEST_MOVIE_ID));
    }


    @Test
    public void testCollectionContains(){
        setup();
        data.addCollection(COLLECTION_NAME1);
        assertTrue(data.containsCollection(COLLECTION_NAME1));

        data.addCollection(COLLECTION_NAME1);
        data.addCollection(COLLECTION_NAME2);
        data.addCollection(COLLECTION_NAME3);

        assertTrue(data.containsCollection(COLLECTION_NAME1));
        assertTrue(data.containsCollection(COLLECTION_NAME2));
        assertTrue(data.containsCollection(COLLECTION_NAME3));
        assertFalse(data.containsCollection(COLLECTION_NAME4));
    }    
    @Test
    public void testAddCollection(){
        setup();
        data.addCollection(COLLECTION_NAME1);
        assertTrue(data.containsCollection(COLLECTION_NAME1));
    }
    @Test
    public void testAddAndRemoveCollection(){
        setup();
        data.addCollection(COLLECTION_NAME1);
        assertTrue(data.containsCollection(COLLECTION_NAME1));

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
    public void testGetCollectionTitles(){
        setup();
        data.addCollection(COLLECTION_NAME1);
        data.addCollection(COLLECTION_NAME2);
        data.addCollection(COLLECTION_NAME3);
        data.addCollection(COLLECTION_NAME4);

        ArrayList<String> arr = new ArrayList<String>();
        arr.add(COLLECTION_NAME1);
        arr.add(COLLECTION_NAME2);
        arr.add(COLLECTION_NAME3);
        arr.add(COLLECTION_NAME4);
        // assertLinesMatch(arr, data.getCollectionTitles());
    }

    @Test
    public void testAddToCollection(){
        setup();
        data.addCollection(COLLECTION_NAME1);
        assertFalse(data.collectionContains(TEST_MOVIE_ID, COLLECTION_NAME1));

        data.addToCollection(TEST_MOVIE_ID, COLLECTION_NAME1);
        assertTrue(data.collectionContains(TEST_MOVIE_ID, COLLECTION_NAME1));

        data.removeFromCollection(TEST_MOVIE_ID, COLLECTION_NAME1);
        assertFalse(data.collectionContains(TEST_MOVIE_ID, COLLECTION_NAME1));
    }
    @Test
    public void testAddAndRemoveFromCollection(){
        setup();
        data.addCollection(COLLECTION_NAME1);

        data.addToCollection(TEST_MOVIE_ID, COLLECTION_NAME1);
        assertTrue(data.collectionContains(TEST_MOVIE_ID, COLLECTION_NAME1));

        data.removeFromCollection(TEST_MOVIE_ID, COLLECTION_NAME1);
        assertFalse(data.collectionContains(TEST_MOVIE_ID, COLLECTION_NAME1));
    }
}
