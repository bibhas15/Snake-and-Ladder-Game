package com.example.snakybaky;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {
    public Block(int width, int height){
        setWidth(width);
        setHeight(height);
        setFill(Color.RED);
        setStroke(Color.BLACK);
    }
}
