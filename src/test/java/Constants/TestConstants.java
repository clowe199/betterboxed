package Constants;
import Api.ApiKey;

public class TestConstants extends ApiKey {
    public static final char[] TEST_PASSWORD = new char[] {'p','a','s','s'};
    public static final String TEST_USERNAME = "user"; //new char[] {'u','s','e','r'};
    public static final String TEST_ADDRESS = "address";
    public static final String TEST_NAME = "name";
    public static final String TEST_TITLE = "movie title";
    public static final int TEST_MOVIE_ID = 123;
    public static final String TEST_RELEASE_DATE = "00/00/00";
    public static final double TEST_AVG_RATING = 5.0;

    // collection constants
    public static final String COLLECTION_NAME1 = "test collection one";
    public static final String COLLECTION_NAME2 = "test collection two";
    public static final String COLLECTION_NAME3 = "test collection three";
    public static final String COLLECTION_NAME4 = "test collection four";

    // tmdb constants 
    public static final int SEARCH_MOVIE_ID = 507086; //jw dominion
    public static final double SEARCH_AVG_RATING = 6.98; //jw dominion
    public static final String SEARCH_RELEASE_DATE = "2022-06-01"; //jw dominion
    public static final String SEARCH_TITLE = "Jurassic World Dominion";
    public static final String SEARCH_MOVIE_QUERY = "jurassic world dominion";
    public static final String SEARCH_PERSON_QUERY = "chris pratt";
    public static final String SEARCH_PERSON_NAME = "Chris Pratt";
    public static final int SEARCH_PERSON_ID = 73457; //pratt

    /* Rating Constants */
    public static final String TEST_RATING_ID = "00000000-0000-0000-0000-000000000000";
    public static final int RATING = 3;     // RATING SCALE IS 0-5
    public static final String USERNAME_STRING = "USER";
    public static final String COMMENT_CONTENT = "comment content test";
    public static final String PARENT_ID = "parent id test";
}
