package test;

import model.User;
import org.junit.Before;
import org.junit.Test;

public class TestCase {
    private User user;

    @Before
    public void setUp() {
        user = new User("John", "john2", "joone", "john@gamil.com", " ", " ");
    }

    @Test
    public void testLogin() {
        assert user.getUsername().equals("John");
        assert user.getPassword().equals("john2");
    }

//    @Test
//    public void testRegister() {
//        User newUser = new User("Alice", "alice123", "alice", "alice@gmail.com", "pass123", " ");
//
//        boolean registerResult = newUser.register();
//        assertTrue(registerResult);
//    }
}
