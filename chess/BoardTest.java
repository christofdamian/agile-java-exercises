package chess;

import junit.framework.TestCase;

import org.junit.Test;


public class BoardTest extends TestCase {
    Board board = new Board();

    @Test
    public void testNumberOfPieces() {
        assertEquals(16, board.getNumberOfPieces());
    }

    @Test
    public void testRanks() {
        assertEquals("PPPPPPPP", board.getRank(2));
        assertEquals("pppppppp", board.getRank(7));
    }

    @Test
    public void testFullBoard() {
	
	
        assertEquals(
            "........" + Board.NEWLINE +
            "pppppppp" + Board.NEWLINE +
            "........" + Board.NEWLINE +
            "........" + Board.NEWLINE +
            "........" + Board.NEWLINE +
            "........" + Board.NEWLINE +
            "PPPPPPPP" + Board.NEWLINE +
            "........" + Board.NEWLINE
            ,
            board.toString()
        );
    }

}
