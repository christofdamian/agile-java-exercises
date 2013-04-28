package chess;

import java.util.ArrayList;
import java.util.Collections;
import pieces.Piece;
import pieces.Piece.Type;

public class Game {
    Board board = new Board();

    public void setup() {
        board.setPosition("a1", Piece.createBlackRook());
        board.setPosition("b1", Piece.createBlackKnight());
        board.setPosition("c1", Piece.createBlackBishop());
        board.setPosition("d1", Piece.createBlackQueen());
        board.setPosition("e1", Piece.createBlackKing());
        board.setPosition("f1", Piece.createBlackBishop());
        board.setPosition("g1", Piece.createBlackKnight());
        board.setPosition("h1", Piece.createBlackRook());

        board.setPosition("a2", Piece.createBlackPawn());
        board.setPosition("b2", Piece.createBlackPawn());
        board.setPosition("c2", Piece.createBlackPawn());
        board.setPosition("d2", Piece.createBlackPawn());
        board.setPosition("e2", Piece.createBlackPawn());
        board.setPosition("f2", Piece.createBlackPawn());
        board.setPosition("g2", Piece.createBlackPawn());
        board.setPosition("h2", Piece.createBlackPawn());

        board.setPosition("a7", Piece.createWhitePawn());
        board.setPosition("b7", Piece.createWhitePawn());
        board.setPosition("c7", Piece.createWhitePawn());
        board.setPosition("d7", Piece.createWhitePawn());
        board.setPosition("e7", Piece.createWhitePawn());
        board.setPosition("f7", Piece.createWhitePawn());
        board.setPosition("g7", Piece.createWhitePawn());
        board.setPosition("h7", Piece.createWhitePawn());

        board.setPosition("a8", Piece.createWhiteRook());
        board.setPosition("b8", Piece.createWhiteKnight());
        board.setPosition("c8", Piece.createWhiteBishop());
        board.setPosition("d8", Piece.createWhiteQueen());
        board.setPosition("e8", Piece.createWhiteKing());
        board.setPosition("f8", Piece.createWhiteBishop());
        board.setPosition("g8", Piece.createWhiteKnight());
        board.setPosition("h8", Piece.createWhiteRook());
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

    public String toString() {
        return board.toString();
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
        for (int rank=1; rank<=8; rank++) {
            ArrayList<Piece> row = board.getRank(rank);
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
        for (Piece piece: board.getAll()) {
            strength += piece.getStrength();
        }
        return strength;
    }

    private ArrayList<Piece> getPiecesStrength(boolean white)
    {
        ArrayList<Piece> list = new ArrayList<Piece>();

        calculateStrength();

        for (int rank=1; rank<=8; rank++) {
            ArrayList<Piece> row = board.getRank(rank);
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

    public ArrayList<String> getAvailableMoves(String from)
    {
        ArrayList<String> moves = new ArrayList<String>();

        Piece piece = board.getPosition(from);

        if (piece.getType()==Type.KING) {
            for (int x=-1; x<=1; x++) {
                for (int y=-1; y<=1; y++) {
                    if (board.isValidDirection(from, x, y) && !(x==0 && y==0)) {
                        moves.add(board.getMoveDirection(from, x, y));
                    }
                }
            }
        } else {
            for (int x=-1; x<=1; x++) {
                for (int y=-1; y<=1; y++) {
                    if (x!=0 || y!=0) {
                        continueDirection(moves, from, x, y);
                    }
                }
            }
        }
        return moves;
    }

    private void continueDirection(ArrayList<String> moves, String from, int x, int y) {
        if (board.isValidDirection(from, x, y)) {
            String to = board.getMoveDirection(from, x, y);
            moves.add(to);
            continueDirection(moves, to, x, y);
        }
    }
}
