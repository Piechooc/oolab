package agh.ics.oop;

public class GrassField extends AbstractWorldMap implements IWorldMap {
    private final MapBoundary mapBoundary = new MapBoundary();
    private final double range;

    public GrassField(int grassTuftsNumber) {
        this.range = Math.sqrt(grassTuftsNumber * 10);

        int counter = 0;
        while (counter < grassTuftsNumber) {
            Vector2d potentialPosition = new Vector2d((int) (Math.random() * range),
                    (int) (Math.random() * range));
            Object temp = objectAt(potentialPosition);
            if (temp == null) {
                elements.put(potentialPosition, new Grass(potentialPosition));
                this.mapBoundary.addElement(potentialPosition);
                counter++;
            }
        }
    }

    @Override
    public String toString() {
        this.upperRight = this.mapBoundary.getUpperRight();
        this.lowerLeft = this.mapBoundary.getLowerLeft();

        return super.toString();
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object object = objectAt(position);
        if (object instanceof Grass) {
            elements.remove(((Grass) object).position, object);
            mapBoundary.removeElement(position);
            Vector2d potentialPosition = new Vector2d((int) (Math.random() * this.range),
                    (int) (Math.random() * this.range));
            Object temp = objectAt(potentialPosition);
            if (temp == null) {
                elements.put(potentialPosition, new Grass(potentialPosition));
                this.mapBoundary.addElement(potentialPosition);
            }
        }
        return super.canMoveTo(position);
    }

    @Override
    public boolean place(Animal animal) {
        super.place(animal);
        this.mapBoundary.addElement(animal.getPosition());
        return true;
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractWorldMapElement mapElement = elements.get(oldPosition);
        if (mapElement instanceof Animal) {
            elements.put(newPosition, mapElement);
            elements.remove(oldPosition);
            this.mapBoundary.positionChanged(oldPosition, newPosition);
        }
    }

    public void currentCorners() {
        this.upperRight = this.mapBoundary.getUpperRight();
        this.lowerLeft = this.mapBoundary.getLowerLeft();
    }
}
