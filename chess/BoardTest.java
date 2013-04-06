package chess;
import java.util.ArrayList;

import junit.framework.TestCase;

import org.junit.Test;

import pieces.Pawn;



public class BoardTest extends TestCase {
    Board board = new Board();

    @Test
    public void testNumberOfPieces() {
        assertEquals(0, board.getNumberOfPieces());
    }

    @Test
    public void testAddPawn() {
        Pawn white = new Pawn(Pawn.WHITE);
        Pawn black = new Pawn(Pawn.BLACK);

        board.addPawn(white);
        assertEquals(1, board.getNumberOfPieces());

        ArrayList<Pawn> pieces = board.getPieces();

        assertEquals(white, pieces.get(0));

        board.addPawn(black);
        assertEquals(2, board.getNumberOfPieces());

        pieces = board.getPieces();
        assertEquals(white, pieces.get(0));
        assertEquals(black, pieces.get(1));

    }

}
