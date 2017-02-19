package com.example.ekeri.chess.Pieces;

import com.example.ekeri.chess.R;

import java.util.ArrayList;

/**
 * Created by ekeri on 2/19/2017.
 */

public class Pawns {
    private boolean isBlack;
    private int numberOfTurns;
    //Click and being methods to find possible moves

    public Pawns(boolean isBlack) {
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

        if (isBlack()){
            int y = currentPosition/10;
            int x = currentPosition%10;

            if (this.getNumberOfTurns()==0){
                listOfPossibleMovementPosition.add((y-2)*10+x);
                listOfPossibleMovementPosition.add((y-1)*10+x);

            }
            else{
                listOfPossibleMovementPosition.add((y-1)*10+x);
            }
            return  listOfPossibleMovementPosition;
        }
        else{
            int y = currentPosition/10;
            int x = currentPosition%10;

            if (this.getNumberOfTurns()==0){
                listOfPossibleMovementPosition.add((y+2)*10+x);
                listOfPossibleMovementPosition.add((y+1)*10+x);
            }
            else{
                listOfPossibleMovementPosition.add((y+1)*10+x);
            }
            return  listOfPossibleMovementPosition;
        }


    }
    public int getDrawableId(){
        if (this.isBlack()){
            return R.drawable.b_pawn;
        }
        else{
            return R.drawable.w_pawn;
        }
    }

}
