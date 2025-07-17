package org.example.GeneratedTest;

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.repeat;

import static org.junit.jupiter.api.Assertions.*;

public class RepeatTest {

    @Test
    void testNullInput() {
        assertNull(repeat(null, 5), "Null input should return null");
    }

    @Test
    void testZeroCount() {
        assertEquals("", repeat("abc", 0), "Zero count should return empty string");
    }

    @Test
    void testNegativeCount() {
        assertEquals("", repeat("abc", -3), "Negative count should be treated as zero and return empty string");
    }

    @Test
    void testEmptyString() {
        assertEquals("", repeat("", 5), "Empty string should always return empty string");
    }

    @Test
    void testCountOne() {
        assertEquals("abc", repeat("abc", 1), "Count of one should return original string");
    }

    @Test
    void testSingleCharacterString() {
        assertEquals("aaaaa", repeat("a", 5), "Single character should repeat correctly");
    }

    @Test
    void testTwoCharacterString() {
        assertEquals("ababab", repeat("ab", 3), "Two character string should repeat correctly");
    }

    @Test
    void testMultiCharacterString() {
        assertEquals("abcabcabc", repeat("abc", 3), "Multi character string should repeat correctly");
    }

    @Test
    void testCountLarge() {
        String repeated = repeat("x", 1000);
        assertNotNull(repeated, "Result should not be null for large count");
        assertEquals(1000, repeated.length(), "Length should match input length times count");
    }

    @Test
    void testSingleCharacterAtPadLimit() {
        final int PAD_LIMIT = 8192; // Typically the limit in Commons Lang
        String repeated = repeat("a", PAD_LIMIT);
        assertNotNull(repeated);
        assertEquals(PAD_LIMIT, repeated.length(), "Should handle count equal to PAD_LIMIT");
    }

    @Test
    void testSingleCharacterAbovePadLimit() {
        final int PAD_LIMIT = 8192; // Typically the limit in Commons Lang
        String repeated = repeat("a", PAD_LIMIT + 1);
        assertNotNull(repeated);
        assertEquals(PAD_LIMIT + 1, repeated.length(), "Should handle count above PAD_LIMIT");
    }

    @Test
    void testWhitespaceString() {
        assertEquals("     ", repeat(" ", 5), "Whitespace string should repeat correctly");
    }

    @Test
    void testUnicodeCharacter() {
        assertEquals("ééééé", repeat("é", 5), "Unicode single char should repeat correctly");
    }

    @Test
    void testUnicodeString() {
        assertEquals("你好你好你好", repeat("你好", 3), "Unicode multi-char string should repeat correctly");
    }

    @Test
    void testRepeatSameReference() {
        String input = "test";
        String result = repeat(input, 1);
        assertSame(input, result, "If count is one, should return same reference");
    }

    @Test
    void testRepeatSingleCharacterIsOptimized() {
        assertEquals("zzz", repeat("z", 3), "Single character repeat should be optimized");
    }

    @Test
    void testRepeatTwoCharacterIsOptimized() {
        assertEquals("xyxyxyxy", repeat("xy", 4), "Two character repeat should be optimized");
    }

    @Test
    void testRepeatMultiCharacterFallback() {
        assertEquals("abcdabcd", repeat("abcd", 2), "Multi character repeat should use StringBuilder fallback");
    }

}
