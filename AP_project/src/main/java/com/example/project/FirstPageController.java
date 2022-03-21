package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FirstPageController {

    @FXML
    private AnchorPane scenepane;

    @FXML
    private ImageView snakeLogo;

    @FXML
    private Button playbutton;

    @FXML
    private  Button exit_button;

    private Stage stage;

    public  void exitButtonPressed(ActionEvent event){

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exited");
        alert.setHeaderText("You pressed exit");
        alert.setContentText("Are you sure you want to exit");

        if(alert.showAndWait().get() == ButtonType.OK){
            stage = (Stage) scenepane.getScene().getWindow();
            System.out.println("exited successfully!");
            stage.close();
        }
    }

    public void PlayButtonPressed(ActionEvent event){
        SceneSwitcher sc = new SceneSwitcher();
        try{
            sc.switchToScene_2_color(event);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
