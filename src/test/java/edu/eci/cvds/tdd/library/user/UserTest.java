package edu.eci.cvds.tdd.library.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserTest {

    @Test
    public void shouldCompareAObjectThatIsNotAUser(){
        User user = new User();
        assertFalse(user.equals(new Object()));
    }
}
