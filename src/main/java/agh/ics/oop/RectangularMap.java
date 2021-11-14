package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;
    List<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height) {
        this.width = width - 1;
        this.height = height - 1;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
         return (position.precedes(new Vector2d(this.width, this.height)) && position.follows(new Vector2d(0, 0)) &&
         !isOccupied(position));
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition()) && animal.getPosition().precedes(new Vector2d(this.width, this.height)) &&
                animal.getPosition().follows(new Vector2d(0, 0))) {
            this.animals.add(animal);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
         for (Animal animal: this.animals) {
             if (animal.getPosition().equals(position)) {
                 return true;
             }
         }
         return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal: this.animals) {
            if (animal.getPosition().equals(position)) {
                return animal;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        return visualizer.draw(new Vector2d(0, 0), new Vector2d(this.width, this.height));
    }

}
