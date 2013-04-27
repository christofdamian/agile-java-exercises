package pieces;

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
}
