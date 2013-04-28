package tests.pieces;

import java.util.ArrayList;

import pieces.King;
import pieces.Piece.Colour;

import chess.Board;

import junit.framework.TestCase;

public class KingTest extends TestCase {

    public void testToString() {
        King king = new King(Colour.BLACK);
        assertEquals("k", king.toString());
    }

    public void testGetAvailableMovesKing()
    {
        Board board = new Board();
        King king = new King(Colour.BLACK);
        board.setPosition("d5", king);
        ArrayList<String> moves = king.getPossibleMoves(board);
        assertEquals(8, moves.size());
        assertFalse(moves.contains("d5"));
        assertTrue(moves.contains("c4"));
        assertTrue(moves.contains("d4"));
        assertTrue(moves.contains("e4"));
        assertTrue(moves.contains("c5"));
        assertTrue(moves.contains("e5"));
        assertTrue(moves.contains("c6"));
        assertTrue(moves.contains("d6"));
        assertTrue(moves.contains("e6"));
    }

    public void testGetAvailableMovesKingCorner()
    {
        Board board = new Board();
        King king = new King(Colour.BLACK);
        board.setPosition("a1", king);
        ArrayList<String> moves = king.getPossibleMoves(board);

        assertEquals(3, moves.size());
        assertTrue(moves.contains("b1"));
        assertTrue(moves.contains("b2"));
        assertTrue(moves.contains("a2"));
    }

    public void testGetBaseStrength()
    {
        King king = new King(Colour.BLACK);
        assertEquals(0.0, king.getBaseStrength());
    }
}
