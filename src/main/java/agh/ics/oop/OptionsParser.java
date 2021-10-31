package agh.ics.oop;

import java.util.ArrayList;

public class OptionsParser {

    public static ArrayList<MoveDirection> parse(String[] arg) {
        ArrayList<MoveDirection> l = new ArrayList<>();

        for (String el : arg) {
            switch (el) {
                case "f", "forward" -> l.add(MoveDirection.FORWARD);
                case "b", "backward" -> l.add(MoveDirection.BACKWARD);
                case "r", "right" -> l.add(MoveDirection.RIGHT);
                case "l", "left" -> l.add(MoveDirection.LEFT);
            }
        }

        return l;
    }

}
