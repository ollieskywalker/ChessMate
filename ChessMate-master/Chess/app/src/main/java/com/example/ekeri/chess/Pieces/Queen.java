package com.example.ekeri.chess.Pieces;

import com.example.ekeri.chess.R;

import java.util.ArrayList;

/**
 * Created by ekeri on 2/19/2017.
 */

public class Queen {
    private boolean isBlack;
    private int numberOfTurns;

    public Queen(boolean isBlack) {
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

           return  listOfPossibleMovementPosition;

       }else{
           int x = currentPosition/10;
           int y = currentPosition%10;

           //fill in moving straight up and down
           for (int i = 1; i < 8; i ++){
               listOfPossibleMovementPosition.add((y+i)*10+x);
               listOfPossibleMovementPosition.add((y-i)*10+x);
           }

           //fill in moving straight left and right
           for (int i = 1; i < 8; i ++){
               listOfPossibleMovementPosition.add(y*10+x+i);
               listOfPossibleMovementPosition.add(y*10+x-i);
           }
//           for(int i = 1; i < 8; i++){
//               listOfPossibleMovementPosition.add((y+i)*10+x+i);
//               listOfPossibleMovementPosition.add((y+i)*10+x-i);
//           }



           return  listOfPossibleMovementPosition;

       }
    }
    public int getDrawableId(){
        if (this.isBlack()){
            return R.drawable.bqueen;
        }
        else{
            return R.drawable.wqueen;
        }
    }
}
