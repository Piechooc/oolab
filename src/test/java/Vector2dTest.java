import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {

    @Test
    void testToString() {
        assertEquals("(12,34)", new Vector2d(12, 34).toString());
        assertEquals("(-876,0)", new Vector2d(-876, 0).toString());
    }

    @Test
    void testPrecedes() {
        assertTrue(new Vector2d(1, 1).precedes(new Vector2d(2, 2)));
        assertTrue(new Vector2d(1, 1).precedes(new Vector2d(2, 3)));
        assertTrue(new Vector2d(2, 2).precedes(new Vector2d(2, 3)));
        assertFalse(new Vector2d(2, 2).precedes(new Vector2d(1, 1)));
    }

    @Test
    void testFollows() {
        assertTrue(new Vector2d(2, 3).follows(new Vector2d(2, 2)));
        assertTrue(new Vector2d(2, 3).follows(new Vector2d(1, 1)));
        assertTrue(new Vector2d(2, 2).follows(new Vector2d(1, 1)));
        assertFalse(new Vector2d(1, 1).follows(new Vector2d(2, 2)));
    }

    @Test
    void testUpperRight() {
        assertEquals(new Vector2d(3, 2), new Vector2d(2, 2).upperRight(new Vector2d(3, 1)));
        assertEquals(new Vector2d(6, 4), new Vector2d(4, 4).upperRight(new Vector2d(6, 2)));
        assertEquals(new Vector2d(4, 7), new Vector2d(-1, 7).upperRight(new Vector2d(4, -2)));
    }

    @Test
    void testLowerLeft() {
        assertEquals(new Vector2d(2, 1), new Vector2d(2, 2).lowerLeft(new Vector2d(3, 1)));
        assertEquals(new Vector2d(4, 2), new Vector2d(4, 4).lowerLeft(new Vector2d(6, 2)));
        assertEquals(new Vector2d(-1, -2), new Vector2d(-1, 7).lowerLeft(new Vector2d(4, -2)));
    }

    @Test
    void testAdd() {
        assertEquals(new Vector2d(1, 2), new Vector2d(1, 0).add(new Vector2d(0, 2)));
        assertEquals(new Vector2d(37, 13), new Vector2d(1, 11).add(new Vector2d(36, 2)));
        assertEquals(new Vector2d(9, 8), new Vector2d(-1, 10).add(new Vector2d(10, -2)));
    }

    @Test
    void testSubtract() {
        assertEquals(new Vector2d(1, -2), new Vector2d(1, 0).subtract(new Vector2d(0, 2)));
        assertEquals(new Vector2d(-35, 9), new Vector2d(1, 11).subtract(new Vector2d(36, 2)));
        assertEquals(new Vector2d(-11, 12), new Vector2d(-1, 10).subtract(new Vector2d(10, -2)));
    }

    @Test
    void testEquals() {
        assertEquals(new Vector2d(1, 2), new Vector2d(1, 2));
        assertNotEquals(new Vector2d(1, 2), new Vector2d(2, 1));
    }

    @Test
    void testOpposite() {
        assertEquals(new Vector2d(-1, -2), new Vector2d(1, 2).opposite());
        assertEquals(new Vector2d(1, 2), new Vector2d(-1, -2).opposite());
        assertEquals(new Vector2d(1, 0), new Vector2d(-1, 0).opposite());
        assertNotEquals(new Vector2d(1, 2), new Vector2d(1, 2).opposite());
    }
}
