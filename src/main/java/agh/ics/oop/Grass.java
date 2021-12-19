package agh.ics.oop;

public class Grass extends AbstractWorldMapElement implements IMapElement{
    public Grass(Vector2d position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "*";
    }

    @Override
    public String getImage() {
        return "src/main/resources/Grass.png";
    }

    @Override
    public String getLabel() {
        return "Grass";
    }
}
