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
        pieces.set(0, createWhiteQueenRank());
        pieces.set(1, createWhitePawnRank());
        pieces.set(6, createBlackPawnRank());
        pieces.set(7, createBlackQueenRank());
    }

    private ArrayList<Piece> createWhitePawnRank() {
        ArrayList<Piece> rank = new ArrayList<Piece>();
        for (int i=0; i<8; i++) {
            rank.add(Piece.createWhitePawn());
        }
        return rank;
    }
    private ArrayList<Piece> createBlackPawnRank() {
        ArrayList<Piece> rank = new ArrayList<Piece>();
        for (int i=0; i<8; i++) {
            rank.add(Piece.createBlackPawn());
        }
        return rank;
    }

    private ArrayList<Piece> createWhiteQueenRank() {
        ArrayList<Piece> rank = new ArrayList<Piece>();
        rank.add(Piece.createWhiteRook());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteQueen());
        rank.add(Piece.createWhiteKing());
        rank.add(Piece.createWhiteBishop());
        rank.add(Piece.createWhiteKnight());
        rank.add(Piece.createWhiteRook());
        return rank;
    }

    private ArrayList<Piece> createBlackQueenRank() {
        ArrayList<Piece> rank = new ArrayList<Piece>();
        rank.add(Piece.createBlackRook());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackQueen());
        rank.add(Piece.createBlackKing());
        rank.add(Piece.createBlackBishop());
        rank.add(Piece.createBlackKnight());
        rank.add(Piece.createBlackRook());
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

    public int countPiece(String name)
    {
        int count = 0;
        for (ArrayList<Piece> row: pieces) {
            for (Piece piece: row) {
                if (piece.toString().equals(name)) {
                    count++;
                }
            }
        }
        return count;
    }

    public Piece getPosition(String position)
    {
        int column = ((int)position.charAt(0)-(int)'a');
        int row = 8-((int)position.charAt(1)-(int)'0');
        return pieces.get(row).get(column);
    }
}
