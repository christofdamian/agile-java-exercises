package chess;

import pieces.Piece;
import junit.framework.TestCase;

import static util.StringUtil.NEWLINE;


public class BoardTest extends TestCase {
    Board board;

    public void setUp() {
        board = new Board();
    }

    public void testNumberOfPieces() {
        board.setup();
        assertEquals(32, board.getNumberOfPieces());
        assertEquals(16, board.getNumberOfWhitePieces());
        assertEquals(16, board.getNumberOfBlackPieces());
    }

    public void testRanks() {
        board.setup();

        assertEquals("PPPPPPPP", board.getRank(2));
        assertEquals("pppppppp", board.getRank(7));
        assertEquals("rnbqkbnr", board.getRank(8));
    }

    public void testEmptyBoard() {
        assertEquals(
            "........" + NEWLINE +
            "........" + NEWLINE +
            "........" + NEWLINE +
            "........" + NEWLINE +
            "........" + NEWLINE +
            "........" + NEWLINE +
            "........" + NEWLINE +
            "........" + NEWLINE
            ,
            board.toString()
        );
    }

    public void testFullBoard() {
        board.setup();
        assertEquals(
            "RNBQKBNR" + NEWLINE +
            "PPPPPPPP" + NEWLINE +
            "........" + NEWLINE +
            "........" + NEWLINE +
            "........" + NEWLINE +
            "........" + NEWLINE +
            "pppppppp" + NEWLINE +
            "rnbqkbnr" + NEWLINE
            ,
            board.toString()
        );
    }

    public void testCountPiece()
    {
        board.setup();
        assertEquals(1, board.countPiece("q"));
        assertEquals(8, board.countPiece("P"));
    }

    public void testGetPosition()
    {
        board.setup();

        assertEquals("Q", board.getPosition("d8").toString());
        assertEquals("r", board.getPosition("h1").toString());
    }

    public void testSetPosition()
    {
        board.setPosition("c7", Piece.createBlackBishop());
        board.setPosition("a3", Piece.createWhiteKing());

        assertEquals(
                "........" + NEWLINE +
                "..b....." + NEWLINE +
                "........" + NEWLINE +
                "........" + NEWLINE +
                "........" + NEWLINE +
                "K......." + NEWLINE +
                "........" + NEWLINE +
                "........" + NEWLINE
                ,
                board.toString()
            );
    }
}
