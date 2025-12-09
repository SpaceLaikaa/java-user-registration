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

}
