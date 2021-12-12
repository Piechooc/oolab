package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App extends Application {
    GridPane gridPane = new GridPane();
    Scene scene = new Scene(this.gridPane);

    public void init() {
        try {
            List<MoveDirection> directions = OptionsParser.parse(getParameters().getRaw().toArray(String[]::new));
            AbstractWorldMap map = new GrassField(10);
            List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            show(map);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.exit(-1);
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(this.scene);
        primaryStage.show();
    }

    public void show(AbstractWorldMap map) {
        if (map instanceof GrassField)
            ((GrassField) map).currentCorners();

        Vector2d upperRight = map.getUpperRight();
        Vector2d lowerLeft = map.getLowerLeft();

        int width = upperRight.x - lowerLeft.x + 1;
        int height = upperRight.y - lowerLeft.y + 1;

        for (int x = 0; x <= width; x++) {
            for (int y = 0; y <= height; y++) {
                Label label;
                int trueX = lowerLeft.x + x - 1;
                int trueY = upperRight.y - y + 1;

                if (x == 0 && y == 0) {
                    label = new Label("y/x");
                } else if (x == 0) {
                    label = new Label(Integer.toString(trueY));
                } else if (y == 0) {
                    label = new Label(Integer.toString(trueX));
                } else {
                    Object object = map.objectAt(new Vector2d(trueX, trueY));
                    if (object == null) {
                        label = new Label(" ");
                    } else {
                        label = new Label(object.toString());
                    }
                }

                this.gridPane.add(label, x, y, 1, 1);
                GridPane.setHalignment(label, HPos.CENTER);
            }
        }

        this.gridPane.setGridLinesVisible(true);

        for (int x = 0; x <= width; x++) {
            this.gridPane.getColumnConstraints().add(new ColumnConstraints(20));
        }

        for (int y = 0; y <= height; y++) {
            this.gridPane.getRowConstraints().add(new RowConstraints(20));
        }
    }
}
