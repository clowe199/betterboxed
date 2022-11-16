import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class UserDataTest {

    private UserData uD = null;

    @org.junit.Test
    public void test_newUserData(){
        UserData data = new UserData(uD)
        		.password(new char[] {'p','a','s','s'})
        		.username(new char[] {'u','s','e','r'})
        		.emailAddress("address")
        		.build();
        
        
        assertEquals("address", data.getEmailAddress());
        assertArrayEquals(new char[] {'p','a','s','s'}, data.getPassword());
        assertArrayEquals(new char[] {'u','s','e','r'}, data.getUsername());
    }
}
