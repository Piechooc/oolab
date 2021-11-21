package agh.ics.oop;

public class GrassField extends AbstractWorldMap implements IWorldMap {

    public GrassField(int grassTuftsNumber) {
        double range = Math.sqrt(grassTuftsNumber * 10);

        int counter = 0;
        while (counter < grassTuftsNumber) {
            Vector2d potentialPosition = new Vector2d((int) (Math.random() * range),
                    (int) (Math.random() * range));
            Object temp = objectAt(potentialPosition);
            if (temp == null) {
                elements.add(new Grass(potentialPosition));
                counter++;
            }
        }
    }

    @Override
    public String toString() {
        for (AbstractWorldMapElement element : elements) {
            this.upperRight = this.upperRight.upperRight(element.getPosition());
            this.lowerLeft = this.lowerLeft.lowerLeft(element.getPosition());
        }
        return super.toString();
    }
}
