package fr.simplon.resistron;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * <h1>Resistron</h1>
 * <p>
 * <img src=screenshot.png width=320 height=200" />
 * </p>
 * <p>
 * This application is a Desktop application intended to compute an electronic resistor value
 * with color buttons associated to each ring.
 * </p>
 */
public class ResistronApplication extends Application {

    /**
     * JavaFX start method.
     *
     * @param stage Primary Stage used to layout all components.
     * @throws IOException In case of any problem with the frame initialization.
     */
    @Override
    public void start(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(ResistronApplication.class.getResource("resistron.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Résiste !");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Run the app.
     *
     * Usage :
     * <pre>
     * $> java -classpath "javafx-controls-18.0.2.jar;javafx-graphics-18.0.2.jar;javafx-base-18.0.2.jar;javafx-fxml-18.0.2.jar" -p "D:\Java\resistron\target\classes;javafx-controls-18.0.2-win.jar;javafx-base-18.0.2-win.jar;javafx-graphics-18.0.2-win.jar;javafx-fxml-18.0.2-win.jar" -m fr.simplon.resistron/fr.simplon.resistron.ResistronApplication
     * </pre>
     *
     * @param args No arguments required.
     */
    public static void main(String[] args)
    {
        launch();
    }
}