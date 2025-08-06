package GeneratedTests3;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NormalizeSpaceTest3 {


//2
    @Test
    void testNullInput() {
        assertNull(StringUtils.normalizeSpace(null), "Expected null input to return null");
    }
//3
    @Test
    void testEmptyString() {
        assertEquals("", StringUtils.normalizeSpace(""), "Expected empty string to return empty");
    }


    @Test
    void testOnlyWhitespace() {
        //4
        assertEquals("", StringUtils.normalizeSpace("    "), "Expected spaces only to return empty");
        //5,6,15
        assertEquals("", StringUtils.normalizeSpace("\t\n\r "), "Expected mixed whitespace only to return empty");
    }
//16
    @Test
    void testLeadingAndTrailingWhitespace() {
        assertEquals("abc", StringUtils.normalizeSpace("   abc   "), "Expected leading/trailing whitespace trimmed");
    }
//17
    @Test
    void testInternalMultipleWhitespace() {
        assertEquals("a b c", StringUtils.normalizeSpace("a     b   c"), "Expected internal whitespace normalized to one space");
    }
//+ Testing Single word without whitespace
    @Test
    void testNoWhitespace() {
        assertEquals("abc", StringUtils.normalizeSpace("abc"), "Expected unchanged for no whitespace");
    }
//5,6
    @Test
    void testTabAndNewlineWhitespace() {
        assertEquals("a b c", StringUtils.normalizeSpace("a\tb\nc"), "Expected tabs/newlines normalized to space");
    }
//+
    @Test
    void testNonBreakingSpace() {
        char nbsp = (char) 160;
        assertEquals("a b", StringUtils.normalizeSpace("a" + nbsp + "b"), "Expected non-breaking space to be replaced with normal space");
    }
//5,6,15
    @Test
    void testComplexMixedWhitespace() {
        String input = " \t a \n  b \r\n  c \t ";
        String expected = "a b c";
        assertEquals(expected, StringUtils.normalizeSpace(input), "Expected all types of whitespace normalized");
    }
//17
    @Test
    void testStringWithUnicodeCharacters() {
        assertEquals("á é ñ", StringUtils.normalizeSpace("á   é   ñ"), "Expected unicode preserved and whitespace normalized");
    }
//+
    @Test
    void testStringWithSurroundingNonBreakingSpaces() {
        char nbsp = (char) 160;
        assertEquals("x y", StringUtils.normalizeSpace(nbsp + "x" + nbsp + " " + nbsp + "y" + nbsp), "Expected surrounding nbsp converted and normalized");
    }

    @Test
    void testSingleCharacterWhitespace() {
        //4
        assertEquals("", StringUtils.normalizeSpace(" "), "Single space should return empty");
        //5
        assertEquals("", StringUtils.normalizeSpace("\t"), "Single tab should return empty");
    }
//16
    @Test
    void testAlreadyNormalizedString() {
        assertEquals("a b c", StringUtils.normalizeSpace("a b c"), "Already normalized string should remain unchanged");
    }
}
//Number of test:13
//Number of test match:8
//New test scenarios:3
//Number duplicate:9

