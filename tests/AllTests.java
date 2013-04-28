package tests;
import junit.framework.TestSuite;


import tests.chess.BoardTest;
import tests.chess.GameTest;
import tests.pieces.KingTest;
import tests.pieces.PieceTest;
import tests.pieces.QueenTest;

public class AllTests {

    public static TestSuite suite() {
        TestSuite suite = new TestSuite();
        suite.addTestSuite(PieceTest.class);
        suite.addTestSuite(GameTest.class);
        suite.addTestSuite(BoardTest.class);
        suite.addTestSuite(KingTest.class);
        suite.addTestSuite(QueenTest.class);
        return suite;
    }
}
