package chess;

import java.util.ArrayList;

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


    public void testGetAvailableMovesKing()
    {
        game.board.setPosition("d5", Piece.createWhiteKing());
        ArrayList<String> moves = game.getAvailableMoves("d5");
        assertEquals(8, moves.size());
        assertFalse(moves.contains("d5"));
        assertTrue(moves.contains("c4"));
        assertTrue(moves.contains("d4"));
        assertTrue(moves.contains("e4"));
        assertTrue(moves.contains("c5"));
        assertTrue(moves.contains("e5"));
        assertTrue(moves.contains("c6"));
        assertTrue(moves.contains("d6"));
        assertTrue(moves.contains("e6"));
    }

    public void testGetAvailableMovesKingCorner()
    {
        game.board.setPosition("a1", Piece.createWhiteKing());
        ArrayList<String> moves = game.getAvailableMoves("a1");
        assertEquals(3, moves.size());
        assertTrue(moves.contains("b1"));
        assertTrue(moves.contains("b2"));
        assertTrue(moves.contains("a2"));
    }

    public void testGetAvailableMovesQueenCorner()
    {
        game.board.setPosition("a1", Piece.createWhiteQueen());
        ArrayList<String> moves = game.getAvailableMoves("a1");
        assertFalse(moves.contains("a1"));
        assertTrue(moves.contains("h1"));
        assertTrue(moves.contains("a8"));
        assertTrue(moves.contains("b2"));
        assertTrue(moves.contains("h8"));
    }

}
