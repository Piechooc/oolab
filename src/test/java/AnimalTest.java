import agh.ics.oop.Animal;
import agh.ics.oop.World;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AnimalTest {

    @Test
    void testMove() {
        Animal testAnimal = new Animal();

        World.runAnimal(new String[]{"f", "forward", "f", "forward"}, testAnimal);
        assertEquals("Position: (2,4) Orientation: Północ", testAnimal.toString());

        Animal testAnimal2 = new Animal();
        World.runAnimal(new String[]{"b", "backward", "b", "backward"}, testAnimal2);
        assertEquals("Position: (2,0) Orientation: Północ", testAnimal2.toString());

        Animal testAnimal3 = new Animal();
        World.runAnimal(new String[]{"r", "f", "forward", "f", "forward"}, testAnimal3);
        assertEquals("Position: (4,2) Orientation: Wschód", testAnimal3.toString());

        Animal testAnimal4 = new Animal();
        World.runAnimal(new String[]{"l", "f", "forward", "f", "forward"}, testAnimal4);
        assertEquals("Position: (0,2) Orientation: Zachód", testAnimal4.toString());

        Animal testAnimal5 = new Animal();
        World.runAnimal(new String[]{"forward", "r", "f", "right", "forward", "f", "forward", "f"}, testAnimal5);
        assertEquals("Position: (3,0) Orientation: Południe", testAnimal5.toString());
    }
}
