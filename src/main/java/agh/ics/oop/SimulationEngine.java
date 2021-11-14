package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private final IWorldMap map;
    private final List<Animal> animals = new ArrayList<>();
    private final List<MoveDirection> directions;

    public SimulationEngine(List<MoveDirection> directions, IWorldMap map, List<Vector2d> positions) {
        this.directions = directions;
        this.map = map;
        for (Vector2d position: positions) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) {
                this.animals.add(animal);
            }
        }
    }


    @Override
    public void run() {
        System.out.println(this.map);
        int animalsAmount = this.animals.size();
        int len = this.directions.size();
        for (int i = 0; i < len; i++) {
            this.animals.get(i % animalsAmount).move(this.directions.get(i));
            System.out.println(this.map);
        }

        System.out.println("Done");
    }

//    for testing
    public List<Vector2d> getFinalPositions() {
        List<Vector2d> finalPositions = new ArrayList<>();
        for (Animal animal: this.animals) {
            finalPositions.add(animal.getPosition());
        }

        return finalPositions;
    }
}
