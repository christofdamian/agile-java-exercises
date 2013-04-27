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
            ArrayList<Piece> row = new ArrayList<Piece>();
            pieces.add(row);
            for (int j=0; j<8; j++) {
                row.add(Piece.createEmpty());
            }
        }
    }

    public void setup() {
        createWhiteQueenRank(pieces.get(0));
        createWhitePawnRank(pieces.get(1));
        createBlackPawnRank(pieces.get(6));
        createBlackQueenRank(pieces.get(7));
    }

    private void createWhitePawnRank(ArrayList<Piece> row) {
        for (int i=0; i<8; i++) {
            row.set(i, Piece.createWhitePawn());
        }
    }
    private void createBlackPawnRank(ArrayList<Piece> row) {
        for (int i=0; i<8; i++) {
            row.set(i, Piece.createBlackPawn());
        }
    }

    private void createWhiteQueenRank(ArrayList<Piece> row) {
        row.set(0, Piece.createWhiteRook());
        row.set(1, Piece.createWhiteKnight());
        row.set(2, Piece.createWhiteBishop());
        row.set(3, Piece.createWhiteQueen());
        row.set(4, Piece.createWhiteKing());
        row.set(5, Piece.createWhiteBishop());
        row.set(6, Piece.createWhiteKnight());
        row.set(7, Piece.createWhiteRook());
    }

    private void createBlackQueenRank(ArrayList<Piece> row) {
        row.set(0, Piece.createBlackRook());
        row.set(1, Piece.createBlackKnight());
        row.set(2, Piece.createBlackBishop());
        row.set(3, Piece.createBlackQueen());
        row.set(4, Piece.createBlackKing());
        row.set(5, Piece.createBlackBishop());
        row.set(6, Piece.createBlackKnight());
        row.set(7, Piece.createBlackRook());
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
