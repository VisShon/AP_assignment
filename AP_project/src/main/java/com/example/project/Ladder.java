package com.example.project;

import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Ladder {

    private Line line;
    public Line getLine() {
        return line;
    }
    public void setLine(Line line) {
        this.line = line;
    }

    private int grid_row_bottom;
    public int getGrid_row_bottom() {
        return grid_row_bottom;
    }
    public void setGrid_row_bottom(int grid_row) {
        this.grid_row_bottom = grid_row;
    }

    private int grid_col_bottom;
    public int getGrid_col_bottom() {
        return grid_col_bottom;
    }
    public void setGrid_col_bottom(int grid_col) {
        this.grid_col_bottom = grid_col;
    }


    private int grid_row_top;
    public int getGrid_row_top() {
        return grid_row_top;
    }
    public void setGrid_row_top(int grid_row) {
        this.grid_row_top = grid_row;
    }

    private int grid_col_top;
    public int getGrid_col_top() {
        return grid_col_top;
    }
    public void setGrid_col_top(int grid_col) {
        this.grid_col_top = grid_col;
    }

    public void stepUpPlayer(ImageView img){
//        board_Controller.getGridbaby().getChildren().remove(img);
//        PathTransition pt = new PathTransition();
//        pt.setNode(img);
//        pt.setDuration(Duration.seconds(1));
//        pt.setPath(line);
//        pt.setCycleCount(2);
//        pt.play();
        board_Controller.getGridbaby().setRowIndex(img , grid_row_top);
        board_Controller.getGridbaby().setColumnIndex(img , grid_col_top);

    }
}
