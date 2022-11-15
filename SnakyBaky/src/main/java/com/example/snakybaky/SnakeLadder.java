package com.example.snakybaky;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class SnakeLadder extends Application {

    public final int blockSize = 40;
    int height = 10;
    int width = 10;

    int diceValue;

    Label label;

    boolean gameStart = true, turnOnePlayer = true, turnTwoPlayer = false;
    int yLine = 430;
    Group blockGroup = new Group();
    Player playerone, playertwo;
    public Pane createContent(){

        Pane root = new Pane();
        root.setPrefSize(width*blockSize, height*blockSize+80);
        root.getChildren().addAll(blockGroup);

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Block block = new Block(blockSize, blockSize);
                block.setTranslateX(j*blockSize);
                block.setTranslateY(i*blockSize);
                blockGroup.getChildren().addAll(block);
            }

        }

        label = new Label("");
        label.setTranslateX(200);
        label.setTranslateY(yLine-20);
        label.setStyle("-fx-text-fill: #ff0000;");

        Button playerOne = new Button("Player One");
        playerOne.setTranslateX(120);
        playerOne.setTranslateY(yLine);
        playerOne.setStyle("-fx-background-color: #00ff00; ");
        //playerOne.setStyle("-fx-text-fill: #FFFFFF;");
        playerOne.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart==true){
                    if(turnOnePlayer==true){
                        getDiceValue();
                        playerone.movePlayer(diceValue);
                        playerone.playerAtSnakeOrLadder();
                        turnOnePlayer= false;
                        turnTwoPlayer = true;
                    }
                }

            }
        });

//        Button startButton = new Button("Star Game");
//        startButton.setTranslateX(160);
//        startButton.setTranslateY(yLine);

        Button playerTwo = new Button("Player Two");
        playerTwo.setTranslateX(210);
        playerTwo.setTranslateY(yLine);
        playerTwo.setStyle("-fx-background-color: #0000ff; ");
        //playerTwo.setStyle("-fx-text-fill: #ffffff; ");
        playerTwo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(gameStart==true){
                    if(turnTwoPlayer==true){
                        getDiceValue();
                        playertwo.movePlayer(diceValue);
                        playertwo.playerAtSnakeOrLadder();
                        turnOnePlayer = true;
                        turnTwoPlayer= false;
                    }
                }

            }
        });



        playerone = new Player(blockSize, Color.GREEN);
        playertwo = new Player(blockSize, Color.BLUE);

        Image img = new Image("C:\\Users\\BIBHAS SAHA\\IdeaProjects\\SnakyBaky\\src\\SnakyBaky.jpg");
        ImageView boardImage = new ImageView();
        boardImage.setImage(img);
        boardImage.setFitWidth(blockSize*width);
        boardImage.setFitHeight(blockSize*height);

        blockGroup.getChildren().addAll(boardImage,
                playerOne, playerTwo, label,
                playerone.getGamePiece(),
                playertwo.getGamePiece());

        return root;

    }

    private void getDiceValue(){
        diceValue = (int)(Math.random()*6+1);
        label.setText(Integer.toString(diceValue));


    }


    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(createContent());
        stage.setTitle("Snake and Ladder");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}