package tests.pieces;

import java.util.ArrayList;

import pieces.Piece;

import chess.Board;

import junit.framework.TestCase;

public class PieceTest extends TestCase {

    public void testCreate() {
        Piece pawn = Piece.createWhitePawn();
        assertEquals(Piece.Colour.WHITE, pawn.getColour());

        pawn = Piece.createBlackPawn();
        assertEquals(Piece.Colour.BLACK, pawn.getColour());
    }

    public void testPrintable() {
        Piece pawn = Piece.createWhitePawn();
        assertEquals("P", pawn.toString());

        pawn = Piece.createBlackPawn();
        assertEquals("p", pawn.toString());
   }

    public void testIsWhite() {
        assertTrue(Piece.createWhitePawn().isWhite());
    }
    public void testIsBlack() {
        assertTrue(Piece.createBlackPawn().isBlack());
    }

    public void testStrength()
    {
        Piece pawn = Piece.createWhitePawn();
        assertEquals(0, pawn.getStrength(), 0.1);
        pawn.setStrength(10);
        assertEquals(10, pawn.getStrength(), 0.1);
    }

    public void testCompareTo()
    {
        Piece pawn = Piece.createWhitePawn();
        Piece king = Piece.createWhiteKing();

        pawn.setStrength(1);
        king.setStrength(2);

        assertEquals(1, pawn.compareTo(king));
        assertEquals(-1, king.compareTo(pawn));
        assertEquals(0, pawn.compareTo(pawn));
    }

    public void testGetAvailableMovesKing()
    {
        Board board = new Board();
        Piece piece = Piece.createWhiteKing();
        board.setPosition("d5", piece);
        ArrayList<String> moves = piece.getPossibleMoves(board);
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
        Piece piece = Piece.createWhiteKing();
        board.setPosition("a1", piece);
        ArrayList<String> moves = piece.getPossibleMoves(board);

        assertEquals(3, moves.size());
        assertTrue(moves.contains("b1"));
        assertTrue(moves.contains("b2"));
        assertTrue(moves.contains("a2"));
    }

    public void testGetAvailableMovesQueenCorner()
    {
        Board board = new Board();
        Piece piece = Piece.createWhiteQueen();
        board.setPosition("a1", piece);
        ArrayList<String> moves = piece.getPossibleMoves(board);

        assertFalse(moves.contains("a1"));
        assertTrue(moves.contains("h1"));
        assertTrue(moves.contains("a8"));
        assertTrue(moves.contains("b2"));
        assertTrue(moves.contains("h8"));
    }
}
