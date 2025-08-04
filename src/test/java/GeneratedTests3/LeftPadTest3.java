package GeneratedTests3;
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.leftPad;
import static org.junit.jupiter.api.Assertions.*;
public class LeftPadTest3 {
    @Test
    public void testNullInput() {
        assertNull(leftPad(null, 5, "*"));
    }

    @Test
    public void testNoPaddingNeeded() {
        assertEquals("hello", leftPad("hello", 3, "*"));
        assertEquals("hello", leftPad("hello", 5, "*"));
    }

    @Test
    public void testPaddingWithSingleChar() {
        assertEquals("***hi", leftPad("hi", 5, "*"));
        assertEquals("   hi", leftPad("hi", 5, " "));
    }

    @Test
    public void testPaddingWithEmptyPadStr() {
        assertEquals("   hi", leftPad("hi", 5, ""));
    }

    @Test
    public void testPaddingWithNullPadStr() {
        assertEquals("   hi", leftPad("hi", 5, null));
    }

    @Test
    public void testExactPadLength() {
        assertEquals("1234hi", leftPad("hi", 6, "1234"));
    }

    @Test
    public void testPadStrShorterThanPads() {
        assertEquals("1212hi", leftPad("hi", 6, "12"));
    }

    @Test
    public void testPadStrLongerThanPads() {
        assertEquals("12hi", leftPad("hi", 4, "1234"));
    }

    @Test
    public void testPadStrWithSpecialCharacters() {
        assertEquals("~!~!hi", leftPad("hi", 6, "~!"));
    }

    @Test
    public void testVeryLargePadding() {
        String result = leftPad("x", 10000, "ab");
        assertEquals(10000, result.length());
        assertTrue(result.endsWith("x"));
    }
}
