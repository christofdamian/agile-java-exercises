package tests.chess;

import chess.Game;
import pieces.Piece;
import junit.framework.TestCase;

import static util.StringUtil.NEWLINE;


public class GameTest extends TestCase {
    Game game;

    public void setUp() {
        game = new Game();
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
        game.setPosition("c7", Piece.createWhiteBishop());
        assertEquals(3.0, game.getStrength(), 0.01);
        game.setPosition("a7", Piece.createWhiteQueen());
        assertEquals(12.0, game.getStrength(), 0.01);
        game.setPosition("b7", Piece.createWhiteRook());
        assertEquals(17.0, game.getStrength(), 0.01);
        game.setPosition("d7", Piece.createWhiteKnight());
        assertEquals(19.5, game.getStrength(), 0.01);

        game.setPosition("e7", Piece.createWhitePawn());
        assertEquals(20, game.getStrength(), 0.01);

        game.setPosition("a6", Piece.createWhitePawn());
        game.setPosition("b6", Piece.createWhitePawn());
        assertEquals(22, game.getStrength(), 0.01);
    }

    public void testGetWhitePiecesStrength()
    {
        game.setPosition("c7", Piece.createWhiteBishop());
        game.setPosition("a7", Piece.createWhiteQueen());
        game.setPosition("b7", Piece.createWhiteRook());
        game.setPosition("d7", Piece.createWhiteKnight());
        game.setPosition("a6", Piece.createWhitePawn());
        game.setPosition("b6", Piece.createWhitePawn());

        assertEquals(
                "[Q, R, B, N, P, P]",
                game.getWhitePiecesStrength().toString()
        );
    }

    public void testGetBlackPiecesStrength()
    {
        game.setPosition("c7", Piece.createWhiteBishop());
        game.setPosition("a7", Piece.createBlackQueen());

        assertEquals("[q]", game.getBlackPiecesStrength().toString());
    }

}
