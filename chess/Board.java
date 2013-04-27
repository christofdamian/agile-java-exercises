package chess;

import java.util.ArrayList;
import java.util.Collections;

import pieces.Piece;
import pieces.Piece.Type;

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
        createBlackQueenRank(pieces.get(0));
        createBlackPawnRank(pieces.get(1));
        createWhitePawnRank(pieces.get(6));
        createWhiteQueenRank(pieces.get(7));
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
        StringBuilder builder = new StringBuilder();
        for (int i=0; i<8; i++) {
            builder.append(pieces.get(8-rank).get(i));
        }
        return builder.toString();
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i=1; i<=8; i++) {
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

    private int getRowFromPosition(String position)
    {
        return (int)position.charAt(1)-(int)'1';
    }

    private int getColumnFromPosition(String position)
    {
        return ((int)position.charAt(0)-(int)'a');
    }

    public Piece getPosition(String position)
    {
        int column = getColumnFromPosition(position);
        int row = getRowFromPosition(position);
        return pieces.get(row).get(column);
    }

    public void setPosition(String position, Piece piece)
    {
        int column = getColumnFromPosition(position);
        int row = getRowFromPosition(position);

        pieces.get(row).set(column, piece);
    }

    private int countPieces(ArrayList<Piece> row, Piece search)
    {
        int count = 0;
        for (Piece piece: row) {
            if (piece.toString().equals(search.toString())) {
                count++;
            }
        }
        return count;
    }

    public void calculateStrength()
    {
        for (ArrayList<Piece> row: pieces) {
            for (Piece piece: row) {
                piece.setStrength(piece.getType().getStrength());
                if (piece.getType()==Type.PAWN && countPieces(row, piece)>1) {
                    piece.setStrength(1);
                }
            }
        }
    }

    public double getStrength()
    {
        calculateStrength();

        double strength = 0;
        for (ArrayList<Piece> row: pieces) {
            for (Piece piece: row) {
                strength += piece.getStrength();
            }
        }
        return strength;
    }

    private ArrayList<Piece> getPiecesStrength(boolean white)
    {
        ArrayList<Piece> list = new ArrayList<Piece>();

        calculateStrength();

        for (ArrayList<Piece> row: pieces) {
            for (Piece piece: row) {
                if (piece.isWhite() == white && piece.isBlack() != white) {
                    list.add(piece);
                }
            }
        }
        Collections.sort(list);
        return list;
    }

    public ArrayList<Piece> getWhitePiecesStrength()
    {
        return getPiecesStrength(true);
    }

    public ArrayList<Piece> getBlackPiecesStrength()
    {
        return getPiecesStrength(false);
    }
}
