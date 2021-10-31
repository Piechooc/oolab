package agh.ics.oop;

import java.util.ArrayList;

import static agh.ics.oop.Direction.*;

public class World {
    public static void main(String[] args) {

        Animal Doge = new Animal();
        System.out.println(Doge);

//        Doge.move(MoveDirection.RIGHT);
//        Doge.move(MoveDirection.FORWARD);
//        Doge.move(MoveDirection.FORWARD);
//        Doge.move(MoveDirection.FORWARD);
//        System.out.println(Doge);

        runAnimal(args, Doge);
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