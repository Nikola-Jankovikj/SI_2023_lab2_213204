import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    void everyBranchForFunction() {
        assertAll("All branch test:",
                () -> assertThrows(RuntimeException.class, () -> SILab2.function(null, null)),
                () -> assertFalse(SILab2.function(new User(null, "pass!", "someone@email.com"),
                        List.of(new User("someone@email.com", "password!", "someone@email.com"), new User("ricky", "pass!", "someoneElse@email.com")))),
                () -> assertFalse(SILab2.function(new User("stan", "password 2$", "bademail"), List.of(new User("stan", "password2!", "someone@emai.com")))),
                () -> assertFalse(SILab2.function(new User("stan", "password2$", "bademail"), List.of(new User("stan", "password2!", "someone@emai.com")))),
                () -> assertTrue(SILab2.function(new User("stan", "password2!", "someone@email.com"), List.of(new User("rick", "password3", "someoneElse@email.com"))))
        );
    }

    @Test
    void multipleConditionsForFunction(){
        assertAll("Multiple conditions test:",
                () -> assertThrows(RuntimeException.class, () -> SILab2.function(null, null)),
                () -> assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", null, null), null)),
                () -> assertThrows(RuntimeException.class, () -> SILab2.function(new User("username", "password", null), null)),
                () -> assertDoesNotThrow(() -> SILab2.function(new User("username", "password", "email"), null))
        );
    }
}
