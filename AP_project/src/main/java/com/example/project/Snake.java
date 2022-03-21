package com.example.project;

import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.CubicCurve;
import javafx.util.Duration;

public class Snake {

    private CubicCurve curve;
    public void setCurve(CubicCurve curve) {
        this.curve = curve;
    }
    public CubicCurve getCurve() {
        return curve;
    }

    private int grid_row_head;
    public int getGrid_row_head() {
        return grid_row_head;
    }
    public void setGrid_row_head(int grid_row) {
        this.grid_row_head = grid_row;
    }

    private int grid_col_head;
    public int getGrid_col_head() {
        return grid_col_head;
    }
    public void setGrid_col_head(int grid_col) {
        this.grid_col_head = grid_col;
    }

    private int grid_row_tail;
    public int getGrid_row_tail() {
        return grid_row_tail;
    }
    public void setGrid_row_tail(int grid_row) {
        this.grid_row_tail = grid_row;
    }

    private int grid_col_tail;
    public int getGrid_col_tail() {
        return grid_col_tail;
    }
    public void setGrid_col_tail(int grid_col) {
        this.grid_col_tail = grid_col;
    }


    public void BitePlayer(ImageView img){
//        PathTransition pt = new PathTransition();
//        pt.setNode(img);
//        pt.setDuration(Duration.seconds(1));
//        pt.setPath(curve);
//        pt.setCycleCount(2);
//        pt.play();

        board_Controller.getGridbaby().setRowIndex(img , grid_row_tail);
        board_Controller.getGridbaby().setColumnIndex(img , grid_col_tail);
    }
}
