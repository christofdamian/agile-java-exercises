import static org.junit.Assert.*;

import org.junit.Test;


public class CharacterTest {

    @Test
    public void testWhitespace() {
        assertTrue(Character.isWhitespace(' '));
        assertTrue(Character.isWhitespace('\n'));
        assertTrue(Character.isWhitespace('\t'));
        assertTrue(Character.isWhitespace('\r'));
    }

    @Test
    public void testIdentifier() {
        assertTrue(Character.isJavaIdentifierPart('$'));

        String test$ = "dollar";

        assertEquals("dollar", test$);
    }
}
