package fr.simplon.tpihm;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Présentation des capacités du {@link HBox}.
 * <pre>
 *     HBox
 *     \_ javafx.scene.control.Button
 *     \_ javafx.scene.control.Button
 *     \_ ...(x10)
 * </pre>
 */
public class DemoHBox extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        Color[] colors = {
                Color.BLACK,
                Color.RED,
                Color.YELLOW,
                Color.BLUE,
                Color.GREEN,
                Color.ORANGE,
                Color.BROWN,
                Color.BLUEVIOLET,
                Color.WHITE
        };

        HBox root = new HBox(10);
        for (int i = 0; i < colors.length; i++)
        {
            Button button = new Button("Bouton " + i);
            button.setId("button"+(i+1));
            button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            root.getChildren().add(button);
            HBox.setHgrow(button, Priority.ALWAYS);
        }

        primaryStage.setTitle("Démo du composant HBox");
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("DemoHBox.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setHeight(200);
        primaryStage.show();
    }
}
