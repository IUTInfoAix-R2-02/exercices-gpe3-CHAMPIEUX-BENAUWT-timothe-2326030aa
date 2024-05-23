package fr.amu.iut.exercice6;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class IHMPendu extends Application {
    private int NbVie;
    private Scene scene;
    private BorderPane root;
    String lettre;
    @Override
    public void start(Stage primaryStage) throws Exception {

        root = new BorderPane();
        Scene scene = new Scene( root );
        Pane jeu = new Pane();
        NbVie = 7;
        Dico dico = new Dico();

        //Choix du mot
        Label mot = new Label(dico.getMot());
        //Cryptage du mot
        String motcacher = new String();
        for(int i=0 ; i<mot.getText().length();i++){
            motcacher+= "*";
        }
        Label mot1 = new Label(motcacher);
        HBox motsecret = new HBox(mot1);
        motsecret.setAlignment(Pos.CENTER);

        //Textfield
        TextField zonetext = new TextField();
        HBox text = new HBox(zonetext);
        text.setAlignment(Pos.CENTER);

        lettre = "";
        //recuperation du text field
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch (event.getCode()) {
                case ENTER -> {
                    String lettre1 = zonetext.getText();
                    zonetext.clear();
                    lettre = lettre1;
                    System.out.println(lettre);
//                    dico.getPositions(lettre, motcacher);
                }
            }
        });

        //detection de la lettre entrée


        //Label
        Label lab = new Label("Nombre de vie : " + NbVie);
        HBox lablab = new HBox(lab);
        lablab.setAlignment(Pos.CENTER);

        VBox centre = new VBox(motsecret,lablab,text);
        centre.setAlignment(Pos.CENTER);
        root.setCenter(centre);

        primaryStage.setTitle("Jeu du pendu");
        primaryStage.setWidth(500);
        primaryStage.setHeight(550);

        // A completer


        primaryStage.setScene( scene );

        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
