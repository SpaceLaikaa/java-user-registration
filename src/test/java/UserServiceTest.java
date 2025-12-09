import org.example.UserService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    UserService us = new UserService();
    @Test
    void testNullPasswordThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> {
                us.registerUser("Arda", null, 19);
        });
    }

    @Test
    void testUnderageUser(){
        assertThrows(IllegalArgumentException.class, () -> {
           us.registerUser("Arda", "123456",15);
        });
    }

    @Test
    void testBlockedPasswords(){
        assertThrows(IllegalArgumentException.class, () -> {
           us.registerUser("Arda","12345admin6superPassword", 19);

        });
    }

}
