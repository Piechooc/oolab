package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal extends AbstractWorldMapElement implements IMapElement{
    private MapDirection orientation = MapDirection.NORTH;
    private final IWorldMap map;
    private final List<IPositionChangeObserver> observersList = new ArrayList<>();

    public Animal(IWorldMap map) {
        this.map = map;
        this.position = new Vector2d(2, 2);
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
    }

    public Animal() {
        this.position = new Vector2d(2, 2);
        this.map = new RectangularMap(5, 5);
    }

    @Override
    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "^";
            case SOUTH -> "v";
            case WEST -> "<";
            case EAST -> ">";
        };
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> {
                if (map.canMoveTo(this.position.add(this.orientation.toUnitVector()))) {
                    positionChanged(this.position, this.position.add(this.orientation.toUnitVector()));
                    this.position = this.position.add(this.orientation.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (map.canMoveTo(this.position.subtract(this.orientation.toUnitVector()))) {
                    positionChanged(this.position, this.position.subtract(this.orientation.toUnitVector()));
                    this.position = this.position.subtract(this.orientation.toUnitVector());
                }
            }
        }
    }

    public void addObserver(IPositionChangeObserver observer) {
        this.observersList.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer) {
        this.observersList.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        for (IPositionChangeObserver observer : this.observersList)
            observer.positionChanged(oldPosition, newPosition);
    }
}
