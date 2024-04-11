package fr.amu.iut.exercice1;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FenetreLogiciel extends Application {

    @Override
    public void start(Stage primaryStage) {

        //conteneur principal
        BorderPane tout = new BorderPane();

        //conteneur ligne haut
        Menu menu1 = new Menu("File");
        Menu menu2 = new Menu("Edit");
        Menu menu3 = new Menu("Help");
        Menu menu4 = new Menu("New");
        Menu menu5 = new Menu("Open");
        Menu menu6 = new Menu("Save");
        Menu menu7 = new Menu("Close");
        Menu menu8 = new Menu("Cut");
        Menu menu9 = new Menu("Copy");
        Menu menu10 = new Menu("Paste");
        menu1.getItems().add(menu4);
        menu1.getItems().add(menu5);
        menu1.getItems().add(menu6);
        menu1.getItems().add(menu7);
        menu2.getItems().add(menu8);
        menu2.getItems().add(menu9);
        menu2.getItems().add(menu10);

        MenuBar menuBar = new MenuBar(menu1, menu2, menu3);
        tout.setTop( menuBar);
        //tableau
        GridPane gp = new GridPane();
        RowConstraints row0 = new RowConstraints();
        RowConstraints row1 = new RowConstraints();
        gp.getRowConstraints().addAll(row0 , row1);
        ColumnConstraints col0 = new ColumnConstraints();
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        gp.getColumnConstraints().addAll(col0 , col1,col2);
        Text txt = new Text("text");
        Text txt1 = new Text("t25ext");
        Text txt2 = new Text("t25e0xt");
        Text txt3 = new Text("t25e8xt");
        Text txt4 = new Text("t25e5xt");
        Text txt5 = new Text("t25e4xt");
        gp.add(txt, 0, 0);
        gp.add(txt1, 1, 0);
        gp.add(txt2, 2, 0);
        gp.add(txt3, 0, 1);
        gp.add(txt4, 1, 1);
        gp.add(txt5 , 2, 1);

        tout.setCenter(gp);
        //gauche
        Button btn1 = new Button("bouton1");
        Button btn2 = new Button("bouton2");
        Button btn3 = new Button("bouton3");
        Label lab1 = new Label("boutons :");

        VBox gauche = new VBox(lab1 , btn1, btn2,btn3);
        gauche.setSpacing(10);
        gauche.setAlignment(Pos.CENTER);
        Separator separator1 = new Separator(Orientation.VERTICAL);
        HBox gauche1 = new HBox(gauche, separator1);
        tout.setLeft(gauche1);

        // bandeau en bas de la fenêtre
        Label lab = new Label("Ceci est un bas de page");

        //bas.setAlignment(Pos.CENTER);
        Separator separator2 = new Separator(Orientation.HORIZONTAL);
        VBox bas = new VBox();
        bas.getChildren().addAll(separator2,lab);
        bas.setAlignment(Pos.CENTER);
        tout.setBottom(bas);

        Scene scene1 = new Scene(tout);

        //Ajout de la scene à la fenêtre
        primaryStage.setScene(scene1);
        primaryStage.setWidth( 800 );
        primaryStage.setHeight( 600 );
        primaryStage.setTitle("Premier exemple manipulant les conteneurs");

        //Affichage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);

    }
}

