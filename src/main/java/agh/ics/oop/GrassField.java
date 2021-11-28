package agh.ics.oop;

import java.util.Set;

public class GrassField extends AbstractWorldMap implements IWorldMap {

    public GrassField(int grassTuftsNumber) {
        double range = Math.sqrt(grassTuftsNumber * 10);

        int counter = 0;
        while (counter < grassTuftsNumber) {
            Vector2d potentialPosition = new Vector2d((int) (Math.random() * range),
                    (int) (Math.random() * range));
            Object temp = objectAt(potentialPosition);
            if (temp == null) {
                elements.put(potentialPosition, new Grass(potentialPosition));
                counter++;
            }
        }
    }

    @Override
    public String toString() {
        Set<Vector2d> keySet = elements.keySet();
        for (Vector2d position : keySet) {
            this.upperRight = this.upperRight.upperRight(position);
            this.lowerLeft = this.lowerLeft.lowerLeft(position);
        }
        return super.toString();
    }
}
