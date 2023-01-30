package fr.simplon.tpihm;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Présentation des capacités du {@link BorderPane}.
 * <pre>
 *     BorderPane
 *     \_ top    : javafx.scene.control.Button
 *     \_ left   : javafx.scene.control.Button
 *     \_ center : javafx.scene.control.Button
 *     \_ right  : javafx.scene.control.Button
 *     \_ bottom : javafx.scene.control.Button
 * </pre>
 */
public class DemoBorderPane extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        BorderPane root = new BorderPane();
        root.setTop(new Button("Bouton du haut"));
        root.setCenter(new Button("Bouton du centre"));
        root.setBottom(new Button("Bouton du bas"));
        root.setLeft(new Button("Bouton de gauche"));
        root.setRight(new Button("Bouton de droite"));

        BorderPane.setMargin(root.getCenter(), new Insets(50));

        // Plusieurs méthodes possibles pour aligner les boutons au centre
        // ------------------------------------------------------------------------
        // Méthode 1 : une boucle "for" traditionnelle
        for (int i = 0; i < root.getChildren().size(); i++)
        {
            Node node = root.getChildren().get(i);
            BorderPane.setAlignment(node, Pos.CENTER);
        }
        // ------------------------------------------------------------------------
        // Méthode 2 : une boucle "foreach"
        for (Node node : root.getChildren())
        {
            BorderPane.setAlignment(node, Pos.CENTER);
        }
        // ------------------------------------------------------------------------
        // Méthode 3 : la façon la plus rapide (possible à partir de Java 8 : stream + lambda)
        root.getChildren().forEach(node -> BorderPane.setAlignment(node, Pos.CENTER));
        // ------------------------------------------------------------------------

        primaryStage.setTitle("Démo du composant BorderPane");
        primaryStage.setScene(new Scene(root)); // on supprime les paramètres
        primaryStage.setHeight(200);
        primaryStage.show();
    }
}
