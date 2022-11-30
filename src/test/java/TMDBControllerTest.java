import static org.junit.Assert.assertEquals;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TMDBControllerTest implements TestConstants{

    // Testing Variables
    private TMDBController controller;
    private String key = "7f8fa1bf325f4325f96ae5abae237bd1";


    // Initialize the controller
    @Before
    public void before(){
        controller = new TMDBController(key);
    }


    @Test
    public void testGetMovieData(){
        controller.getMovieData(464052);
    }

    @Test
    public void testSearchMovieName(){
        controller.searchMovieName("The Dark Knight");
    }

}
