package com.example.project;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.Effect;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Random;

import javafx.scene.paint.Color;

public class HelloApplication extends Application {
    private static  Player p1;
    public static Player getP1() {
        return p1;
    }
    public static void setP1(Player p1) {
        HelloApplication.p1 = p1;
    }

    private static Player p2;
    public static Player getP2() {
        return p2;
    }
    public static void setP2(Player p2) {
        HelloApplication.p2 = p2;
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        Scene scene = new Scene(root,Color.BLACK);
        stage.setTitle("Snakes & Ladders");
        Image icon = new Image("icon.png");
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
            exitButtonPressed(stage);
        });

        Random r = new Random();
        int x = r.nextInt(6) + 1;
        System.out.println(x);
    }

    public void exitButtonPressed(Stage stage){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exited");
        alert.setHeaderText("You pressed exit");
        alert.setContentText("Are you sure you want to exit");

        if(alert.showAndWait().get() == ButtonType.OK){
            System.out.println("exited successfully!");
            stage.close();
        }
    }


    public static void main(String[] args) {
        launch();
    }
}