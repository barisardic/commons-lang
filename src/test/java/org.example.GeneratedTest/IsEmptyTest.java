package org.example.GeneratedTest;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class IsEmptyTest {
    @Test
    void testIsNotEmpty_withNull_shouldReturnFalse() {
        CharSequence input = null;
        boolean result = StringUtils.isNotEmpty(input);
        assertFalse(result, "Expected false for null input");
    }

    @Test
    void testIsNotEmpty_withEmptyString_shouldReturnFalse() {
        CharSequence input = "";
        boolean result = StringUtils.isNotEmpty(input);
        assertFalse(result, "Expected false for empty string");
    }

    @Test
    void testIsNotEmpty_withWhitespaceOnly_shouldReturnTrue() {
        CharSequence input = "   ";
        boolean result = StringUtils.isNotEmpty(input);
        assertTrue(result, "Expected true for whitespace-only string");
    }

    @Test
    void testIsNotEmpty_withNonEmptyString_shouldReturnTrue() {
        CharSequence input = "abc";
        boolean result = StringUtils.isNotEmpty(input);
        assertTrue(result, "Expected true for non-empty string");
    }

    @Test
    void testIsNotEmpty_withStringBuilder_shouldReturnTrue() {
        CharSequence input = new StringBuilder("test");
        boolean result = StringUtils.isNotEmpty(input);
        assertTrue(result, "Expected true for non-empty StringBuilder");
    }

    @Test
    void testIsNotEmpty_withEmptyStringBuilder_shouldReturnFalse() {
        CharSequence input = new StringBuilder();
        boolean result = StringUtils.isNotEmpty(input);
        assertFalse(result, "Expected false for empty StringBuilder");
    }

}
