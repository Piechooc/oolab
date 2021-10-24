package agh.ics.oop;

import java.util.ArrayList;

import static agh.ics.oop.Direction.*;

public class World {
    public static void main(String[] args) {
//        System.out.println("Start");
//        ArrayList<Direction> newArgs = convert(args);
//        run(newArgs);
//        System.out.println("Stop");

        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        System.out.println(MapDirection.NORTH);
        System.out.println(MapDirection.NORTH.next());
        System.out.println(MapDirection.NORTH.previous());
        System.out.println(MapDirection.NORTH.toUnitVector());
    }

    public static void run(ArrayList<Direction> arg) {
//        System.out.println("Animal goes forward");
//        for (int i = 0; i < arg.length; i++) {
//            if (i != arg.length - 1) {
//                System.out.print(arg[i]);
//                System.out.print(", ");
//            } else {
//                System.out.println(arg[i]);
//            }
//        }

//        for(String el : arg) {
//            String res = switch(el) {
//                case "f" -> "Zwierzak idzie do przodu";
//                case "b" -> "Zwierzak idzie do tyłu";
//                case "r" -> "Zwierzak skręca w prawo";
//                case "l" -> "Zwierzak skręca w lewo";
//                default -> "-1";
//            };
//
//            System.out.println(res);
//        }

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