package chess;

import pieces.Piece;
import junit.framework.TestCase;

import static util.StringUtil.NEWLINE;


public class GameTest extends TestCase {
    Game game;

    public void setUp() {
        game = new Game();
    }

    public void testNumberOfPieces() {
        game.setup();
        assertEquals(32, game.getNumberOfPieces());
        assertEquals(16, game.getNumberOfWhitePieces());
        assertEquals(16, game.getNumberOfBlackPieces());
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
            game.toString()
        );
    }

    public void testFullBoard() {
        game.setup();
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
            game.toString()
        );
    }

    public void testGetStrength()
    {
        game.board.setPosition("c7", Piece.createWhiteBishop());
        assertEquals(3.0, game.getStrength(), 0.01);
        game.board.setPosition("a7", Piece.createWhiteQueen());
        assertEquals(12.0, game.getStrength(), 0.01);
        game.board.setPosition("b7", Piece.createWhiteRook());
        assertEquals(17.0, game.getStrength(), 0.01);
        game.board.setPosition("d7", Piece.createWhiteKnight());
        assertEquals(19.5, game.getStrength(), 0.01);

        game.board.setPosition("e7", Piece.createWhitePawn());
        assertEquals(20, game.getStrength(), 0.01);

        game.board.setPosition("a6", Piece.createWhitePawn());
        game.board.setPosition("b6", Piece.createWhitePawn());
        assertEquals(22, game.getStrength(), 0.01);
    }

    public void testGetWhitePiecesStrength()
    {
        game.board.setPosition("c7", Piece.createWhiteBishop());
        game.board.setPosition("a7", Piece.createWhiteQueen());
        game.board.setPosition("b7", Piece.createWhiteRook());
        game.board.setPosition("d7", Piece.createWhiteKnight());
        game.board.setPosition("a6", Piece.createWhitePawn());
        game.board.setPosition("b6", Piece.createWhitePawn());

        assertEquals(
                "[Q, R, B, N, P, P]",
                game.getWhitePiecesStrength().toString()
        );
    }

    public void testGetBlackPiecesStrength()
    {
        game.board.setPosition("c7", Piece.createWhiteBishop());
        game.board.setPosition("a7", Piece.createBlackQueen());

        assertEquals("[q]", game.getBlackPiecesStrength().toString());
    }

    public void testCheckKingMove()
    {
        assertTrue(game.checkKingMove("d5", "e5"));
        assertTrue(game.checkKingMove("d5", "d6"));
        assertTrue(game.checkKingMove("d5", "e6"));
        assertTrue(game.checkKingMove("d5", "c4"));

        assertFalse(game.checkKingMove("d5", "d5"));
        assertFalse(game.checkKingMove("d5", "c7"));
        assertFalse(game.checkKingMove("d5", "a5"));
    }
}
