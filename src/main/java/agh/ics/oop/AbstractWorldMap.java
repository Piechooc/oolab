package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected List<AbstractWorldMapElement> elements = new ArrayList<>();
    protected Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    protected MapVisualizer mapVisualizer = new MapVisualizer(this);

    @Override
    public boolean canMoveTo(Vector2d position) {
        return (!(objectAt(position) instanceof Animal));
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())) {
            this.elements.add(animal);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (AbstractWorldMapElement element : this.elements) {
            if (element.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object temp = null;
        for (AbstractWorldMapElement element : this.elements) {
            if (element.getPosition().equals(position)) {
                if (element instanceof Animal) {
                    return element;
                } else {
                    temp = element;
                }
            }
        }
        return temp;
    }

    @Override
    public String toString() {
        return this.mapVisualizer.draw(this.lowerLeft, this.upperRight);
    }
}