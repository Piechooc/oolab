package agh.ics.oop.gui;

import agh.ics.oop.AbstractWorldMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox {
    private final AbstractWorldMapElement worldMapElement;

    public  GuiElementBox(AbstractWorldMapElement worldMapElement) {
        this.worldMapElement = worldMapElement;
    }

    public VBox getVBox(){
        if(this.worldMapElement == null) {
            return new VBox();
        }

        Image image = null;
        try {
            image = new Image(new FileInputStream(this.worldMapElement.getImage()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(50);
        imageView.setFitHeight(50);
        Label label = new Label(this.worldMapElement.getLabel());

        VBox vBox = new VBox(imageView, label);
        vBox.setAlignment(Pos.CENTER);

        return vBox;
    }
}
