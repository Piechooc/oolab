import agh.ics.oop.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SimulationEngineTest {

    void tester(List<Vector2d> expectedList, List<Vector2d> testList) {

        int expectedLen = expectedList.size();
        int testLen = testList.size();
        assertEquals(expectedLen, testLen);
        if (testLen != expectedLen) {
            return;
        }

        for (int i = 0; i < expectedLen; i++) {
            assertEquals(expectedList.get(i), testList.get(i));
        }
    }

    @Test
    void testRun() {
        List<MoveDirection> testDirections = OptionsParser.parse(new String[] {"f", "b", "r", "l", "f", "f", "r", "r",
                "f", "f", "f", "f", "f", "f", "f", "f"});
        IWorldMap testMap = new RectangularMap(10, 5);
        List<Vector2d> testPositions = new ArrayList<>(Arrays.asList(new Vector2d(2,2), new Vector2d(3,4)));
        SimulationEngine testEngine = new SimulationEngine(testDirections, testMap, testPositions);
        testEngine.run();
        List<Vector2d> expectedResult = new ArrayList<>(Arrays.asList(new Vector2d(2, 0),
                new Vector2d(3, 4)));
        tester(expectedResult, testEngine.getFinalPositions());


        List<MoveDirection> testDirections2 = OptionsParser.parse(new String[] {"f", "f", "f", "f", "f", "l",
                "b", "b", "f"});
        IWorldMap testMap2 = new RectangularMap(3, 3);
        List<Vector2d> testPositions2 = new ArrayList<>(Arrays.asList(new Vector2d(0,2), new Vector2d(1,1),
                new Vector2d(2,0)));
        SimulationEngine testEngine2 = new SimulationEngine(testDirections2, testMap2, testPositions2);
        testEngine2.run();
        List<Vector2d> expectedResult2 = new ArrayList<>(Arrays.asList(new Vector2d(0, 1),
                new Vector2d(1, 1), new Vector2d(2, 1)));
        tester(expectedResult2, testEngine2.getFinalPositions());


        List<MoveDirection> testDirections3 = OptionsParser.parse(new String[] {"r", "r", "l", "f", "f", "f", "f"});
        IWorldMap testMap3 = new RectangularMap(4, 4);
        List<Vector2d> testPositions3 = new ArrayList<>(Arrays.asList(new Vector2d(0,2), new Vector2d(1,0),
                new Vector2d(3,3)));
        SimulationEngine testEngine3 = new SimulationEngine(testDirections3, testMap3, testPositions3);
        testEngine3.run();
        List<Vector2d> expectedResult3 = new ArrayList<>(Arrays.asList(new Vector2d(2, 2),
                new Vector2d(2, 0), new Vector2d(2, 3)));
        tester(expectedResult3, testEngine3.getFinalPositions());
    }
}
