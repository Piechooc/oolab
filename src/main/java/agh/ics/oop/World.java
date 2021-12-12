package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

public class World {
    public static void main(String[] args) {
        Application.launch(App.class, args);
    }

    public static void runAnimal(String[] args, Animal animal) {
        for (MoveDirection direction : OptionsParser.parse(args)) {
            animal.move(direction);
            System.out.println(direction + " -> " + animal.toString());
        }
    }
}