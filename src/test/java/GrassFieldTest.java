import agh.ics.oop.Animal;
import agh.ics.oop.GrassField;
import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void testCanMoveTo() {
        GrassField testMap = new GrassField(5);
        Animal testAnimal = new Animal(testMap, new Vector2d(1, 2));
        testMap.place(testAnimal);
        assertFalse(testMap.canMoveTo(new Vector2d(1, 2)));
        assertTrue(testMap.canMoveTo(new Vector2d(4, 3)));
    }

    @Test
    void testPlace() {
        GrassField testMap = new GrassField(10);
        assertTrue(testMap.place(new Animal(testMap, new Vector2d(0, 0))));
        assertTrue(testMap.place(new Animal(testMap, new Vector2d(7, 7))));
        assertTrue(testMap.place(new Animal(testMap)));
        assertThrows(IllegalArgumentException.class, () -> testMap.place(new Animal(testMap)));
        assertTrue(testMap.place(new Animal(testMap, new Vector2d(-1, -3))));
        assertTrue(testMap.place(new Animal(testMap, new Vector2d(-4, 4))));
        assertTrue(testMap.place(new Animal(testMap, new Vector2d(-1, 8))));
        assertTrue(testMap.place(new Animal(testMap, new Vector2d(5, 9))));
    }

    @Test
    void testIsOccupied() {
        GrassField testMap = new GrassField(10);
        testMap.place(new Animal(testMap));
        assertTrue(testMap.isOccupied(new Vector2d(2, 2)));
        assertFalse(testMap.isOccupied(new Vector2d(0, 0)));
        testMap.place(new Animal(testMap, new Vector2d(0, 0)));
        assertTrue(testMap.isOccupied(new Vector2d(0, 0)));
    }

    @Test
    void testObjectAt() {
        GrassField testMap = new GrassField(10);
        Animal testAnimal = new Animal(testMap);
        testMap.place(testAnimal);
        assertEquals(testAnimal, testMap.objectAt(new Vector2d(2, 2)));
        Animal testAnimal2 = new Animal(testMap, new Vector2d(0, 0));
        assertNull(testMap.objectAt(new Vector2d(0, 0)));
        testMap.place(testAnimal2);
        assertEquals(testAnimal2, testMap.objectAt(new Vector2d(0, 0)));
    }
}