package com.example.project;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class board_Controller implements Initializable {

    @FXML
    private ImageView arrow;

    @FXML
    private static GridPane gridbaby;
    public static GridPane getGridbaby(){
        return gridbaby;
    }

    @FXML
    private ImageView dice_case;

    @FXML
    private ImageView board_img;

    @FXML
    private ImageView background_img;

    @FXML
    private ImageView dice;

    @FXML
    private Button dice_button;

    @FXML
    private Button pimple;

    @FXML
    private ImageView p1img;

    @FXML
    private ImageView p2img;

    @FXML
    private Line line_61to82;

    @FXML
    private Line line_64to77;

    @FXML
    private Line line_76to95;

    @FXML
    private Line line_89to91;

    @FXML
    private Line line_37to65;

    @FXML
    private Line line_50to70;

    @FXML
    private Line line_3to21;

    @FXML
    private Line line_16to26;

    @FXML
    private Line line_8to46;

    @FXML
    private Line line_29to33;

    @FXML
    private CubicCurve curve_1;

    @FXML
    private CubicCurve curve_2;

    @FXML
    private CubicCurve curve_3;

    @FXML
    private CubicCurve curve_4;

    @FXML
    private CubicCurve curve_5;

    @FXML
    private CubicCurve curve_6;

    @FXML
    private CubicCurve curve_7;

    @FXML
    private CubicCurve curve_8;

    @FXML
    private CubicCurve curve_9;

    @FXML
    private CubicCurve curve_10;

    @FXML
    private ImageView plyr_1;

    @FXML
    private ImageView plyr_2;

    @FXML
    private ImageView right;
    @FXML
    private ImageView left;
    @FXML
    private Text plyr1_text;
    @FXML
    private Text plyr2_text;

    private Random rand;

    private ArrayList<Snake> snakes = new ArrayList<>();
    private ArrayList<Ladder> ladders = new ArrayList<>();

    @Override
    public void initialize(URL arg0 , ResourceBundle arg1){
        // translate arrow

        TranslateTransition translate = new TranslateTransition();
        translate.setNode(arrow);

        translate.setDuration(Duration.millis(250));
        translate.setCycleCount(TranslateTransition.INDEFINITE);
        translate.setAutoReverse(true);
        translate.setByY(15);
        translate.play();

        System.out.println("hello bhai");

//        58 to 98
        Snake s1 = new Snake();
        s1.setGrid_row_head(0);
        s1.setGrid_col_head(2);
        s1.setGrid_row_tail(4);
        s1.setGrid_col_tail(2);
        s1.setCurve(curve_1);
        snakes.add(s1);

        //84 to 96
        Snake s2 = new Snake();
        s2.setGrid_row_head(0);
        s2.setGrid_col_head(4);
        s2.setGrid_row_tail(1);
        s2.setGrid_col_tail(3);
        s2.setCurve(curve_2);
        snakes.add(s2);


        // 53 to 86
        Snake s3 = new Snake();
        s3.setGrid_row_head(1);
        s3.setGrid_col_head(5);
        s3.setGrid_row_tail(4);
        s3.setGrid_col_tail(7);
        s3.setCurve(curve_3);
        snakes.add(s3);


        //73 to 94
        Snake s4 = new Snake();
        s4.setGrid_row_head(0);
        s4.setGrid_col_head(6);
        s4.setGrid_row_tail(2);
        s4.setGrid_col_tail(7);
        s4.setCurve(curve_4);
        snakes.add(s4);


        // 72 to 90
        Snake s5 = new Snake();
        s5.setGrid_row_head(1);
        s5.setGrid_col_head(9);
        s5.setGrid_row_tail(2);
        s5.setGrid_col_tail(8);
        s5.setCurve(curve_5);
        snakes.add(s5);


        //42 to 60
        Snake s6 = new Snake();
        s6.setGrid_row_head(4);
        s6.setGrid_col_head(0);
        s6.setGrid_row_tail(5);
        s6.setGrid_col_tail(1);
        s6.setCurve(curve_6);
        snakes.add(s6);


        // 22 to 43
        Snake s7 = new Snake();
        s7.setGrid_row_head(5);
        s7.setGrid_col_head(2);
        s7.setGrid_row_tail(7);
        s7.setGrid_col_tail(1);
        s7.setCurve(curve_7);
        snakes.add(s7);


        // 25 to 56
        Snake s8 = new Snake();
        s8.setGrid_row_head(4);
        s8.setGrid_col_head(4);
        s8.setGrid_row_tail(7);
        s8.setGrid_col_tail(4);
        s8.setCurve(curve_8);
        snakes.add(s8);



        //5 to 24
        Snake s9 = new Snake();
        s9.setGrid_row_head(7);
        s9.setGrid_col_head(3);
        s9.setGrid_row_tail(9);
        s9.setGrid_col_tail(4);
        s9.setCurve(curve_9);
        snakes.add(s9);


        // 48 to 69
        Snake s10 = new Snake();
        s10.setGrid_row_head(3);
        s10.setGrid_col_head(8);
        s10.setGrid_row_tail(5);
        s10.setGrid_col_tail(7);
        s10.setCurve(curve_10);
        snakes.add(s10);



        Ladder l1 = new Ladder();
        l1.setGrid_row_top(1);
        l1.setGrid_col_top(1);
        l1.setGrid_row_bottom(3);
        l1.setGrid_col_bottom(0);
        l1.setLine(line_61to82);
        ladders.add(l1);

        Ladder l2 = new Ladder();
        l2.setGrid_row_top(2);
        l2.setGrid_col_top(3);
        l2.setGrid_row_bottom(3);
        l2.setGrid_col_bottom(3);
        l2.setLine(line_64to77);
        ladders.add(l2);


        Ladder l3 = new Ladder();
        l3.setGrid_row_top(0);
        l3.setGrid_col_top(5);
        l3.setGrid_row_bottom(2);
        l3.setGrid_col_bottom(4);
        l3.setLine(line_76to95);
        ladders.add(l3);


        Ladder l4 = new Ladder();
        l4.setGrid_row_top(0);
        l4.setGrid_col_top(9);
        l4.setGrid_row_bottom(1);
        l4.setGrid_col_bottom(8);
        l4.setLine(line_89to91);
        ladders.add(l4);


        Ladder l5 = new Ladder();
        l5.setGrid_row_top(3);
        l5.setGrid_col_top(4);
        l5.setGrid_row_bottom(6);
        l5.setGrid_col_bottom(3);
        l5.setLine(line_37to65);
        ladders.add(l5);


        Ladder l6 = new Ladder();
        l6.setGrid_row_top(3);
        l6.setGrid_col_top(9);
        l6.setGrid_row_bottom(5);
        l6.setGrid_col_bottom(9);
        l6.setLine(line_50to70);
        ladders.add(l6);


        Ladder l7 = new Ladder();
        l7.setGrid_row_top(7);
        l7.setGrid_col_top(0);
        l7.setGrid_row_bottom(9);
        l7.setGrid_col_bottom(2);
        l7.setLine(line_3to21);
        ladders.add(l7);


        Ladder l8 = new Ladder();
        l8.setGrid_row_top(7);
        l8.setGrid_col_top(5);
        l8.setGrid_row_bottom(8);
        l8.setGrid_col_bottom(4);
        l8.setLine(line_16to26);
        ladders.add(l8);


        Ladder l9 = new Ladder();
        l9.setGrid_row_top(5);
        l9.setGrid_col_top(5);
        l9.setGrid_row_bottom(9);
        l9.setGrid_col_bottom(7);
        l9.setLine(line_8to46);
        ladders.add(l9);


        Ladder l10 = new Ladder();
        l10.setGrid_row_top(6);
        l10.setGrid_col_top(7);
        l10.setGrid_row_bottom(7);
        l10.setGrid_col_bottom(8);
        l10.setLine(line_29to33);
        ladders.add(l10);

        Image img_1 , img_2;
        if(HelloApplication.getP1().getButt_color().equalsIgnoreCase("Blue")) {
            img_1 = new Image("blue.png");
            HelloApplication.getP1().setGoti(p1img);
            HelloApplication.getP1().getGoti().setImage(img_1);
            plyr_1.setImage(img_1);
            plyr1_text.setText(HelloApplication.getP1().getName());

            img_2 = new Image("green.png");
            HelloApplication.getP2().setGoti(p2img);
            HelloApplication.getP2().getGoti().setImage(img_2);
            plyr_2.setImage(img_2);
            plyr2_text.setText(HelloApplication.getP2().getName());
        }
        else if(HelloApplication.getP1().getButt_color().equalsIgnoreCase("Red")){
            img_1 = new Image("red.png");
            HelloApplication.getP1().setGoti(p1img);
            HelloApplication.getP1().getGoti().setImage(img_1);
            plyr_1.setImage(img_1);
            plyr1_text.setText(HelloApplication.getP1().getName());


            img_2 = new Image("yellow.png");
            HelloApplication.getP2().setGoti(p2img);
            HelloApplication.getP2().getGoti().setImage(img_2);
            plyr_2.setImage(img_2);
            plyr2_text.setText(HelloApplication.getP2().getName());
            System.out.println();
        }

        HelloApplication.getP1().setIsPlayerTurn(true);
        HelloApplication.getP2().setIsPlayerTurn(false);
        HelloApplication.getP1().setIsStarted(false);
        HelloApplication.getP2().setIsStarted(false);
        HelloApplication.getP1().setIsWinner(false);
        HelloApplication.getP2().setIsWinner(false);


        // for checking
//        gridbaby.setRowIndex(HelloApplication.getP1().getGoti() , 0);
//        gridbaby.setRowIndex(HelloApplication.getP2().getGoti() , 0);
//
//        gridbaby.setColumnIndex(HelloApplication.getP1().getGoti() , 5);
//        gridbaby.setColumnIndex(HelloApplication.getP2().getGoti() , 5);


    }

    private String [] arr = {"1.png","2.png","3.png","4.png","5.png","6.png"};

    public void dice_animation(ActionEvent event){
        ScaleTransition scale = new ScaleTransition();
        scale.setNode(dice);

        scale.setDuration(Duration.millis(250));
        scale.setInterpolator(Interpolator.LINEAR);
        scale.setCycleCount(2);
        scale.setByY(1.5);
        scale.setByX(1.5);
        scale.setAutoReverse(true);
        scale.play();


        RotateTransition rotate = new RotateTransition();
        rotate.setNode(dice);

        rotate.setDuration(Duration.millis(250));
        rotate.setCycleCount(5);
        rotate.setByAngle(360);
        rotate.setInterpolator(Interpolator.LINEAR);
        rotate.setAxis(Rotate.X_AXIS);
//        rotate.setAxis(Rotate.Z_AXIS);
        rotate.play();
    }

    public void back_button_pressed(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Back to color selection");
        alert.setHeaderText("You pressed the back button");
        alert.setContentText("Are you sure you want to go to the color Selection Window");

        if(alert.showAndWait().get() == ButtonType.OK){
            SceneSwitcher sc = new SceneSwitcher();
            try {
                sc.switchToScene_2_color(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("back successfully!");
        }


    }

    public void fire_button(ActionEvent event){
        System.out.println("hai bhagwaan");
        SceneSwitcher sc = new SceneSwitcher();
        try {
            sc.switchToScene_4_WinnerPage(event);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Snake check_for_snake_head(ImageView img){
        for(Snake s: snakes){
            if(gridbaby.getRowIndex(img)==s.getGrid_row_head()&&gridbaby.getColumnIndex(img)==s.getGrid_col_head()){
                return s;
            }
        }
        return null;
    }

    public Ladder check_for_ladder_bottom(ImageView img){
        for(Ladder l: ladders){
            if(gridbaby.getRowIndex(img)==l.getGrid_row_bottom()&&gridbaby.getColumnIndex(img)==l.getGrid_col_bottom()){
                return l;
            }
        }
        return null;
    }

    public int dice_throw(ActionEvent event){
        // now generating the random integer by dice
        rand = new Random();
        int dice_throw_value = rand.nextInt(6) + 1;
        System.out.println(dice_throw_value);

        Image image = new Image(arr[dice_throw_value - 1]);

        dice.setImage(image);

        return dice_throw_value;
    }

    public boolean hasWon(ImageView img){
        if(gridbaby.getColumnIndex(img) == 0 && gridbaby.getRowIndex(img) == 0){
            return true;
        }

        return false;
    }

    public void dice_button_pressed(ActionEvent event){

        dice_animation(event);
        int dice_throw_value = dice_throw(event);
        if(HelloApplication.getP1().getIsPlayerTurn()){
            if(!HelloApplication.getP1().getIsStarted()){
                if(dice_throw_value == 1){
                    gridbaby.setRowIndex(HelloApplication.getP1().getGoti() , 9);
                    gridbaby.setColumnIndex(HelloApplication.getP1().getGoti() , 0);
                    HelloApplication.getP1().setIsStarted(true);
                }
            }

            else if(HelloApplication.getP1().getIsStarted()){
                if(gridbaby.getRowIndex(HelloApplication.getP1().getGoti())==0 && gridbaby.getColumnIndex(HelloApplication.getP1().getGoti())<=5){
                    if(dice_throw_value > gridbaby.getColumnIndex(HelloApplication.getP1().getGoti())){
                        System.out.println("big Number");
                    }
                    else{
                        for(int i = 0 ;  i < dice_throw_value ; i++) {
                            if (gridbaby.getRowIndex(HelloApplication.getP1().getGoti()) % 2 == 1) {
                                if (gridbaby.getColumnIndex(HelloApplication.getP1().getGoti()) != 9) {
                                    gridbaby.setColumnIndex(HelloApplication.getP1().getGoti(), gridbaby.getColumnIndex(HelloApplication.getP1().getGoti()) + 1);
                                } else {
                                    if (gridbaby.getRowIndex(HelloApplication.getP1().getGoti()) != 0) {
                                        gridbaby.setRowIndex(HelloApplication.getP1().getGoti(), gridbaby.getRowIndex(HelloApplication.getP1().getGoti()) - 1);
                                    }
                                }
                            } else {
                                // move left
                                if (gridbaby.getColumnIndex(HelloApplication.getP1().getGoti()) != 0) {
                                    // then move left
                                    gridbaby.setColumnIndex(HelloApplication.getP1().getGoti(), gridbaby.getColumnIndex(HelloApplication.getP1().getGoti()) - 1);
                                } else {
                                    if (gridbaby.getRowIndex(HelloApplication.getP1().getGoti()) != 0) {
                                        gridbaby.setRowIndex(HelloApplication.getP1().getGoti(), gridbaby.getRowIndex(HelloApplication.getP1().getGoti()) - 1);
                                    }
                                }
                            }
                        }
                    }

                    if(hasWon(HelloApplication.getP1().getGoti())){
                        HelloApplication.getP1().setIsWinner(true);
                        HelloApplication.getP2().setIsWinner(false);
                        pimple.fire();
                    }

                }
                else{
                    for(int i = 0 ;  i < dice_throw_value ; i++){
                        if(gridbaby.getRowIndex(HelloApplication.getP1().getGoti()) % 2 == 1) {
                            if (gridbaby.getColumnIndex(HelloApplication.getP1().getGoti()) != 9) {
                                gridbaby.setColumnIndex(HelloApplication.getP1().getGoti(), gridbaby.getColumnIndex(HelloApplication.getP1().getGoti()) + 1);
                            }
                            else {
                                if(gridbaby.getRowIndex(HelloApplication.getP1().getGoti()) != 0) {
                                    gridbaby.setRowIndex(HelloApplication.getP1().getGoti(), gridbaby.getRowIndex(HelloApplication.getP1().getGoti()) - 1);
                                }
                            }
                        }
                        else{
                            // move left
                            if(gridbaby.getColumnIndex(HelloApplication.getP1().getGoti()) != 0){
                                // then move left
                                gridbaby.setColumnIndex(HelloApplication.getP1().getGoti(), gridbaby.getColumnIndex(HelloApplication.getP1().getGoti()) - 1);
                            }
                            else{
                                if(gridbaby.getRowIndex(HelloApplication.getP1().getGoti()) != 0) {
                                    gridbaby.setRowIndex(HelloApplication.getP1().getGoti(), gridbaby.getRowIndex(HelloApplication.getP1().getGoti()) - 1);
                                }
                            }
                        }
                    }

                }

                Ladder l = check_for_ladder_bottom(HelloApplication.getP1().getGoti());
                if(l != null){
                    l.stepUpPlayer(HelloApplication.getP1().getGoti());
                }

                Snake s = check_for_snake_head(HelloApplication.getP1().getGoti());
                if(s != null){
                    s.BitePlayer(HelloApplication.getP1().getGoti());
                }

            }
        }
        if(HelloApplication.getP2().getIsPlayerTurn()){
            if(!HelloApplication.getP2().getIsStarted()){
                if(dice_throw_value == 1){
                    gridbaby.setRowIndex(HelloApplication.getP2().getGoti() , 9);
                    gridbaby.setColumnIndex(HelloApplication.getP2().getGoti() , 0);
                    HelloApplication.getP2().setIsStarted(true);
                }
            }

            else if(HelloApplication.getP2().getIsStarted()){
                if(gridbaby.getRowIndex(HelloApplication.getP2().getGoti())==0 && gridbaby.getColumnIndex(HelloApplication.getP2().getGoti())<=5){
                    if(dice_throw_value > gridbaby.getColumnIndex(HelloApplication.getP2().getGoti())){
                        System.out.println("big Number");
                    }
                    else {
                        for (int i = 0; i < dice_throw_value; i++) {
                            if (gridbaby.getRowIndex(HelloApplication.getP2().getGoti()) % 2 == 1) {
                                if (gridbaby.getColumnIndex(HelloApplication.getP2().getGoti()) != 9) {
                                    gridbaby.setColumnIndex(HelloApplication.getP2().getGoti(), gridbaby.getColumnIndex(HelloApplication.getP2().getGoti()) + 1);
                                } else {
                                    if (gridbaby.getRowIndex(HelloApplication.getP2().getGoti()) != 0) {
                                        gridbaby.setRowIndex(HelloApplication.getP2().getGoti(), gridbaby.getRowIndex(HelloApplication.getP2().getGoti()) - 1);
                                    }
                                }
                            } else {
                                // move left
                                if (gridbaby.getColumnIndex(HelloApplication.getP2().getGoti()) != 0) {
                                    // then move left
                                    gridbaby.setColumnIndex(HelloApplication.getP2().getGoti(), gridbaby.getColumnIndex(HelloApplication.getP2().getGoti()) - 1);
                                } else {
                                    if (gridbaby.getRowIndex(HelloApplication.getP2().getGoti()) != 0) {
                                        gridbaby.setRowIndex(HelloApplication.getP2().getGoti(), gridbaby.getRowIndex(HelloApplication.getP2().getGoti()) - 1);
                                    }
                                }
                            }
                        }
                    }
                    if(gridbaby.getRowIndex(HelloApplication.getP2().getGoti()) == 0){
                        if(hasWon(HelloApplication.getP2().getGoti())){
                            HelloApplication.getP2().setIsWinner(true);
                            HelloApplication.getP1().setIsWinner(false);
                            pimple.fire();
                        }
                    }
                }
                else {
                    for (int i = 0; i < dice_throw_value; i++) {
                        if (gridbaby.getRowIndex(HelloApplication.getP2().getGoti()) % 2 == 1) {
                            if (gridbaby.getColumnIndex(HelloApplication.getP2().getGoti()) != 9) {
                                gridbaby.setColumnIndex(HelloApplication.getP2().getGoti(), gridbaby.getColumnIndex(HelloApplication.getP2().getGoti()) + 1);
                            } else {
                                if (gridbaby.getRowIndex(HelloApplication.getP2().getGoti()) != 0) {
                                    gridbaby.setRowIndex(HelloApplication.getP2().getGoti(), gridbaby.getRowIndex(HelloApplication.getP2().getGoti()) - 1);
                                }
                            }
                        } else {
                            // move left
                            if (gridbaby.getColumnIndex(HelloApplication.getP2().getGoti()) != 0) {
                                // then move left
                                gridbaby.setColumnIndex(HelloApplication.getP2().getGoti(), gridbaby.getColumnIndex(HelloApplication.getP2().getGoti()) - 1);
                            } else {
                                if (gridbaby.getRowIndex(HelloApplication.getP2().getGoti()) != 0) {
                                    gridbaby.setRowIndex(HelloApplication.getP2().getGoti(), gridbaby.getRowIndex(HelloApplication.getP2().getGoti()) - 1);
                                }
                            }
                        }
                    }
                }

                Ladder l = check_for_ladder_bottom(HelloApplication.getP2().getGoti());
                if(l != null){
                    l.stepUpPlayer(HelloApplication.getP2().getGoti());
                }

                Snake s = check_for_snake_head(HelloApplication.getP2().getGoti());
                if(s != null) {
                    s.BitePlayer(HelloApplication.getP2().getGoti());
                }
            }
        }
        //now which player turn is accepted
        boolean temp=HelloApplication.getP1().getIsPlayerTurn();
        HelloApplication.getP1().setIsPlayerTurn(HelloApplication.getP2().getIsPlayerTurn());
        HelloApplication.getP2().setIsPlayerTurn(temp);

    }
}