package ticTacToe;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.geometry.Pos;
import javafx.geometry.Insets;

import java.util.HashMap;
import java.util.ArrayList;

public class TicTacToeApplication extends Application {


    public static void main(String[] args) {
        System.out.println("TicTacToe Time...");
        launch(TicTacToeApplication.class);
    }

    public void start(Stage window){
        // create layout
        BorderPane borderPane = new BorderPane();

        // create views
        GameState gameState = new GameState();
        GameInfoView gameInfo = new GameInfoView();
        GameBoardView gameBoard = new GameBoardView(gameState, gameInfo);

        Parent gameInfoView = gameInfo.getView();
        Parent gameBoardView = gameBoard.getView();
 

        // set elements
        borderPane.setTop(gameInfoView);
        borderPane.setCenter(gameBoardView);

        // set layout
        borderPane.setPrefSize(500, 500);
        

        // set scene and initial window
        Scene scene = new Scene(borderPane);
        window.setScene(scene);
        window.show();



    }

    // public static String createCoordinates(int row, int col){
    //     // convert x ,y coordinates into a string e.g. (1,2)
    //     return "(" + row + ", " + col +")";
    // }
}
