package ticTacToe;

public class Coordinates {
    private int row;
    private int col;

    public Coordinates(int row, int col){
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString(){
        return "(" + this.row +", " + this.col + ")";
    }

    @Override
    public boolean equals(Object comparedObject){
        if (this == comparedObject ){
            return true;
        }

        if  (!(comparedObject instanceof Coordinates)){
            return false;
        }

        Coordinates comparedCoord = (Coordinates) comparedObject;

        if (this.row == comparedCoord.row & this.col == comparedCoord.col){
            return true;
        }

        return false;
    }
}
