package br.univali.condominio.screen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import javafx.stage.Stage;

import java.io.IOException;

public class Start extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Pane root  = FXMLLoader.load(getClass().getResource("Screens/screen.fxml"));
        Scene scene = new Scene(root, 750,525);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sol Nascente");
        primaryStage.show();
    }
}