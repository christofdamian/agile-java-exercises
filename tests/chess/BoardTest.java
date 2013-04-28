package tests.chess;

import chess.Board;
import pieces.Piece;
import junit.framework.TestCase;

import static util.StringUtil.NEWLINE;


public class BoardTest extends TestCase {
    Board board;

    public void setUp() {
        board = new Board();
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

    public void testGetPosition()
    {
        board.setPosition("c7", Piece.createWhiteQueen());
        assertEquals("Q", board.getPosition("c7").toString());
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

    public void testIsValidDirection()
    {
        assertTrue(board.isValidDirection("a1", 1, 1));
        assertFalse(board.isValidDirection("a1", -1, 0));
        assertFalse(board.isValidDirection("a1", -1, -1));
        assertFalse(board.isValidDirection("h8", 0, 1));
        assertFalse(board.isValidDirection("h8", 1, 0));
    }

    public void testGetMoveDirection()
    {
        assertEquals("b2", board.getMoveDirection("a1", 1, 1));
        assertEquals("b2", board.getMoveDirection("b2", 0, 0));
        assertEquals("a1", board.getMoveDirection("b2", -1, -1));
        assertEquals("e3", board.getMoveDirection("d2", 1, 1));
    }

    public void testFindPiece()
    {
        Piece piece = Piece.createBlackBishop();
        String position = "c7";
        board.setPosition(position, piece);

        assertEquals(position, board.findPiece(piece));

    }
}
