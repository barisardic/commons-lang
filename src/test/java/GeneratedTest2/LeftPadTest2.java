package GeneratedTest2;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeftPadTest2 {
//1
    @Test
    void testNullString() {
        assertNull(StringUtils.leftPad(null, 5, "*"));
    }
//+
    @Test
    void testEmptyString() {
        assertEquals("*****", StringUtils.leftPad("", 5, "*"));
    }

    @Test
    void testNoPaddingNeeded() {

// + Testing if size equal to str length
        assertEquals("abc", StringUtils.leftPad("abc", 3, "*"));

//7
        assertEquals("abc", StringUtils.leftPad("abc", 2, "*"));
    }

    @Test
    void testPaddingWithSingleChar() {

//4
        assertEquals("***abc", StringUtils.leftPad("abc", 6, "*"));

//10
        assertEquals("   abc", StringUtils.leftPad("abc", 6, " "));
    }

    @Test
    void testPaddingWithMultiCharPad() {
        //6
        assertEquals("xyxabc", StringUtils.leftPad("abc", 6, "xy"));
        //6
        assertEquals("12312abc", StringUtils.leftPad("abc", 8, "123"));
    }
//6
    @Test
    void testPadStrLongerThanNeeded() {
        assertEquals("xyabc", StringUtils.leftPad("abc", 5, "xyz"));
    }
//5
    @Test
    void testPadStrExactlyFits() {
        assertEquals("xyzabc", StringUtils.leftPad("abc", 6, "xyz"));
    }

    @Test
    void testPadStrEmptyOrNull() {
        //10
        assertEquals("   abc", StringUtils.leftPad("abc", 6, ""));
        //9
        assertEquals("   abc", StringUtils.leftPad("abc", 6, null));
    }
//5
    @Test
    void testPadStrSameSize() {
        assertEquals("xyzabc", StringUtils.leftPad("abc", 6, "xyz"));
    }
//7
    @Test
    void testPadSizeSmallerThanOriginal() {
        assertEquals("abcdef", StringUtils.leftPad("abcdef", 3, "*"));
    }


    @Test
    void testPadWithSpecialCharacters() {
        //+ Testing Special Characters
        assertEquals("@@abc", StringUtils.leftPad("abc", 5, "@"));
        //Duplicate
        assertEquals("??abc", StringUtils.leftPad("abc", 6, "?"));
    }
//+ Large padding size (1,000 chars)
    @Test
    void testLargePadding() {
        String result = StringUtils.leftPad("abc", 1000, "x");
        assertEquals(1000, result.length());
        assertTrue(result.endsWith("abc"));
    }
}
//Number of test: 12
//Number of test match:8
//New test scenarios:3
//Number of apache test:10
//duplicate:4