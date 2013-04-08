package pieces;

import junit.framework.TestCase;

public class PieceTest extends TestCase {

    public void testCreate() {
        Piece pawn = Piece.create(
                Piece.COLOUR_WHITE,
                Piece.TYPE_PAWN
        );
        assertEquals(Piece.COLOUR_WHITE, pawn.getColour());

        pawn = Piece.create(
                Piece.COLOUR_BLACK,
                Piece.TYPE_PAWN
        );
        assertEquals(Piece.COLOUR_BLACK, pawn.getColour());
    }

    public void testPrintable() {
        Piece pawn = Piece.create(
                Piece.COLOUR_WHITE,
                Piece.TYPE_PAWN
        );
        assertEquals("P", pawn.toString());

        pawn = Piece.create(
                Piece.COLOUR_BLACK,
                Piece.TYPE_PAWN
        );;
        assertEquals("p", pawn.toString());
   }

    public void testIsWhite() {
        assertTrue(Piece.create(Piece.COLOUR_WHITE, Piece.TYPE_PAWN).isWhite());
    }
    public void testIsBlack() {
        assertTrue(Piece.create(Piece.COLOUR_BLACK, Piece.TYPE_PAWN).isBlack());
    }
}
