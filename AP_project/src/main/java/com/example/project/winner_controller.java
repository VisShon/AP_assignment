package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class winner_controller implements Initializable {

    @FXML
    private Button menu_button;

    @FXML
    private Button replay_button;

    @FXML
    private TextField winner_textfield;

    @FXML
    private TextField loser_textfield;

    @FXML
    private ImageView winnerbackground;

    @FXML
    private ImageView won;

    @FXML
    private Rectangle rectangle;

    @Override
    public void initialize(URL arg0 , ResourceBundle arg1){
        System.out.println("textField is running");
        if(HelloApplication.getP1().getIsWinner()){
            winner_textfield.setText(HelloApplication.getP1().getName());
            loser_textfield.setText(HelloApplication.getP2().getName());
            winner_textfield.setEditable(false);
            loser_textfield.setEditable(false);
            return;
        }
        if(HelloApplication.getP2().getIsWinner()) {
            winner_textfield.setText(HelloApplication.getP2().getName());
            loser_textfield.setText(HelloApplication.getP1().getName());
            winner_textfield.setEditable(false);
            loser_textfield.setEditable(false);
            return;
        }
    }

    public void menu_button_pressed(ActionEvent event){
        SceneSwitcher sc = new SceneSwitcher();
        try {
            sc.switchToScene_1_frontPage(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void replay_button_pressed(ActionEvent event){
        SceneSwitcher sc = new SceneSwitcher();
        try {
            sc.switchToScene_3_Board(event);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}