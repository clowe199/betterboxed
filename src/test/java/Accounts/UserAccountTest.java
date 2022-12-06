package Accounts;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Constants.TestConstants;


public class UserAccountTest extends TestConstants{
    private UserAccount user;

    @Before
    public void setup(){
        user = new UserAccount(TEST_USERNAME);
    }


    @After
    public void cleanup(){
        user = null;
    }

    @Test
    public void testNewUser(){
        setup();
        assertEquals(TEST_USERNAME, user.checkUser(TEST_USERNAME));
    }
}