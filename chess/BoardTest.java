package chess;

import junit.framework.TestCase;

import static util.StringUtil.NEWLINE;


public class BoardTest extends TestCase {
    Board board;

    public void setUp() {
        board = new Board();
    }

    public void testNumberOfPieces() {
        assertEquals(32, board.getNumberOfPieces());
        assertEquals(16, board.getNumberOfWhitePieces());
        assertEquals(16, board.getNumberOfBlackPieces());
    }

    public void testRanks() {
        assertEquals("PPPPPPPP", board.getRank(2));
        assertEquals("pppppppp", board.getRank(7));
        assertEquals("rnbqkbnr", board.getRank(8));
    }

    public void testFullBoard() {


        assertEquals(
            "rnbqkbnr" + NEWLINE +
            "pppppppp" + NEWLINE +
            "........" + NEWLINE +
            "........" + NEWLINE +
            "........" + NEWLINE +
            "........" + NEWLINE +
            "PPPPPPPP" + NEWLINE +
            "RNBQKBNR" + NEWLINE
            ,
            board.toString()
        );
    }

    public void testCountPiece()
    {
        assertEquals(1, board.countPiece("q"));
        assertEquals(8, board.countPiece("P"));
    }

    public void testGetPosition()
    {
        assertEquals("Q", board.getPosition("d8").toString());
        assertEquals("r", board.getPosition("h1").toString());
    }
}
