package com.example.ekeri.chess;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.ekeri.chess.Pieces.Bishop;
import com.example.ekeri.chess.Pieces.King;
import com.example.ekeri.chess.Pieces.Knight;
import com.example.ekeri.chess.Pieces.Pawns;
import com.example.ekeri.chess.Pieces.Queen;
import com.example.ekeri.chess.Pieces.Rook;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    static Tile[][] gameBoard = new Tile[8][8];
    Tile clickedTile = null;
    ArrayList<Integer> possibleMoves = new ArrayList<>();
    int playerTurn=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireGameBoard();
        populateGameBoard();
        calculateMovement();
        setOnclickListener();

    }

    private void setOnclickListener() {
            for (Tile[] tiles : gameBoard){
                for (final Tile tile: tiles){
                    tile.getButton().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //if your current tile is not empty, highlight it
                            if (tile.detectType()!=null){
                                String type = tile.detectType();
                                if (type.equals("pawn")){
                                    possibleMoves= tile.getPawns().calculatePossibleMovements(tile.getPosition());
                                    clickedTile=tile;
                                    highlight();
                                }
                                else if (type.equals("king")){
                                    possibleMoves= tile.getKing().calculatePossibleMovements(tile.getPosition());
                                    clickedTile=tile;
                                    highlight();
                                }
                                else if (type.equals("queen")){
                                    possibleMoves=tile.getQueen().calculatePossibleMovements(tile.getPosition());
                                    clickedTile=tile;
                                    highlight();
                                }
                                else if (type.equals("bishop")){
                                    possibleMoves=tile.getBishop().calculatePossibleMovements(tile.getPosition());
                                    clickedTile=tile;
                                }
                                else if(type.equals("rook")){
                                    possibleMoves=tile.getRook().calculatePossibleMovements(tile.getPosition());
                                    clickedTile=tile;
                                }
                                else {
                                    possibleMoves=tile.getKnight().calculatePossibleMovements(tile.getPosition());
                                    clickedTile=tile;
                                }
                            }
                            else{
                                //After we move piece, set original location to null
                                if (clickedTile!=null && possibleMoves.contains(tile.getPosition())){
                                    tile.getButton().setBackground(clickedTile.getButton().getBackground());

                                    String type = clickedTile.detectType();
                                    if (type.equals("pawn")){
                                        tile.setPawns(clickedTile.getPawns());
                                        clickedTile.getPawns().setNumberOfTurns(clickedTile.getPawns().getNumberOfTurns()+1);
                                        clickedTile.setPawns(null);

                                    }
                                    else if (type.equals("king")){
                                        tile.setKing(clickedTile.getKing());
                                        clickedTile.getKing().setNumberOfTurns(clickedTile.getKing().getNumberOfTurns()+1);
                                        clickedTile.setKing(null);

                                    }
                                    else if (type.equals("queen")){
                                        tile.setQueen(clickedTile.getQueen());
                                        clickedTile.getQueen().setNumberOfTurns(clickedTile.getQueen().getNumberOfTurns()+1);
                                        clickedTile.setQueen(null);
                                    }
                                    else if (type.equals("bishop")){
                                        tile.setBishop(clickedTile.getBishop());
                                        clickedTile.setBishop(null);
                                    }
                                    else if(type.equals("rook")){
                                        tile.setRook(clickedTile.getRook());
                                        clickedTile.setRook(null);
                                    }
                                    else {
                                        tile.setKnight(clickedTile.getKnight());
                                        clickedTile.setKnight(null);
                                    }
                                    clickedTile=null;
                                }
                                else if (clickedTile!=null){
                                    Toast.makeText(MainActivity.this, "Don't Cheat, Try Again", Toast.LENGTH_SHORT).show();
                                }
                                else{
                                    //do nothing because the user clicked on an empty space without clicking a piece before
                                }
                                setBackGroundColor();
                                playerTurn++;
                                Log.d("LOOK HERE", "");
                            }

                        }

                    });
                }
            }
    }


    /*
    * should be executed after EVERY piece move
     */
    private void setBackGroundColor() {
        for (Tile[] tiles : gameBoard){
            for (Tile tile:tiles){
              if(tile.detectType()==null){
                 int x = tile.getPosition()/10;
                  int y = tile.getPosition()%10;
                  if (x%2 == y%2){
                      tile.getButton().setBackgroundColor(Color.BLACK);
                  }
                  else{
                      tile.getButton().setBackgroundColor(Color.WHITE);
                  }
              }

            }
        }
    }

    private void calculateMovement() {
/*
* initialize onclick listener
* populate initial possible steps, does NOT exclude steps in which a piece is already on there.(see editPossibleMove)
 */
        for (Tile[] tiles :gameBoard)
            for (Tile tile:tiles){
                if (tile.detectType()!=null) {
                String type = tile.detectType();
                    if (type.equals("pawn")){
                       possibleMoves= tile.getPawns().calculatePossibleMovements(tile.getPosition());
                    }
                    else if (type.equals("king")){
                       possibleMoves= tile.getKing().calculatePossibleMovements(tile.getPosition());
                    }
                    else if (type.equals("queen")){
                        possibleMoves=tile.getQueen().calculatePossibleMovements(tile.getPosition());
                    }
                    else if (type.equals("bishop")){
                        possibleMoves=tile.getBishop().calculatePossibleMovements(tile.getPosition());
                    }
                    else if(type.equals("rook")){
                        possibleMoves=tile.getRook().calculatePossibleMovements(tile.getPosition());
                    }
                    else {
                        possibleMoves=tile.getKnight().calculatePossibleMovements(tile.getPosition());
                    }
                }
            }
    }
/*
* 1. highlight all the possible steps after eliminating those possible steps in which a piece is already there.
 */
    private void highlight() {
        editPossibleMoves();
        for (int position : possibleMoves){
            int x = position/10;
            int y = position %10;
            gameBoard[x-1][y-1].getButton().setBackgroundColor(Color.YELLOW);
        }
    }

    /*
    * the goal is to eliminate those possible steps in which a piece is already there.
     */
    private void editPossibleMoves() {
        for (int i = 0; i < possibleMoves.size(); i ++){
            int x = possibleMoves.get(i)/10;
            int y = possibleMoves.get(i)%10;

            if(possibleMoves.get(i) < 0){
                possibleMoves.remove(i);i--;continue;
            }
            if(x <= 0 || y<=0){
                possibleMoves.remove(i);i--;continue;
            }
            if (x>=8 || y >=8){
                possibleMoves.remove(i);i--;continue;
            }
            if (gameBoard[x-1][y-1].detectType()!=null){
                possibleMoves.remove(i);i--;continue;
            }

        }

    }

    private void populateGameBoard() {
        populatePawns();
        populateKings();
        populateQueens();
        populateBishops();
        populateKnight();
        populateRook();
    }

    private void populatePawns() {
        //populateBlackPawns
        for (int col = 1; col <= 8; col++){
            gameBoard[6][col-1].getButton().setBackgroundResource(R.drawable.b_pawn);
            Tile tile = gameBoard[6][col-1];
            tile.setPawns(new Pawns(true));
        }
        //populateWhitePawns
        for (int col = 1; col <= 8; col++){
            gameBoard[1][col-1].getButton().setBackgroundResource(R.drawable.w_pawn);
            Tile tile = gameBoard[1][col-1];
            tile.setPawns(new Pawns(false));
        }

    }

    private void populateKings() {
        //Populate Black Kings
        gameBoard[7][4].getButton().setBackgroundResource(R.drawable.bking);
        Tile tile = gameBoard[7][4];
        tile.setKing(new King(true));

        gameBoard[0][4].getButton().setBackgroundResource(R.drawable.wking);
        Tile tile2 = gameBoard[0][4];
        tile2.setKing(new King(false));
    }

    private void populateQueens() {
        //black queen
            gameBoard[7][3].getButton().setBackgroundResource(R.drawable.bqueen);
            Tile tile = gameBoard[7][3];
            tile.setQueen(new Queen(true));

        //white queen
            gameBoard[0][3].getButton().setBackgroundResource(R.drawable.wqueen);
            Tile tile2 = gameBoard[0][3];
            tile2.setQueen(new Queen(false));

    }

    private void populateBishops() {
        //black bishop1L
        for (int col = 3; col <= 3; col++){
            gameBoard[7][col-1].getButton().setBackgroundResource(R.drawable.b_bishop);
            Tile tile = gameBoard[7][col-1];
            tile.setBishop(new Bishop(true));
        }
        //Black Bishop 2R
        for (int col = 6; col <= 6; col++){
            gameBoard[7][col-1].getButton().setBackgroundResource(R.drawable.b_bishop);
            Tile tile = gameBoard[7][col-1];
            tile.setBishop(new Bishop(true));
        }
        //White Bishop
        for (int col = 3; col <= 3; col++){
            gameBoard[0][col-1].getButton().setBackgroundResource(R.drawable.wbishop);
            Tile tile = gameBoard[0][col-1];
            tile.setBishop(new Bishop(true));
        }
        //White Bishop
        for (int col = 6; col <= 6; col++){
            gameBoard[0][col-1].getButton().setBackgroundResource(R.drawable.wbishop);
            Tile tile = gameBoard[0][col-1];
            tile.setBishop(new Bishop(true));
        }
    }

    private void populateKnight() {
        //black knight
        for (int col = 2; col <= 2; col++){
            gameBoard[7][col-1].getButton().setBackgroundResource(R.drawable.b_knight);
            Tile tile = gameBoard[7][col-1];
            tile.setKnight(new Knight(true));
        }
        //Black knight
        for (int col = 7; col <= 7; col++){
            gameBoard[7][col-1].getButton().setBackgroundResource(R.drawable.b_knight);
            Tile tile = gameBoard[7][col-1];
            tile.setBishop(new Bishop(true));
        }
        //white knight
        for (int col = 2; col <= 2; col++){
            gameBoard[0][col-1].getButton().setBackgroundResource(R.drawable.w_knight);
            Tile tile = gameBoard[0][col-1];
            tile.setKnight(new Knight(true));
        }
        //white knight
        for (int col = 7; col <= 7; col++){
            gameBoard[0][col-1].getButton().setBackgroundResource(R.drawable.w_knight);
            Tile tile = gameBoard[0][col-1];
            tile.setBishop(new Bishop(true));
        }
    }

    private void populateRook() {
        //black rook
        for (int col = 1; col <= 1; col++){
            gameBoard[7][col-1].getButton().setBackgroundResource(R.drawable.b_rook);
            Tile tile = gameBoard[7][col-1];
            tile.setRook(new Rook(true));
        }
        //Black rook
        for (int col = 8; col <= 8; col++){
            gameBoard[7][col-1].getButton().setBackgroundResource(R.drawable.b_rook);
            Tile tile = gameBoard[7][col-1];
            tile.setBishop(new Bishop(true));
        }
        //white rook
        for (int col = 1; col <= 1; col++){
            gameBoard[0][col-1].getButton().setBackgroundResource(R.drawable.w_rook);
            Tile tile = gameBoard[0][col-1];
            tile.setRook(new Rook(true));
        }
        //white rook
        for (int col = 8; col <= 8; col++){
            gameBoard[0][col-1].getButton().setBackgroundResource(R.drawable.w_rook);
            Tile tile = gameBoard[0][col-1];
            tile.setRook(new Rook(true));
        }
    }

    private void wireGameBoard() {
        int tempTileId = 2131427415;
        for(int row = 8; row >=1;row--){

            boolean helperIsBlack;
            if (row%2==0){
                helperIsBlack=false;
            }
            else{
                helperIsBlack=true;
            }
            LinearLayout linearLayout;
            if (row==8){
                linearLayout = (LinearLayout)findViewById(R.id.row_8);
            }
            else if (row == 7){
                linearLayout = (LinearLayout)findViewById(R.id.row_7);
            }
            else if (row == 6){
                linearLayout = (LinearLayout)findViewById(R.id.row_6);
            }
            else if (row == 5){
                linearLayout = (LinearLayout)findViewById(R.id.row_5);
            }
            else if (row == 4){
                linearLayout = (LinearLayout)findViewById(R.id.row_4);
            }
            else if (row == 3){
                linearLayout = (LinearLayout)findViewById(R.id.row_3);
            }
            else if (row == 2) {
                linearLayout = (LinearLayout) findViewById(R.id.row_2);
            }
            else {
                linearLayout = (LinearLayout)findViewById(R.id.row_1);
            }

            for (int col = 1; col<=8;col++){
                final Tile tile = new Tile(row*10+col,false,tempTileId, true);
                gameBoard[row-1][col-1]=tile;
                tile.setButton((Button)linearLayout.getChildAt(col-1));

                tile.setBlack(helperIsBlack);

                helperIsBlack=!helperIsBlack;

                if (tile.isBlack()){
                    tile.getButton().setBackgroundColor(Color.BLACK);
                }
                else{
                    tile.getButton().setBackgroundColor(Color.WHITE);
                }

                tempTileId++;
            }
        }

        }


    }

