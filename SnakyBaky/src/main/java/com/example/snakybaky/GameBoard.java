package com.example.snakybaky;

import javafx.util.Pair;
import java.util.ArrayList;
public class GameBoard {
    static int blockSize = 40;
    static int height = 10;
    static int width = 10;
    static ArrayList<Pair<Integer, Integer>> posCord;
    static ArrayList <Integer> snakeLadderPosition;

    GameBoard() {
        popuPosCord();
        setPositionCoord();
    }
    public int getXValue(int piecePosition){
        return posCord.get(piecePosition).getKey();
    }

    public int getYValue(int piecePosition){
        return posCord.get(piecePosition).getValue();
    }

    public int playerPositionAtSnakeOrLadder(int piecePosition) {
        if(piecePosition!=snakeLadderPosition.get(piecePosition)) {
            return snakeLadderPosition.get(piecePosition);
        }

        return -1;
    }

    private void setPositionCoord() {
        snakeLadderPosition = new ArrayList<>();
        for (int i = 0; i < 101; i++) {
            snakeLadderPosition.add(i);
        }
        snakeLadderPosition.set(5,35);
        snakeLadderPosition.set(9,51);
        snakeLadderPosition.set(23,42);
        snakeLadderPosition.set(36,5);
        snakeLadderPosition.set(48,86);
        snakeLadderPosition.set(49,7);
        snakeLadderPosition.set(56,8);
        snakeLadderPosition.set(62,83);
        snakeLadderPosition.set(69,91);
        snakeLadderPosition.set(82,20);
        snakeLadderPosition.set(87,66);
        snakeLadderPosition.set(95,38);
    }

    private static void popuPosCord(){
        posCord = new ArrayList<Pair<Integer, Integer>>();
        posCord.add(new Pair<Integer, Integer>(0, 0));

        int xBlockPos, yBlockPos;
        for (int i = height-1; i >= 0; i--) {
            for (int j = width-1; j >=0; j--) {
                if(i%2!=0){
                    xBlockPos = blockSize*width - (blockSize/2 + j*blockSize);
                }
                else{
                    xBlockPos = blockSize/2 + j*blockSize;
                }
                yBlockPos = blockSize/2 + i*blockSize;
                posCord.add(new Pair<Integer, Integer >(xBlockPos, yBlockPos));
            }

        }

        for (int i = 0; i < posCord.size(); i++) {
            //System.out.println(i +" x : "+posCord.get(i).getKey()+" y : "+posCord.get(i).getValue());

        }


    }

    public static void main(String[] args) {
        popuPosCord();
    }
}
