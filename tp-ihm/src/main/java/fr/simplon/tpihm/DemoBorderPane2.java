package fr.simplon.tpihm;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Seconde démo des capacités du {@link BorderPane}. Au centre on utilise un conteneur de type {@link VBox}.
 *
 * Voici l'arbre de composition de notre layout :
 *
 * <pre>
 *     BorderPane
 *     \_ top    : Button
 *     \_ left   : Button
 *     \_ center : VBox
 *     |           \_ Button ... (x10)
 *     \_ right  : Button
 *     \_ bottom : Button
 * </pre>
 */
public class DemoBorderPane2 extends Application
{
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {
        // Je commence par changer le titre de la fenêtre
        primaryStage.setTitle("Démo n°2 du composant BorderPane");

        // Ensuite je crée les conteneurs :
        // *     BorderPane
        // *     \_ top    : Button
        // *     \_ left   : Button
        // *     \_ center : VBox
        // *     |           \_ Button ... (x10)
        // *     \_ right  : Button
        // *     \_ bottom : Button
        //
        BorderPane root = new BorderPane();
        VBox vboxCentre = new VBox(5);


        // Maintenant je crée des variables qui contiennent
        // mes composants pour pouvoir réutiliser ces variables
        // quand je modifierai leurs propriétés (MaxSize...etc.)
        //
        Button boutonDuHaut = new Button("Bouton du haut");
        Button boutonDeGauche = new Button("Bouton de gauche");
        Button boutonDeDroite = new Button("Bouton de droite");
        TextField textField = new TextField("Exemple de texte...");

        // Je crée les boutons de la zone centrale dans une boucle
        //
        for (int i = 1; i <= 10; i++)
        {
            // Une variable par bouton pour que ce soit plus clair
            Button button = new Button("Bouton " + i);

            // Je donne une taille max illimitée aux boutons
            button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);

            // Il faut aussi préciser qu'on autorise le BorderPane
            // à redimensionner le bouton en hauteur
            VBox.setVgrow(button, Priority.ALWAYS);

            // On ajoute cette variable comme "enfant" du conteneur "vboxCentre"
            vboxCentre.getChildren().add(button);
        }

        // Maintenant j'assigne mes composants aux zones prévues
        // par le conteneur BorderPane :
        root.setTop(boutonDuHaut);
        root.setCenter(vboxCentre);
        root.setBottom(textField);
        root.setLeft(boutonDeGauche);
        root.setRight(boutonDeDroite);

        // Je veux que le bouton du haut prenne toute la largeur disponible
        // donc je règle sa MaxSize à Double.MAX_VALUE
        // et après j'utilise HBox.setVGrow() pour autoriser son redimensionnement
        boutonDuHaut.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        HBox.setHgrow(boutonDuHaut, Priority.ALWAYS);

        // Idem pour le bouton de gauche sauf qu'on utilise VBox.setVgrow()
        // pour dire qu'on veut permettre au BorderPane de se développer en hauteur
        boutonDeGauche.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        VBox.setVgrow(boutonDeGauche, Priority.ALWAYS);
        HBox.setHgrow(boutonDeGauche, Priority.ALWAYS);

        // Pour le bouton de droite on utilise aussi VBox.setVgrow()
        // pour dire qu'on veut permettre au BorderPane de se développer en hauteur
        boutonDeDroite.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        VBox.setVgrow(boutonDeDroite, Priority.ALWAYS);
        HBox.setHgrow(boutonDeDroite, Priority.ALWAYS);

        // ================================================================
        // ALIGNEMENT et MARGE des boutons
        root.getChildren().forEach(node -> BorderPane.setAlignment(node, Pos.CENTER));
        root.getChildren().forEach(node -> BorderPane.setMargin(node, new Insets(10)));

        // ================================================================
        // Création et affichage de la scène dans le primaryStage
        //
        Scene scene = new Scene(root); // On crée une scène en lui donnant un composant racine
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
