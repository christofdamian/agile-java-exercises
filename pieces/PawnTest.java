package pieces;

import junit.framework.TestCase;

import org.junit.Test;




public class PawnTest extends TestCase {
    @Test
    public void testCreate() {
        Pawn pawn = new Pawn(Pawn.WHITE);
        assertEquals(Pawn.WHITE, pawn.getColour());

        pawn = new Pawn(Pawn.BLACK);
        assertEquals(Pawn.BLACK, pawn.getColour());
    }

    @Test
    public void testCreateDefault() {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE, pawn.getColour());
    }

}
