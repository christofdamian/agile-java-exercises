import net.damian.First;

import org.junit.Test;

public class FirstTest extends junit.framework.TestCase {
    First object;

    protected void setUp() {
	object = new First();
    }

    @Test
    public void testNew() {
	assertNotNull(object);
    }

    @Test
    public void testConstructor() {
	assertTrue(object instanceof First);
    }

}
