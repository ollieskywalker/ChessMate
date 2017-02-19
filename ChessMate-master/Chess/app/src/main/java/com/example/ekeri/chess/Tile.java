package com.example.ekeri.chess;

import android.widget.Button;

import com.example.ekeri.chess.Pieces.Bishop;
import com.example.ekeri.chess.Pieces.King;
import com.example.ekeri.chess.Pieces.Knight;
import com.example.ekeri.chess.Pieces.Pawns;
import com.example.ekeri.chess.Pieces.Queen;
import com.example.ekeri.chess.Pieces.Rook;

/**
 * Created by ekeri on 2/18/2017.
 */

public class Tile {

    private int position;
    private boolean isOccupied;
    private Button button;
    private boolean isBlack;


    private Pawns pawns = null;
    private King king = null;
    private Queen queen = null;
    private Bishop bishop = null;
    private Knight knight = null;
    private Rook rook = null;

    private int tileId;

    public Tile(int position, boolean isOccupied, int tileId, boolean isBlack) {
        this.position = position;
        this.isOccupied = isOccupied;
        this.tileId = tileId;
        this.isBlack = isBlack;
    }

    public void setTileId(int tileId) {
        this.tileId = tileId;
    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public int getTileId() {
        return tileId;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setBlack(boolean black) {
        isBlack = black;
    }

    public Pawns getPawns() {
        return pawns;
    }

    public void setPawns(Pawns pawns) {
        this.pawns = pawns;
    }

    public King getKing() {
        return king;
    }

    public void setKing(King king) {
        this.king = king;
    }

    public Queen getQueen() {
        return queen;
    }

    public void setQueen(Queen queen) {
        this.queen = queen;
    }

    public Bishop getBishop() {
        return bishop;
    }

    public void setBishop(Bishop bishop) {
        this.bishop = bishop;
    }

    public Knight getKnight() {
        return knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    public Rook getRook() {
        return rook;
    }

    public void setRook(Rook rook) {
        this.rook = rook;
    }

    public boolean isNull() {
        boolean isNull = false;
        if (pawns == null && king == null && queen == null && bishop == null && rook == null && knight == null) {
            isNull = true;
        } else {
            isNull = false;
        }

        isOccupied = !isNull;
        return isNull;
    }

    public String detectType() {
        if (!isNull()) {
            if (pawns != null)
                return "pawn";
            if (king != null) {
                return "king";
            }
            if (queen != null) {
                return "queen";
            }
            if (bishop != null) {
                return "bishop";
            }
            if (rook != null) {
                return "rook";
            }
            if (knight!=null){
                return "knight";
            }
        }
        return null;

    }

}
