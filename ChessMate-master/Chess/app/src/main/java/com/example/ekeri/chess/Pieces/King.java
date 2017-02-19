package com.example.ekeri.chess.Pieces;

import com.example.ekeri.chess.R;

import java.util.ArrayList;

/**
 * Created by ekeri on 2/19/2017.
 */

public class King {
    private boolean isBlack;
    private int numberOfTurns;

    public King(boolean isBlack) {
        this.isBlack = isBlack;
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

    /*
   * This method is for PAWNS ONLY!!
    */
    public ArrayList<Integer> calculatePossibleMovements(int currentPosition){
        ArrayList<Integer> listOfPossibleMovementPosition= new ArrayList<>();

        if(isBlack()){
            int x = currentPosition/10;
            int y = currentPosition%10;


            listOfPossibleMovementPosition.add((y-1)*10+x);
            listOfPossibleMovementPosition.add((y-1)*10+x+1);
            listOfPossibleMovementPosition.add((y-1)*10+x-1);

            listOfPossibleMovementPosition.add((y+1)*10+x);
            listOfPossibleMovementPosition.add((y+1)*10+x-1);
            listOfPossibleMovementPosition.add((y+1)*10+x+1);

            listOfPossibleMovementPosition.add((y)*10+x+1);
            listOfPossibleMovementPosition.add((y)*10+x-1);

            return  listOfPossibleMovementPosition;
        }
        else{

            int y = currentPosition/10;
            int x = currentPosition%10;


            listOfPossibleMovementPosition.add((y+1)*10+x);
            listOfPossibleMovementPosition.add((y+1)*10+x+1);
            listOfPossibleMovementPosition.add((y+1)*10+x-1);

            listOfPossibleMovementPosition.add((y-1)*10+x);
            listOfPossibleMovementPosition.add((y-1)*10+x-1);
            listOfPossibleMovementPosition.add((y-1)*10+x+1);

            listOfPossibleMovementPosition.add((y)*10+x+1);
            listOfPossibleMovementPosition.add((y)*10+x-1);

            return  listOfPossibleMovementPosition;

        }
    }
    public int getDrawableId(){
        if (this.isBlack()){
            return R.drawable.bking;
        }
        else{
            return R.drawable.wking;
        }
    }
}
