package ticTacToe;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.control.Button;

import java.util.ArrayList;


public class GameBoardView{
    private GameState gameState;
    private GameInfoView gameInfo;

    public GameBoardView(GameState gameState, GameInfoView gameInfo){
        this.gameState = gameState;
        this.gameInfo = gameInfo;
    }

    public Parent getView(){
        GridPane gameBoardGridpane = new GridPane();
        
        ArrayList<Button> buttonList = new ArrayList<>();
        ArrayList<Coordinates> selectedButtons = gameState.getSelectedButtons();
        
        // build 3x3 board with event handlers
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                Coordinates coordinates = new Coordinates(i, j);
                System.out.println("Setting button at coordinates: " + coordinates);
                Button currentButton = new Button();
                buttonList.add(currentButton);

                // size and add button
                GridPane.setHgrow(currentButton, Priority.ALWAYS);
                GridPane.setVgrow(currentButton, Priority.ALWAYS);
                gameBoardGridpane.add(currentButton,j,i);

                // create button event handler
                currentButton.setOnAction((event) -> {
                    
                    System.out.println("Button list contains " + coordinates + "?");
                    System.out.println(selectedButtons.contains(coordinates));
                    System.out.println(selectedButtons);
                    if (!gameState.buttonHasBeenSelected(coordinates)){
                        // add button to selected list
                        gameState.addButton(coordinates);
                        
                        if (gameState.getPlayerTurn().equals("X")){
                            currentButton.setText("X");
                            if (gameState.hasXWon()){
                                gameState.disableAllButtons(buttonList);
                                this.gameInfo.setInfoLabelText("X Wins!"); 
                            } else{
                                this.gameInfo.setInfoLabelText("Turn: O"); 
                            }

                                
                        } else{
                            currentButton.setText("O");
                            if (gameState.hasOWon()){
                                gameState.disableAllButtons(buttonList);
                                this.gameInfo.setInfoLabelText("O Wins!");
                            } else{
                                this.gameInfo.setInfoLabelText("Turn: X");
                            }
                            
                        }
                        gameState.switchPlayerTurn();  
                        
                        System.out.println(selectedButtons);
                        if (gameState.boardIsFull()){
                            this.gameInfo.setInfoLabelText("Draw!");
                            gameState.disableAllButtons(buttonList);

                        }
                    
                    } 

                });
                
            }
        }

        gameBoardGridpane.setAlignment(Pos.CENTER);
        gameBoardGridpane.setPadding(new Insets(10, 20, 10,20));

        return gameBoardGridpane;
    }
}