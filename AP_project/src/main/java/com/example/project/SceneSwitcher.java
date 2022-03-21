package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {

    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToScene_2_color(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("color_select.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene_1_frontPage(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("firstPage.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene_3_Board(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("board.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene_4_WinnerPage(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("Winner.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


}
