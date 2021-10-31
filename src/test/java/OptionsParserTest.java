import agh.ics.oop.MoveDirection;
import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OptionsParserTest {

    @Test
    void testParse() {
        String[] bad = {"kmfkesa", "uahfd", "37989137", "fj3208f99v7b"};
        String[] empty = {};
        String[] mixed = {"forward", "ijvr", "wijgof", "l", "right", "4tfg4", "b"};

        assertEquals(new ArrayList<>(), OptionsParser.parse(bad));

        assertEquals(new ArrayList<>(), OptionsParser.parse(empty));

        assertEquals(new ArrayList<>(Arrays.asList(MoveDirection.FORWARD, MoveDirection.LEFT, MoveDirection.RIGHT,
                MoveDirection.BACKWARD)), OptionsParser.parse(mixed));
    }

}
