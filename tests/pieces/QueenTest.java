package tests.pieces;

import java.util.ArrayList;

import pieces.Queen;
import pieces.Piece.Colour;

import chess.Board;

import junit.framework.TestCase;

public class QueenTest extends TestCase {

    public void testToString() {
        Queen queen = new Queen(Colour.WHITE);
        assertEquals("Q", queen.toString());
   }

    public void testGetAvailableMoves()
    {
        Board board = new Board();
        Queen queen = new Queen(Colour.WHITE);
        board.setPosition("a1", queen);
        ArrayList<String> moves = queen.getPossibleMoves(board);

        assertFalse(moves.contains("a1"));
        assertTrue(moves.contains("h1"));
        assertTrue(moves.contains("a8"));
        assertTrue(moves.contains("b2"));
        assertTrue(moves.contains("h8"));
    }
}
