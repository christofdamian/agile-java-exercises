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

    public void testGetStrength()
    {
        board.setPosition("c7", Piece.createWhiteBishop());
        assertEquals(3.0, board.getStrength(), 0.01);
        board.setPosition("a7", Piece.createWhiteQueen());
        assertEquals(12.0, board.getStrength(), 0.01);
        board.setPosition("b7", Piece.createWhiteRook());
        assertEquals(17.0, board.getStrength(), 0.01);
        board.setPosition("d7", Piece.createWhiteKnight());
        assertEquals(19.5, board.getStrength(), 0.01);

        board.setPosition("e7", Piece.createWhitePawn());
        assertEquals(20, board.getStrength(), 0.01);

        board.setPosition("a6", Piece.createWhitePawn());
        board.setPosition("b6", Piece.createWhitePawn());
        assertEquals(22, board.getStrength(), 0.01);
    }

    public void testGetWhitePiecesStrength()
    {
        board.setPosition("c7", Piece.createWhiteBishop());
        board.setPosition("a7", Piece.createWhiteQueen());
        board.setPosition("b7", Piece.createWhiteRook());
        board.setPosition("d7", Piece.createWhiteKnight());
        board.setPosition("a6", Piece.createWhitePawn());
        board.setPosition("b6", Piece.createWhitePawn());

        assertEquals(
                "[Q, R, B, N, P, P]",
                board.getWhitePiecesStrength().toString()
        );
    }

    public void testGetBlackPiecesStrength()
    {
        board.setPosition("c7", Piece.createWhiteBishop());
        board.setPosition("a7", Piece.createBlackQueen());

        assertEquals("[q]", board.getBlackPiecesStrength().toString());
    }

}
