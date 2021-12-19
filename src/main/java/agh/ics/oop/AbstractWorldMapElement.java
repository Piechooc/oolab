package agh.ics.oop;

public abstract class AbstractWorldMapElement implements IMapElement {
    protected Vector2d position;

    @Override
    public Vector2d getPosition() {
        return position;
    }

    @Override
    public abstract String getImage();

    @Override
    public String getLabel() {
        return "";
    }
}
