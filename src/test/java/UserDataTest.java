import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UserDataTest {
    @Test
    public void test_newUserData(){
        UserData data = new UserData.UserDataBuilder()
        		.password(new char[] {'p','a','s','s'})
        		.username(new char[] {'u','s','e','r'})
        		.emailAddress("address")
        		.build();
        
        assertEquals("address", data.getEmailAddress());
        assertArrayEquals(new char[] {'p','a','s','s'}, data.getPassword());
        assertArrayEquals(new char[] {'u','s','e','r'}, data.getUsername());
    }
}

//did it work??
