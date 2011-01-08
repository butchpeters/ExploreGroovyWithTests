package Example;

import junit.framework.TestCase;

import java.lang.Exception;

public class TypicalJavaTest extends TestCase {
    public void testNumbers() throws Exception {
        assertEquals(5, 9-4);
    }
}