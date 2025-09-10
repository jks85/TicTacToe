package ticTacToe;

import java.util.ArrayList;
import javafx.scene.control.Button;

public class GameState {
    private String playerTurn;
    private ArrayList<Coordinates> selectedButtons;
    private ArrayList<Coordinates> xChoices;
    private ArrayList<Coordinates> oChoices;
    private boolean xIsWinner;
    private boolean oIsWinner;

    private static final int GRID_SIZE = 9;
    // class variable arrays containing possible winning coordinates
    private static final Coordinates[] ROW_ZERO_WIN_COORDS = GameState.createWinningRowCoords(0);
    private static final Coordinates[] ROW_ONE_WIN_COORDS = GameState.createWinningRowCoords(1);
    private static final Coordinates[] ROW_TWO_WIN_COORDS = GameState.createWinningRowCoords(2);

    private static final Coordinates[] COL_ZERO_WIN_COORDS = GameState.createWinningColCoords(0);
    private static final Coordinates[] COL_ONE_WIN_COORDS = GameState.createWinningColCoords(1);
    private static final Coordinates[] COL_TWO_WIN_COORDS = GameState.createWinningColCoords(2);
        
    private static final Coordinates[] MAIN_DIAG_WIN_COORDS = GameState.createWinningMainDiagCoords();
    private static final Coordinates[] OFF_DIAG_WIN_COORDS = GameState.createWinningOffDiagCoords();
    private static final Coordinates[][] WINNING_COORDS = {ROW_ZERO_WIN_COORDS, ROW_ONE_WIN_COORDS, ROW_TWO_WIN_COORDS,
                                            COL_ZERO_WIN_COORDS, COL_ONE_WIN_COORDS, COL_TWO_WIN_COORDS,
                                            MAIN_DIAG_WIN_COORDS, OFF_DIAG_WIN_COORDS};
    
    
    public GameState(){
        this.playerTurn = "X";
        this.selectedButtons = new ArrayList<>();
        this.xChoices = new ArrayList<>();
        this.oChoices = new ArrayList<>();
        this.xIsWinner = false;
        this.oIsWinner = false;

    }

    public String getPlayerTurn(){
        return this.playerTurn;
    }

    public void switchPlayerTurn(){
        this.playerTurn = this.playerTurn.equals("X") ? "O" : "X" ;
    }

    public ArrayList<Coordinates> getSelectedButtons(){
        return this.selectedButtons;
    }

    public void addButton(Coordinates coordinates){
        // add button if not selected
        if (!buttonHasBeenSelected(coordinates)){
            this.selectedButtons.add(coordinates);
            // add to X or O selections

            if (this.playerTurn.equals("X")){
                this.xChoices.add(coordinates);
                }
             else{
                this.oChoices.add(coordinates);
            }
        }
    }
    
    public boolean boardIsFull(){
        return this.selectedButtons.size() == GameState.GRID_SIZE;
    }

    public boolean buttonHasBeenSelected(Coordinates coordinates){
        if (this.selectedButtons.isEmpty()){
            return false;
        }
        if (this.selectedButtons.contains(coordinates)){
            return true;
        }
        return false;
    }

    public boolean buttonSelectedByX(Coordinates coordinates){
        if (!this.buttonHasBeenSelected(coordinates) || this.xChoices.isEmpty()){
            return false;
        }
        if (this.xChoices.contains(coordinates)){
            return true;
        }
        return false;
    }

    public boolean buttonSelectedByY(Coordinates coordinates){
        if (!this.buttonHasBeenSelected(coordinates) || this.oChoices.isEmpty()){
            return false;
        }
        if (this.oChoices.contains(coordinates)){
            return true;
        }
        return false;
    }

    public boolean gameOver(){
        return this.xIsWinner | this.oIsWinner;
    }

    private static Coordinates[] createWinningRowCoords(int row){
        // Create array of row coordinates that would win the game

        Coordinates[] rowWinner = new Coordinates[3];
        for (int col = 0; col < 3; col++) {
            rowWinner[col] = new Coordinates(row, col);
        }
        return rowWinner;
    }


    private static Coordinates[] createWinningColCoords(int col){
        // Create array of col coordinates that would win the game

        Coordinates[] colWinner = new Coordinates[3];
        for (int row = 0; row < 3; row++) {
            colWinner[row] = new Coordinates(row, col);
        }
        return colWinner;
    }

    private static Coordinates[] createWinningMainDiagCoords(){
        // Create array of main diagonal coordinates that would win the game

        Coordinates[] diagWinner = new Coordinates[3];
        for (int index = 0; index < 3; index++) {
            diagWinner[index] = new Coordinates(index, index);
        }
        return diagWinner;
    }


    private static Coordinates[] createWinningOffDiagCoords(){
        // Create array of off diagonal coordinates that would win the game

        Coordinates[] diagWinner = new Coordinates[3];
        for (int index = 0; index < 3; index++) {
            diagWinner[index] = new Coordinates(index, 2-index);
        }
        return diagWinner;
    }

    public boolean hasXWon(){
    // loop over winning coordinates and check if player X has won
        for (Coordinates[] coordArray : GameState.WINNING_COORDS){
            int numSelected = 0;
            for (Coordinates coord : coordArray){
                System.out.println("Player X has chosen: " + xChoices);
                if (!this.xChoices.contains(coord)){
                    System.out.println("X has not chosen " + coord);
                    break;
                } else {
                    numSelected++;
                }            
            }
            if (numSelected == 3){
                this.xIsWinner = true;
                return this.xIsWinner;
            }            	
        }
        return this.xIsWinner;
    }

    public boolean hasOWon(){
    // loop over winning coordinates and check if player O has won
        for (Coordinates[] coordArray : GameState.WINNING_COORDS){
            int numSelected = 0;
            for (Coordinates coord : coordArray){
                if (!this.oChoices.contains(coord)){
                    break;
                } else {
                    numSelected++;
                }            
            }
            if (numSelected == 3){
                this.oIsWinner = true;
                return this.oIsWinner;
            }            	
        }
        return this.oIsWinner;
    }

    public void disableAllButtons(ArrayList<Button> buttonList){
        for (Button button : buttonList){
            button.setDisable(true);
        }
    }

}
