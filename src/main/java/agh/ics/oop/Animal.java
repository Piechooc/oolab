package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    @Override
    public String toString() {
        return "Position: " + position + " Orientation: " + orientation;
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> orientation = orientation.next();
            case LEFT -> orientation = orientation.previous();
            case FORWARD -> {
                if (position.add(orientation.toUnitVector()).precedes(new Vector2d(4, 4))
                        && position.add(orientation.toUnitVector()).follows(new Vector2d(0, 0))) {
                    position = position.add(orientation.toUnitVector());
                }
            }
            case BACKWARD -> {
                if (position.subtract(orientation.toUnitVector()).precedes(new Vector2d(4, 4))
                        && position.subtract(orientation.toUnitVector()).follows(new Vector2d(0, 0))) {
                    position = position.subtract(orientation.toUnitVector());
                }
            }
        }
    }
}
