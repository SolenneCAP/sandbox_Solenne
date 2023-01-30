package fr.simplon.tpihm;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Démo du composant VBox.
 */
public class DemoVBox extends Application
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

        // Plusieurs méthodes possibles pour aligner les boutons au centre
        //
        // Méthode 1 : aligner manuellement chaque composant top/left/center...
        BorderPane.setAlignment(root.getTop(), Pos.CENTER);
        BorderPane.setAlignment(root.getCenter(), Pos.CENTER);
        BorderPane.setAlignment(root.getLeft(), Pos.CENTER);
        BorderPane.setAlignment(root.getRight(), Pos.CENTER);
        BorderPane.setAlignment(root.getBottom(), Pos.CENTER);

        // Méthode 2 : une boucle "for" sur les "enfants" du conteneur
        //        for (int i = 0; i < root.getChildren().size(); i++)
        //        {
        //            Node node = root.getChildren().get(i);
        //            BorderPane.setAlignment(node, Pos.CENTER);
        //        }
        //
        // Méthode 3 : une boucle "foreach"
        //        for (Node node : root.getChildren())
        //        {
        //            BorderPane.setAlignment(node, Pos.CENTER);
        //        }
        //
        // Méthode 4 : la façon la plus élégante (stream + lambda)
        // root.getChildren().forEach(node -> BorderPane.setAlignment(node, Pos.CENTER));

        // Pour espacer vos composants utilisez BorderPane.setMargin()
        BorderPane.setMargin(root.getCenter(), new Insets(10));

        // -------------------------------------------------------------------
        // Cette partie doit toujours se situer à la fin de la méthode start()
        // car théoriquement tous vos composants doivent avoir été ajoutés à
        // votre Scene avant d'afficher le Stage.
        primaryStage.setTitle("Démo du composant BorderPane");
        primaryStage.setScene(new Scene(root)); // on supprime les paramètres
        primaryStage.setHeight(200);
        primaryStage.show();
    }
}
