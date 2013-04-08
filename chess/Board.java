package chess;

import java.util.ArrayList;

import pieces.Piece;

import static util.StringUtil.NEWLINE;

public class Board {
    ArrayList<ArrayList<Piece>> pieces = new ArrayList<ArrayList<Piece>>();

    public Board() {
        initialize();
    }

    private void initialize() {
        Piece.resetCount();

        for (int i=0; i<8; i++) {
            pieces.add(new ArrayList<Piece>());
        }
        pieces.set(0, createQueenRank(Piece.COLOUR_WHITE));
        pieces.set(1, createPawnRank(Piece.COLOUR_WHITE));
        pieces.set(6, createPawnRank(Piece.COLOUR_BLACK));
        pieces.set(7, createQueenRank(Piece.COLOUR_BLACK));
    }

    private ArrayList<Piece> createPawnRank(String colour) {
        ArrayList<Piece> rank = new ArrayList<Piece>();
        for (int i=0; i<8; i++) {
            rank.add(Piece.create(colour, Piece.TYPE_PAWN));
        }
        return rank;
    }

    private ArrayList<Piece> createQueenRank(String colour) {
        ArrayList<Piece> rank = new ArrayList<Piece>();
        rank.add(Piece.create(colour, Piece.TYPE_ROOK));
        rank.add(Piece.create(colour, Piece.TYPE_KNIGHT));
        rank.add(Piece.create(colour, Piece.TYPE_BISHOP));
        rank.add(Piece.create(colour, Piece.TYPE_QUEEN));
        rank.add(Piece.create(colour, Piece.TYPE_KING));
        rank.add(Piece.create(colour, Piece.TYPE_BISHOP));
        rank.add(Piece.create(colour, Piece.TYPE_KNIGHT));
        rank.add(Piece.create(colour, Piece.TYPE_ROOK));
        return rank;
    }


    /**
     * Get number of pieces
     * @return
     */
    public int getNumberOfPieces() {
       return Piece.getPiecesInUse();
    }

    public int getNumberOfWhitePieces() {
        return Piece.getNumberOfWhitePieces();
    }

    public int getNumberOfBlackPieces() {
        return Piece.getNumberOfBlackPieces();
    }

    /**
     * Return list of pieces
     * @return
     */
    public ArrayList<ArrayList<Piece>> getPieces() {
        return pieces;
    }

    public String getRank(int rank) {
        if (pieces.get(rank-1).size()==0) {
            return "........";
        }

        StringBuilder builder = new StringBuilder();
        for (int i=0; i<8; i++) {
            builder.append(pieces.get(rank-1).get(i));
        }
        return builder.toString();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i=8; i>0; i--) {
            builder.append(getRank(i));
            builder.append(NEWLINE);
        }
        return builder.toString();
    }
}
