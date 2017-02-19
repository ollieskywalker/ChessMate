package com.example.ekeri.chess.Pieces;

import com.example.ekeri.chess.R;

import java.util.ArrayList;

/**
 * Created by ekeri on 2/19/2017.
 */

public class Bishop {
    private boolean isClicked;
    private boolean isBlack;
    private int numberOfTurns;

    public Bishop(boolean isBlack) {
        this.isBlack = isBlack;
        this.isClicked = isClicked;
        numberOfTurns = 0;

    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setBlack(boolean black) {
        isBlack = black;
    }

    public int getNumberOfTurns() {
        return numberOfTurns;
    }

    public void setNumberOfTurns(int numberOfTurns) {
        this.numberOfTurns = numberOfTurns;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
    /*
   * This method is for PAWNS ONLY!!
    */
    public ArrayList<Integer> calculatePossibleMovements(int currentPosition){
        ArrayList<Integer> listOfPossibleMovementPosition= new ArrayList<>();

        int x = currentPosition/10;
        int y = currentPosition%10;

        if (this.getNumberOfTurns()==0){
            listOfPossibleMovementPosition.add((x) + (y-2)*10);
            listOfPossibleMovementPosition.add((x) + (y-2)*10);
        }
        else{
            listOfPossibleMovementPosition.add((x+1)*10 + y);
        }
        return  listOfPossibleMovementPosition;
    }
    public int getDrawableId(){
        if (this.isBlack()){
            return R.drawable.b_bishop;
        }
        else{
            return R.drawable.wbishop;
        }
    }
}
