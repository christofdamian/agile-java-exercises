import junit.framework.TestSuite;

import chess.BoardTest;

import pieces.PieceTest;

public class AllTests {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(PieceTest.class);
        suite.addTestSuite(BoardTest.class);
        suite.addTestSuite(CharacterTest.class);
        return suite;
    }
}
