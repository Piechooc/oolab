import agh.ics.oop.MoveDirection;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class OptionsParserTest {

    @Test
    void testParse() throws IllegalArgumentException {
        String[] bad = {"kmfkesa", "uahfd", "37989137", "fj3208f99v7b"};
        String[] empty = {};
        String[] good = {"forward", "l", "right", "b"};

        Exception exception = assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(bad));
        assertEquals("kmfkesa is not legal move specification", exception.getMessage());

        assertEquals(new ArrayList<>(), OptionsParser.parse(empty));

        assertEquals(new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT,
                MoveDirection.BACKWARD)), OptionsParser.parse(good));
    }

}
