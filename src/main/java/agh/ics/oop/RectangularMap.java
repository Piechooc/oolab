package agh.ics.oop;

public class RectangularMap extends AbstractWorldMap implements IWorldMap {

    public RectangularMap(int width, int height) {
        this.upperRight = new Vector2d(width - 1, height - 1);
        this.lowerLeft = new Vector2d(0, 0);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
         return (position.precedes(this.upperRight) && position.follows(this.lowerLeft) &&
         !isOccupied(position));
    }
}
