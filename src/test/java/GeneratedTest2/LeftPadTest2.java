package GeneratedTest2;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LeftPadTest2 {

    @Test
    void testNullString() {
        assertNull(StringUtils.leftPad(null, 5, "*"));
    }

    @Test
    void testEmptyString() {
        assertEquals("*****", StringUtils.leftPad("", 5, "*"));
    }

    @Test
    void testNoPaddingNeeded() {
        assertEquals("abc", StringUtils.leftPad("abc", 3, "*"));
        assertEquals("abc", StringUtils.leftPad("abc", 2, "*"));
    }

    @Test
    void testPaddingWithSingleChar() {
        assertEquals("***abc", StringUtils.leftPad("abc", 6, "*"));
        assertEquals("   abc", StringUtils.leftPad("abc", 6, " "));
    }

    @Test
    void testPaddingWithMultiCharPad() {
        assertEquals("xyxabc", StringUtils.leftPad("abc", 6, "xy"));
        assertEquals("12312abc", StringUtils.leftPad("abc", 8, "123"));
    }

    @Test
    void testPadStrLongerThanNeeded() {
        assertEquals("xyabc", StringUtils.leftPad("abc", 5, "xyz"));
    }

    @Test
    void testPadStrExactlyFits() {
        assertEquals("xyzabc", StringUtils.leftPad("abc", 6, "xyz"));
    }

    @Test
    void testPadStrEmptyOrNull() {
        assertEquals("   abc", StringUtils.leftPad("abc", 6, ""));
        assertEquals("   abc", StringUtils.leftPad("abc", 6, null));
    }

    @Test
    void testPadStrSameSize() {
        assertEquals("xyzabc", StringUtils.leftPad("abc", 6, "xyz"));
    }

    @Test
    void testPadSizeSmallerThanOriginal() {
        assertEquals("abcdef", StringUtils.leftPad("abcdef", 3, "*"));
    }

    @Test
    void testPadWithSpecialCharacters() {
        assertEquals("@@abc", StringUtils.leftPad("abc", 5, "@"));
        assertEquals("??abc", StringUtils.leftPad("abc", 6, "?"));
    }

    @Test
    void testLargePadding() {
        String result = StringUtils.leftPad("abc", 1000, "x");
        assertEquals(1000, result.length());
        assertTrue(result.endsWith("abc"));
    }
}
//Number of test: 12
//Number of test match:
//New test scenarios: