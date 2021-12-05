import agh.ics.oop.Animal;
import agh.ics.oop.RectangularMap;
import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangularMapTest {

    @Test
    void testCanMoveTo() {
        RectangularMap testMap = new RectangularMap(8,8);
        assertFalse(testMap.canMoveTo(new Vector2d(-1, -3)));
        assertFalse(testMap.canMoveTo(new Vector2d(-4, 4)));
        assertFalse(testMap.canMoveTo(new Vector2d(-1, 8)));
        assertFalse(testMap.canMoveTo(new Vector2d(5, 9)));
        assertFalse(testMap.canMoveTo(new Vector2d(10, 11)));
        assertFalse(testMap.canMoveTo(new Vector2d(8, 5)));
        assertFalse(testMap.canMoveTo(new Vector2d(9, -2)));
        assertFalse(testMap.canMoveTo(new Vector2d(4, -3)));
        assertTrue(testMap.canMoveTo(new Vector2d(3, 4)));
        assertTrue(testMap.canMoveTo(new Vector2d(0, 0)));
        assertTrue(testMap.canMoveTo(new Vector2d(0, 7)));
        assertTrue(testMap.canMoveTo(new Vector2d(7, 0)));
        assertTrue(testMap.canMoveTo(new Vector2d(7, 7)));
    }

    @Test
    void testPlace() {
        RectangularMap testMap = new RectangularMap(8,8);
        assertThrows(IllegalArgumentException.class, () -> testMap.place(new Animal(testMap, new Vector2d(-1, -3))));
        assertThrows(IllegalArgumentException.class, () -> testMap.place(new Animal(testMap, new Vector2d(-4, 4))));
        assertThrows(IllegalArgumentException.class, () -> testMap.place(new Animal(testMap, new Vector2d(-1, 8))));
        assertThrows(IllegalArgumentException.class, () -> testMap.place(new Animal(testMap, new Vector2d(5, 9))));
        assertThrows(IllegalArgumentException.class, () -> testMap.place(new Animal(testMap, new Vector2d(10, 11))));
        assertThrows(IllegalArgumentException.class, () -> testMap.place(new Animal(testMap, new Vector2d(8, 5))));
        assertThrows(IllegalArgumentException.class, () -> testMap.place(new Animal(testMap, new Vector2d(9, -2))));
        assertThrows(IllegalArgumentException.class, () -> testMap.place(new Animal(testMap, new Vector2d(4, -3))));
        assertTrue(testMap.place(new Animal(testMap, new Vector2d(3, 4))));
        assertTrue(testMap.place(new Animal(testMap, new Vector2d(0, 0))));
        assertTrue(testMap.place(new Animal(testMap, new Vector2d(0, 7))));
        assertTrue(testMap.place(new Animal(testMap, new Vector2d(7, 0))));
        assertTrue(testMap.place(new Animal(testMap, new Vector2d(7, 7))));
        assertTrue(testMap.place(new Animal(testMap)));
        assertThrows(IllegalArgumentException.class, () -> testMap.place(new Animal(testMap)));
        assertThrows(IllegalArgumentException.class, () -> testMap.place(new Animal(testMap, new Vector2d(3, 4))));
    }

    @Test
    void testIsOccupied() {
        RectangularMap testMap = new RectangularMap(8, 8);
        testMap.place(new Animal(testMap));
        assertTrue(testMap.isOccupied(new Vector2d(2, 2)));
        assertFalse(testMap.isOccupied(new Vector2d(0, 0)));
        testMap.place(new Animal(testMap, new Vector2d(0, 0)));
        assertTrue(testMap.isOccupied(new Vector2d(0, 0)));
    }

    @Test
    void testObjectAt() {
        RectangularMap testMap = new RectangularMap(8, 8);
        Animal testAnimal = new Animal(testMap);
        testMap.place(testAnimal);
        assertEquals(testAnimal, testMap.objectAt(new Vector2d(2, 2)));
        Animal testAnimal2 = new Animal(testMap, new Vector2d(0, 0));
        assertNull(testMap.objectAt(new Vector2d(0, 0)));
        testMap.place(testAnimal2);
        assertEquals(testAnimal2, testMap.objectAt(new Vector2d(0, 0)));
    }
}
