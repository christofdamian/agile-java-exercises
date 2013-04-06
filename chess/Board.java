package chess;

import java.util.ArrayList;

import pieces.Pawn;


public class Board {
    ArrayList<Pawn> pieces = new ArrayList<Pawn>();

    /**
     * Get number of pieces
     * @return
     */
    public int getNumberOfPieces() {
        return pieces.size();
    }

    /**
     * Add pawn to the board
     * @param pawn
     */
    public void addPawn(Pawn pawn) {
        pieces.add(pawn);
    }

    /**
     * Return list of pieces
     * @return
     */
    public ArrayList<Pawn> getPieces() {
        return pieces;
    }
}
