package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App extends Application implements IAnimalChangeObserver {
    private final GridPane gridPane = new GridPane();
    private AbstractWorldMap map;
    private ThreadedSimulationEngine threadedEngine;


    public void init() {
        try {
            this.map = new GrassField(10);
            List<Vector2d> positions = new ArrayList<>(Arrays.asList(new Vector2d(2, 2), new Vector2d(3, 4)));
            this.threadedEngine = new ThreadedSimulationEngine(this.map, positions);
            this.threadedEngine.addAnimalChangeObserver(this);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            System.exit(-1);
        }
    }

    public HBox createHBoxInterface() {
        TextField directionInput = new TextField();
        Button startButton = new Button("Start");
        HBox hBoxInterface = new HBox(directionInput, startButton);

        startButton.setOnAction(click -> {
            List<MoveDirection> directions = OptionsParser.parse(directionInput.getText().split(" "));
            this.threadedEngine.setDirections(directions);
            Thread engineThread  = new Thread(this.threadedEngine);
            engineThread .start();
        });

        return hBoxInterface;
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hBoxInterface = createHBoxInterface();

        show();

        VBox vBoxInterface = new VBox(hBoxInterface, this.gridPane);
        vBoxInterface.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(vBoxInterface));
        primaryStage.show();
    }

    public void show() {
        if (this.map instanceof GrassField)
            ((GrassField) this.map).currentCorners();

        Vector2d upperRight = this.map.getUpperRight();
        Vector2d lowerLeft = this.map.getLowerLeft();

        int width = upperRight.x - lowerLeft.x + 1;
        int height = upperRight.y - lowerLeft.y + 1;

        this.gridPane.setGridLinesVisible(false);
        this.gridPane.setGridLinesVisible(true);
        this.gridPane.getRowConstraints().clear();
        this.gridPane.getColumnConstraints().clear();

        for (int x = 0; x <= width; x++) {
            for (int y = 0; y <= height; y++) {
                Label label;
                int trueX = lowerLeft.x + x - 1;
                int trueY = upperRight.y - y + 1;

                if (x == 0 && y == 0) {
                    label = new Label("y/x");
                    this.gridPane.add(label, x, y, 1, 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                } else if (x == 0) {
                    label = new Label(Integer.toString(trueY));
                    this.gridPane.add(label, x, y, 1, 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                } else if (y == 0) {
                    label = new Label(Integer.toString(trueX));
                    this.gridPane.add(label, x, y, 1, 1);
                    GridPane.setHalignment(label, HPos.CENTER);
                } else {
                    GuiElementBox guiElementBox = new GuiElementBox(this.map.objectAt(new Vector2d(trueX, trueY)));
                    VBox vBox = guiElementBox.getVBox();
                    this.gridPane.add(vBox, x, y, 1, 1);
                    GridPane.setHalignment(vBox, HPos.CENTER);
                    GridPane.setValignment(vBox, VPos.CENTER);
                }
            }
        }

        for (int x = 0; x <= width; x++) {
            this.gridPane.getColumnConstraints().add(new ColumnConstraints(70));
        }

        for (int y = 0; y <= height; y++) {
            this.gridPane.getRowConstraints().add(new RowConstraints(70));
        }
    }

    @Override
    public void animalChange() {
        Platform.runLater(() -> {
            this.gridPane.getChildren().clear();
            show();
        });
    }
}
