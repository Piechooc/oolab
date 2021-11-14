import agh.ics.oop.Animal;
import agh.ics.oop.Vector2d;
import agh.ics.oop.World;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTest {

    @Test
    void testMove() {
        Animal testAnimal = new Animal();

        World.runAnimal(new String[]{"f", "forward", "f", "forward"}, testAnimal);
        assertEquals(new Vector2d(2,4), testAnimal.getPosition());

        Animal testAnimal2 = new Animal();
        World.runAnimal(new String[]{"b", "backward", "b", "backward"}, testAnimal2);
        assertEquals(new Vector2d(2, 0), testAnimal2.getPosition());

        Animal testAnimal3 = new Animal();
        World.runAnimal(new String[]{"r", "f", "forward", "f", "forward"}, testAnimal3);
        assertEquals(new Vector2d(4, 2), testAnimal3.getPosition());

        Animal testAnimal4 = new Animal();
        World.runAnimal(new String[]{"l", "f", "forward", "f", "forward"}, testAnimal4);
        assertEquals(new Vector2d(0, 2), testAnimal4.getPosition());

        Animal testAnimal5 = new Animal();
        World.runAnimal(new String[]{"forward", "r", "f", "right", "forward", "f", "forward", "f"}, testAnimal5);
        assertEquals(new Vector2d(3,0), testAnimal5.getPosition());
    }
}
