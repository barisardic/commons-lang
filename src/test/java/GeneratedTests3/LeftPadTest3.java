package GeneratedTests3;
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.leftPad;
import static org.junit.jupiter.api.Assertions.*;
public class LeftPadTest3 {

//1
    @Test
    public void testNullInput() {
        assertNull(leftPad(null, 5, "*"));
    }

    @Test
    public void testNoPaddingNeeded() {
// 7
        assertEquals("hello", leftPad("hello", 3, "*"));
// + Testing if size equal to str length
        assertEquals("hello", leftPad("hello", 5, "*"));
    }


    @Test
    public void testPaddingWithSingleChar() {
     //4
        assertEquals("***hi", leftPad("hi", 5, "*"));
       //10
        assertEquals("   hi", leftPad("hi", 5, " "));
    }
//10
    @Test
    public void testPaddingWithEmptyPadStr() {
        assertEquals("   hi", leftPad("hi", 5, ""));
    }
//9
    @Test
    public void testPaddingWithNullPadStr() {
        assertEquals("   hi", leftPad("hi", 5, null));
    }
//5
    @Test
    public void testExactPadLength() {
        assertEquals("1234hi", leftPad("hi", 6, "1234"));
    }
//4
    @Test
    public void testPadStrShorterThanPads() {
        assertEquals("1212hi", leftPad("hi", 6, "12"));
    }
//6
    @Test
    public void testPadStrLongerThanPads() {
        assertEquals("12hi", leftPad("hi", 4, "1234"));
    }
//4
    @Test
    public void testPadStrWithSpecialCharacters() {
        assertEquals("~!~!hi", leftPad("hi", 6, "~!"));
    }

    //+ Large padding size (1,000 chars)
    @Test
    public void testVeryLargePadding() {
        String result = leftPad("x", 10000, "ab");
        assertEquals(10000, result.length());
        assertTrue(result.endsWith("x"));
    }
}
//Number of test: 12
//Number of test match: 8
//New test scenarios:2
//Number duplicate:3
