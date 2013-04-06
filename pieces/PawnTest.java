package pieces;

import junit.framework.TestCase;

import org.junit.Test;




public class PawnTest extends TestCase {
    @Test
    public void testCreate() {
        Pawn pawn = new Pawn(Pawn.WHITE, "P");
        assertEquals(Pawn.WHITE, pawn.getColour());

        pawn = new Pawn(Pawn.BLACK, "p");
        assertEquals(Pawn.BLACK, pawn.getColour());
    }

    @Test
    public void testCreateDefault() {
        Pawn pawn = new Pawn();
        assertEquals(Pawn.WHITE, pawn.getColour());
    }


   @Test
   public void testPrintable() {
       Pawn pawn = new Pawn(Pawn.WHITE, "P");
       assertEquals("P", pawn.toString());

       pawn = new Pawn(Pawn.BLACK, "p");
       assertEquals("p", pawn.toString());

   }
}
