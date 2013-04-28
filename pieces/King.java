package pieces;

import java.util.ArrayList;

import chess.Board;

public class King extends Piece {

    public King(Colour colour) {
        super(colour);
    }

    public Type getType()
    {
        return Type.KING;
    }

    public String getName()
    {
        return "k";
    }

    public double getBaseStrength()
    {
        return 0.0;
    }


    public ArrayList<String> getPossibleMoves(Board board)
    {
        String from = board.findPiece(this);
        ArrayList<String> moves = new ArrayList<String>();

        for (int x=-1; x<=1; x++) {
            for (int y=-1; y<=1; y++) {
                if (board.isValidDirection(from, x, y) && !(x==0 && y==0)) {
                    moves.add(board.getMoveDirection(from, x, y));
                }
            }
        }
        return moves;
    }
}
