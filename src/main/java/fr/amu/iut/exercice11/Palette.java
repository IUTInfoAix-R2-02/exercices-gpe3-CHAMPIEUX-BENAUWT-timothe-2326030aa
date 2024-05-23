package fr.amu.iut.exercice11;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

@SuppressWarnings("Duplicates")
public class Palette extends Application {

    private int nbVert = 0;
    private int nbRouge = 0;
    private int nbBleu = 0;

    private Label texteDuHaut;

    private Button vert;
    private Button rouge;
    private Button bleu;

    private BorderPane root;
    private Pane panneau;
    private HBox boutons;

    private Label texteDuBas;

    private SimpleIntegerProperty nbFois;
    private SimpleStringProperty message;
    private SimpleStringProperty couleurPanneau;
    public Palette() {
        nbFois = new SimpleIntegerProperty(0);
        message = new SimpleStringProperty("");
        couleurPanneau = new SimpleStringProperty("#000000");
    }

    private void createBindings(){

        panneau.styleProperty().bind(Bindings.concat( "-fx-background-color: ",couleurPanneau));
        BooleanProperty pasEncoreDeClic = new SimpleBooleanProperty() ;
        pasEncoreDeClic.bind(Bindings.equal(nbFois,0));
        texteDuHaut.textProperty().bind(Bindings.when(pasEncoreDeClic).then("cliquez !").otherwise(Bindings.concat(message," choisi ",nbFois," fois")));
        texteDuBas.textProperty().bind(Bindings.concat("Le ",message," est une jolie couleur !"));
        texteDuBas.styleProperty().bind(Bindings.concat("-fx-text-fill: ",couleurPanneau));
    }

    @Override

    public void start(Stage primaryStage) {
        root = new BorderPane();

        // Initialisation de la propriété nbFois



        texteDuHaut = new Label();
        texteDuHaut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        BorderPane.setAlignment(texteDuHaut, Pos.CENTER);

        panneau = new Pane();
        panneau.setPrefSize(400, 200);

        VBox bas = new VBox();
        boutons = new HBox(10);
        boutons.setAlignment(Pos.CENTER);
        boutons.setPadding(new Insets(10, 5, 10, 5));
        texteDuBas = new Label();
        bas.setAlignment(Pos.CENTER_RIGHT);
        bas.getChildren().addAll(boutons, texteDuBas);

        vert = new Button("Vert");
        rouge = new Button("Rouge");
        bleu = new Button("Bleu");


//        bouton.setOnAction(event -> {
//            nbFois.set(nbFois.get() + 1);
//        });

        /* VOTRE CODE ICI */
        bleu.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbBleu+=1;
            nbFois.setValue(nbBleu);
            message.setValue("bleu");
            couleurPanneau.setValue("#26c4ec");

        });
        rouge.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbRouge+=1;
            nbFois.setValue(nbRouge);
            message.setValue("Rouge");
            couleurPanneau.setValue("#ed0000");

        });

        vert.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            nbVert+=1;
            nbFois.setValue(nbVert);
            message.setValue("Vert");
            couleurPanneau.setValue("#00ff00");

        });


        createBindings();

        boutons.getChildren().addAll(vert, rouge, bleu);

        root.setCenter(panneau);
        root.setTop(texteDuHaut);
        root.setBottom(bas);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

