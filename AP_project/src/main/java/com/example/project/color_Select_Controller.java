package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class color_Select_Controller {
    @FXML
    private AnchorPane scenepane;

    @FXML
    private ImageView snakebackground;

    @FXML
    private ImageView choose_col_text;

    @FXML
    private CheckBox check_box_upper;// ----> this is for blue and green

    @FXML
    private CheckBox check_box_lower;// ----> this is for red and green

    @FXML
    private Button exit_button;

    @FXML
    private Button play_button;

    @FXML
    private TextField text_box_p1_upper;

    @FXML
    private TextField text_box_p2_upper;

    @FXML
    private TextField text_box_p1_lower;

    @FXML
    private TextField text_box_p2_lower;



    public void exitButtonPressed(ActionEvent event){
        SceneSwitcher sc = new SceneSwitcher();
        try{
            sc.switchToScene_1_frontPage(event);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void UpperCheckBox(ActionEvent event){
        if(check_box_upper.isSelected()){
            check_box_lower.setSelected(false);
            text_box_p1_upper.setEditable(true);
            text_box_p2_upper.setEditable(true);

            text_box_p1_lower.setEditable(false);
            text_box_p2_lower.setEditable(false);
        }
        else{
            text_box_p1_upper.setEditable(true);
            text_box_p2_upper.setEditable(true);

            text_box_p1_lower.setEditable(true);
            text_box_p2_lower.setEditable(true);
        }
    }

    public void LowerCheckBox(ActionEvent event){
        if(check_box_lower.isSelected()){
            check_box_upper.setSelected(false);
            text_box_p1_lower.setEditable(true);
            text_box_p2_lower.setEditable(true);

            text_box_p1_upper.setEditable(false);
            text_box_p2_upper.setEditable(false);
        }
        else{
            text_box_p1_upper.setEditable(true);
            text_box_p2_upper.setEditable(true);

            text_box_p1_lower.setEditable(true);
            text_box_p2_lower.setEditable(true);
        }
    }


    public void PlayButtonPressed(ActionEvent event){
        if((!check_box_upper.isSelected() && !check_box_lower.isSelected()) || (check_box_upper.isSelected() && check_box_lower.isSelected())){

        }
        else{
            if(check_box_upper.isSelected()){
                text_box_p1_lower.setEditable(false);
                text_box_p2_lower.setEditable(false);
                HelloApplication.setP1(new Player());
                HelloApplication.setP2(new Player());

                HelloApplication.getP1().setButt_color("Blue");
                HelloApplication.getP2().setButt_color("Green");
                HelloApplication.getP1().setName(text_box_p1_upper.getText());
                HelloApplication.getP2().setName(text_box_p2_upper.getText());

                System.out.println(HelloApplication.getP1().getButt_color());
                System.out.println(HelloApplication.getP2().getButt_color());

                System.out.println(HelloApplication.getP1().getName());
                System.out.println(HelloApplication.getP2().getName());

            }

            if(check_box_lower.isSelected()){
                text_box_p1_upper.setEditable(false);
                text_box_p2_upper.setEditable(false);
                HelloApplication.setP1(new Player());
                HelloApplication.setP2(new Player());

                // setting player goti color
                HelloApplication.getP1().setButt_color("Red");
                HelloApplication.getP2().setButt_color("Yellow");

                //setting player name
                HelloApplication.getP1().setName(text_box_p1_lower.getText());
                HelloApplication.getP2().setName(text_box_p2_lower.getText());

                System.out.println(HelloApplication.getP1().getButt_color());
                System.out.println(HelloApplication.getP2().getButt_color());

                System.out.println(HelloApplication.getP1().getName());
                System.out.println(HelloApplication.getP2().getName());

            }

            SceneSwitcher sc = new SceneSwitcher();
            try{
                sc.switchToScene_3_Board(event);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
