import junit.framework.TestCase;


public class CharacterTest extends TestCase {

    public void testWhitespace() {
        assertTrue(Character.isWhitespace(' '));
        assertTrue(Character.isWhitespace('\n'));
        assertTrue(Character.isWhitespace('\t'));
        assertTrue(Character.isWhitespace('\r'));
    }

    public void testIdentifier() {
        assertTrue(Character.isJavaIdentifierPart('$'));

        String test$ = "dollar";

        assertEquals("dollar", test$);
    }
}
