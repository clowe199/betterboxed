package Models;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Constants.TestConstants;
import Models.Comment;

public class CommentTest extends TestConstants{
    private Comment commentTest;

    @Before
    public void setup(){
        // this.commentTest = new Comment.CommentBuilder()
        //     .
        //     .rating(RATING)
        //     .movieId(SEARCH_MOVIE_ID)
        //     .userName(USERNAME)
        //     .build();

    }

    @Test
    public void testRatingBuilder(){
        // assertEquals(RATING_ID, commentTest.getRatingId()); // randomly generated id needs a different test

        commentTest = new Comment.CommentBuilder()
            .content(COMMENT_CONTENT) 
            .rating(RATING) 
            .movieId(TEST_MOVIE_ID) 
            .userName(USERNAME_STRING)  
            .parentId(PARENT_ID)
            .build();

        assertEquals(COMMENT_CONTENT, commentTest.getContent());
        assertEquals(RATING, commentTest.getRating());
        assertEquals(TEST_MOVIE_ID, commentTest.getMovieId());
        assertEquals(USERNAME_STRING, commentTest.getUserName());
        assertEquals(PARENT_ID, commentTest.getParentId());
    }

    @After
    public void cleanup(){
        commentTest = null;
    }
}
