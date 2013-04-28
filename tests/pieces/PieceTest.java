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

    public void testGetAvailableMoves()
    {
        Piece piece = Piece.createEmpty();
        Board board = new Board();
        ArrayList<String> moves = piece.getPossibleMoves(board);
        assertEquals(0, moves.size());
    }
}
