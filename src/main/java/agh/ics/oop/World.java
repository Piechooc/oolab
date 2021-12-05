package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static agh.ics.oop.Direction.*;

public class World {
    public static void main(String[] args) {
        try {
            List<MoveDirection> directions = OptionsParser.parse(args);
            AbstractWorldMap map = new GrassField(10);
            List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.exit(-1);
        }
    }

    public static void runAnimal(String[] args, Animal animal) {
        for (MoveDirection direction : OptionsParser.parse(args)) {
            animal.move(direction);
            System.out.println(direction + " -> " + animal.toString());
        }
    }

    public static void run(ArrayList<Direction> arg) {

        for (Direction el : arg) {
            String res = switch (el) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARDS -> "Zwierzak idzie do tyłu";
                case RIGHT -> "Zwierzak skręca w prawo";
                case LEFT -> "Zwierzak skręca w lewo";
            };

            System.out.println(res);
        }
    }

    public static ArrayList<Direction> convert(String[] arg) {
        ArrayList<Direction> l = new ArrayList<>();

        for (String el : arg) {
            switch (el) {
                case "f" -> l.add(FORWARD);
                case "b" -> l.add(BACKWARDS);
                case "r" -> l.add(RIGHT);
                case "l" -> l.add(LEFT);
            }
        }

        return l;
    }
}