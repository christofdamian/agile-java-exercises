package chess;

import java.util.ArrayList;

import pieces.Pawn;


public class Board {
    final static int SIZE = 8;

    final static String NEWLINE = System.getProperty("line.seperaor");

    ArrayList<ArrayList<Pawn>> pieces = new ArrayList<ArrayList<Pawn>>();

    public Board() {
        initialize();
    }

    private void initialize() {
        for (int i=0; i<Board.SIZE; i++) {
            pieces.add(new ArrayList<Pawn>());
        }
        pieces.set(1, createRank(Pawn.WHITE, "P"));
        pieces.set(6, createRank(Pawn.BLACK, "p"));
    }

    private ArrayList<Pawn> createRank(String colour, String toString) {
        ArrayList<Pawn> rank = new ArrayList<Pawn>();
        for (int i=0; i<Board.SIZE; i++) {
            rank.add(new Pawn(colour, toString));
        }
        return rank;
    }

    /**
     * Get number of pieces
     * @return
     */
    public int getNumberOfPieces() {
        int number = 0;
        for (int i=0; i<Board.SIZE; i++) {
            number += pieces.get(i).size();
        }
        return number;
    }

    /**
     * Return list of pieces
     * @return
     */
    public ArrayList<ArrayList<Pawn>> getPieces() {
        return pieces;
    }

    public String getRank(int rank) {
        if (pieces.get(rank-1).size()==0) {
            return "........";
        }

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<Board.SIZE; i++) {
            builder.append(pieces.get(rank-1).get(i));
        }
        return builder.toString();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i=Board.SIZE; i>0; i--) {
            builder.append(getRank(i));
            builder.append(Board.NEWLINE);
        }
        return builder.toString();
    }
}
