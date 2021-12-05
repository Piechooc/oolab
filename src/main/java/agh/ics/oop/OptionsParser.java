package agh.ics.oop;

import java.util.ArrayList;

public class OptionsParser {

    public static ArrayList<MoveDirection> parse(String[] arg) throws IllegalArgumentException {
        ArrayList<MoveDirection> l = new ArrayList<>();

        for (String el : arg) {
            switch (el) {
                case "f", "forward" -> l.add(MoveDirection.FORWARD);
                case "b", "backward" -> l.add(MoveDirection.BACKWARD);
                case "r", "right" -> l.add(MoveDirection.RIGHT);
                case "l", "left" -> l.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(el + " is not legal move specification");
            }
        }

        return l;
    }

}
