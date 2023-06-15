package com.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("view/Acceuil.fxml"));
        primaryStage.setTitle("Gestion Employée");
        primaryStage.setScene(new Scene(root,1200,800));
        primaryStage.show();
    }

    public static void main(String[] args) {
        if(args.length >0)
            for(String arg : args) System.out.println(arg);
        launch(args);
    }

}