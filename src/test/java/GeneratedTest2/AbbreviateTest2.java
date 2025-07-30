package GeneratedTest2;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AbbreviateTest2 {



//2,9
    @Test
    void testNullStringReturnsNull() {
        assertNull(StringUtils.abbreviate(null, "...", 0, 10));
    }
//+
    @Test
    void testEmptyAbbrevMarkerReturnsSubstring() {
        String input = "HelloWorld";
        String result = StringUtils.abbreviate(input, "", 0, 5);
        assertEquals("Hello", result);
    }
//4
    @Test
    void testEmptyStringInputReturnsInput() {
        assertEquals("", StringUtils.abbreviate("", "...", 0, 10));
    }
//+ There is nno test with o offset and 0 maxWith
    @Test
    void testEmptyAbbrevMarkerAndZeroMaxWidthReturnsEmptyString() {
        String result = StringUtils.abbreviate("Hello", "", 0, 0);
        assertEquals("", result);
    }
//8
    @Test
    void testAbbreviationNoNeedBecauseStringShortEnough() {
        String result = StringUtils.abbreviate("Short", "...", 0, 10);
        assertEquals("Short", result);
    }
//11
    @Test
    void testAbbreviationWithOffsetNearStart() {
        String result = StringUtils.abbreviate("The quick brown fox jumps", "...", 2, 10);
        assertEquals("The qui...", result);
    }
//13-16
    @Test
    void testAbbreviationWithOffsetAfterThreshold() {
        String result = StringUtils.abbreviate("The quick brown fox jumps", "...", 10, 15);
        assertEquals("...own fox jumps", result);
    }
//
    @Test
    void testAbbreviationWhenOffsetBeyondLength() {
        String result = StringUtils.abbreviate("The quick brown", "...", 50, 10);
        assertEquals("The qui...", result);
    }

    @Test
    void testAbbreviationWithOffsetTriggeringRecursion() {
        String result = StringUtils.abbreviate("abcdefghijabcdefghij", "--", 5, 12);
        assertEquals("--ghijabc--", result); // Expecting recursive application
    }

    @Test
    void testMaxWidthLessThanMinAbbrevThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                StringUtils.abbreviate("HelloWorld", "...", 0, 2)
        );
        assertTrue(ex.getMessage().contains("Minimum abbreviation width is"));
    }

    @Test
    void testMaxWidthLessThanMinAbbrevWithOffsetThrowsException() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                StringUtils.abbreviate("HelloWorld", "..", 5, 4)
        );
        assertTrue(ex.getMessage().contains("Minimum abbreviation width with offset is"));
    }

    @Test
    void testAbbreviationExactMaxWidth() {
        String input = "HelloWorld";
        assertEquals("HelloWorld", StringUtils.abbreviate(input, "...", 0, 10));
    }

    @Test
    void testAbbreviationWithAbbrevMarkerLengthEdgeCase() {
        String input = "abcdefghijk";
        String result = StringUtils.abbreviate(input, "--", 1, 5);
        assertEquals("abc--", result);
    }

    @Test
    void testOffsetAdjustedToMaxOffset() {
        String input = "abcdefghij";
        String result = StringUtils.abbreviate(input, "...", 20, 7); // offset > input.length
        assertEquals("abcd...", result);
    }

    @Test
    void testAbbreviationWithOffsetAndLargeMaxWidth() {
        String result = StringUtils.abbreviate("abcdefghijabcdefghij", "---", 7, 20);
        assertEquals("---ghijabcdefghij", result);
    }
}

//Number of test:15
//Number of test match:
//New test scenarios: