package agh.ics.oop;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable {
    private final AbstractWorldMap map;
    private final List<Animal> animals = new ArrayList<>();
    protected List<MoveDirection> directions;
    private final List<IAnimalChangeObserver> observers = new LinkedList<>();

    public SimulationEngine(List<MoveDirection> directions, AbstractWorldMap map, List<Vector2d> positions) {
        this.directions = directions;
        this.map = map;
        for (Vector2d position: positions) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) {
                this.animals.add(animal);
                animal.addObserver(this.map);
            }
        }
    }

    public SimulationEngine(AbstractWorldMap map, List<Vector2d> positions) {
        this.map = map;
        for (Vector2d position: positions) {
            Animal animal = new Animal(map, position);
            if (map.place(animal)) {
                this.animals.add(animal);
                animal.addObserver(this.map);
            }
        }
    }

    @Override
    public void run() {
        System.out.println(this.map);
        for (IAnimalChangeObserver animalMoveObserver : this.observers)
            animalMoveObserver.animalChange();

        int animalsAmount = this.animals.size();
        int len = this.directions.size();
        for (int i = 0; i < len; i++) {
            this.animals.get(i % animalsAmount).move(this.directions.get(i));

            for (IAnimalChangeObserver animalMoveObserver : this.observers)
                animalMoveObserver.animalChange();

            try {
                int moveDelay = 300;
                Thread.sleep(moveDelay);
                System.out.println(this.map);
            } catch (InterruptedException e) {
                System.out.println("Simulation stopped");
            }
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

    public void addAnimalChangeObserver(IAnimalChangeObserver observer) {
        this.observers.add(observer);
    }
}
