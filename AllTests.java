import junit.framework.TestSuite;

import chess.GameTest;

import pieces.PieceTest;

public class AllTests {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(PieceTest.class);
        suite.addTestSuite(GameTest.class);
        suite.addTestSuite(CharacterTest.class);
        return suite;
    }
}
