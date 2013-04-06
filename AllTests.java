import junit.framework.TestSuite;

import chess.BoardTest;

import pieces.PawnTest;

public class AllTests {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(PawnTest.class);
        suite.addTestSuite(BoardTest.class);
        return suite;
    }
}
