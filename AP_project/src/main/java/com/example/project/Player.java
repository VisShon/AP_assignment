package com.example.project;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class Player {

    private ImageView goti; // button is geti
    public void setGoti(ImageView goti) {
        this.goti = goti;
    }
    public ImageView getGoti() {
        return goti;
    }


    private String butt_color;
    public String getButt_color() {
        return butt_color;
    }
    public void setButt_color(String butt_color) {
        this.butt_color = butt_color;
    }

    private boolean isStarted;
    public boolean getIsStarted() {
        return isStarted;
    }

    public void setIsStarted(boolean started) {
        isStarted = started;
    }

    // player coordinates can be accessed from button coordinates

    private int dice_throw_value;
    public int getDice_throw_value() {
        return dice_throw_value;
    }
    public void setDice_throw_value(int dice_throw_value) {
        this.dice_throw_value = dice_throw_value;
    }


    private boolean isPlayerTurn;
    public boolean getIsPlayerTurn() {
        return isPlayerTurn;
    }
    public void setIsPlayerTurn(boolean playerTurn) {
        isPlayerTurn = playerTurn;
    }

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private boolean isWinner;
    public boolean getIsWinner(){
        return isWinner;
    }
    public void setIsWinner(boolean b){
        this.isWinner = b;
    }
}
