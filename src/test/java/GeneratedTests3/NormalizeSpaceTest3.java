package GeneratedTests3;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NormalizeSpaceTest3 {



    @Test
    void testNullInput() {
        assertNull(StringUtils.normalizeSpace(null), "Expected null input to return null");
    }

    @Test
    void testEmptyString() {
        assertEquals("", StringUtils.normalizeSpace(""), "Expected empty string to return empty");
    }

    @Test
    void testOnlyWhitespace() {
        assertEquals("", StringUtils.normalizeSpace("    "), "Expected spaces only to return empty");
        assertEquals("", StringUtils.normalizeSpace("\t\n\r "), "Expected mixed whitespace only to return empty");
    }

    @Test
    void testLeadingAndTrailingWhitespace() {
        assertEquals("abc", StringUtils.normalizeSpace("   abc   "), "Expected leading/trailing whitespace trimmed");
    }

    @Test
    void testInternalMultipleWhitespace() {
        assertEquals("a b c", StringUtils.normalizeSpace("a     b   c"), "Expected internal whitespace normalized to one space");
    }

    @Test
    void testNoWhitespace() {
        assertEquals("abc", StringUtils.normalizeSpace("abc"), "Expected unchanged for no whitespace");
    }

    @Test
    void testTabAndNewlineWhitespace() {
        assertEquals("a b c", StringUtils.normalizeSpace("a\tb\nc"), "Expected tabs/newlines normalized to space");
    }

    @Test
    void testNonBreakingSpace() {
        char nbsp = (char) 160;
        assertEquals("a b", StringUtils.normalizeSpace("a" + nbsp + "b"), "Expected non-breaking space to be replaced with normal space");
    }

    @Test
    void testComplexMixedWhitespace() {
        String input = " \t a \n  b \r\n  c \t ";
        String expected = "a b c";
        assertEquals(expected, StringUtils.normalizeSpace(input), "Expected all types of whitespace normalized");
    }

    @Test
    void testStringWithUnicodeCharacters() {
        assertEquals("á é ñ", StringUtils.normalizeSpace("á   é   ñ"), "Expected unicode preserved and whitespace normalized");
    }

    @Test
    void testStringWithSurroundingNonBreakingSpaces() {
        char nbsp = (char) 160;
        assertEquals("x y", StringUtils.normalizeSpace(nbsp + "x" + nbsp + " " + nbsp + "y" + nbsp), "Expected surrounding nbsp converted and normalized");
    }

    @Test
    void testSingleCharacterWhitespace() {
        assertEquals("", StringUtils.normalizeSpace(" "), "Single space should return empty");
        assertEquals("", StringUtils.normalizeSpace("\t"), "Single tab should return empty");
    }

    @Test
    void testAlreadyNormalizedString() {
        assertEquals("a b c", StringUtils.normalizeSpace("a b c"), "Already normalized string should remain unchanged");
    }
}

