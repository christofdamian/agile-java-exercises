package pieces;

import java.util.ArrayList;

import chess.Board;

public class Queen extends Piece {

    public Queen(Colour colour) {
        super(colour);
    }

    public Type getType()
    {
        return Type.QUEEN;
    }

    public String getName()
    {
        return "q";
    }

    public double getBaseStrength()
    {
        return 9.0;
    }

    public ArrayList<String> getPossibleMoves(Board board)
    {
        String from = board.findPiece(this);
        ArrayList<String> moves = new ArrayList<String>();

        for (int x=-1; x<=1; x++) {
            for (int y=-1; y<=1; y++) {
                if (x!=0 || y!=0) {
                    continueDirection(moves, from, x, y, board);
                }
            }
        }
        return moves;
    }

    private void continueDirection(
            ArrayList<String> moves,
            String from,
            int x,
            int y,
            Board board
            ) {
        if (board.isValidDirection(from, x, y)) {
            String to = board.getMoveDirection(from, x, y);
            moves.add(to);
            continueDirection(moves, to, x, y, board);
        }
    }

}
