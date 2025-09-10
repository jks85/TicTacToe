package ticTacToe;

import javafx.scene.Parent;
import javafx.scene.control.Label;

public class GameInfoView {
    private Label gameInfoLabel;

    public GameInfoView(){
        this.gameInfoLabel = new Label("Turn: X");
    }


    public Parent getView(){
        // currently only returns label with game info
        // could add other info

        return this.gameInfoLabel;
    }

    public String getInfoLabelText(){
        return this.gameInfoLabel.getText();    
    }

    public void setInfoLabelText(String text){
        this.gameInfoLabel.setText(text);
    }


}
