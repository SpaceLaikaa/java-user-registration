import org.example.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    UserService us = new UserService();

    @Test
    void testHappyPath(){
        boolean result = us.registerUser("Arda", "123456Password",19);

        assertTrue(result, "If everything is okay user will be registered.");
    }

    @ParameterizedTest //Age tests
    @ValueSource(ints = {17, 101, 0, -5, 150})
    void testInvalidAges(int testAge){
        assertThrows(IllegalArgumentException.class, () -> {
           us.registerUser("Arda","password12345",testAge);
        });
    }

    @Test
    void testNullPasswordThrowsException(){
        assertThrows(IllegalArgumentException.class, () -> {
                us.registerUser("Arda", null, 19);
        });
    }
    @Test
    void testPasswordLength(){
        assertThrows(IllegalArgumentException.class, ()->{
           us.registerUser("Arda", "123",19);
        });
    }

    @Test
    void testBlockedPasswords(){
        assertThrows(IllegalArgumentException.class, () -> {
           us.registerUser("Arda","12345admin6superPassword", 19);

        });
    }

    @ParameterizedTest
    @ValueSource(strings = {" ","   ","ae","",})
    void testInvalidNames(String InvalidUsername){
        assertThrows(IllegalArgumentException.class, () -> {
           us.registerUser(InvalidUsername,"123456",19);
        });
    }

    @Test
    void testNullUsername(){
        assertThrows(IllegalArgumentException.class,()->{
           us.registerUser(null,"123456",19);
        });
    }
}
