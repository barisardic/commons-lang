package org.example.GeneratedTest;

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.leftPad;

import static org.junit.jupiter.api.Assertions.*;

public class LeftPadTest {

    @Test
    void testNullInput() {
        assertNull(leftPad(null, 5, "*"), "Null input should return null");
    }

    @Test
    void testPadSizeLessThanStringLength() {
        assertEquals("Hello", leftPad("Hello", 3, "*"), "Should return original string if size is less than length");
    }

    @Test
    void testPadSizeEqualToStringLength() {
        assertEquals("Hello", leftPad("Hello", 5, "*"), "Should return original string if size equals length");
    }

    @Test
    void testPadWithNullPadStr() {
        assertEquals("   Hi", leftPad("Hi", 5, null), "Null padStr should pad with spaces");
    }

    @Test
    void testPadWithEmptyPadStr() {
        assertEquals("   Hi", leftPad("Hi", 5, ""), "Empty padStr should pad with spaces");
    }

    @Test
    void testPadWithSingleCharacterPadStr() {
        assertEquals("***Hi", leftPad("Hi", 5, "*"), "Should pad correctly with single character padStr");
    }

    @Test
    void testPadWithMultiCharacterPadStrExactlyMatchingPads() {
        assertEquals("abHi", leftPad("Hi", 4, "ab"), "Should pad exactly with padStr when pads == padStr length");
    }

    @Test
    void testPadWithMultiCharacterPadStrSmallerThanPadLength() {
        assertEquals("aHi", leftPad("Hi", 3, "ab"), "Should truncate padStr to fit");
    }

    @Test
    void testPadWithMultiCharacterPadStrLargerThanPadLength() {
        assertEquals("ababaHi", leftPad("Hi", 7, "ab"), "Should repeat padStr to fill pads");
    }

    @Test
    void testPadWithSpacePadStr() {
        assertEquals("   Hi", leftPad("Hi", 5, " "), "Should pad with spaces when padStr is space");
    }

    @Test
    void testZeroSize() {
        assertEquals("Hi", leftPad("Hi", 0, "*"), "Should return original string if size is zero");
    }

    @Test
    void testNegativeSize() {
        assertEquals("Hi", leftPad("Hi", -5, "*"), "Should return original string if size is negative");
    }

//    @Test
//    void testPadWithUnicodePadStr() {
//        assertEquals("★☆★Hi", leftPad("Hi", 5, "★☆"), "Should repeat Unicode padStr correctly");
//    }

    @Test
    void testPadWhenPadStrIsLongerThanPadsNeeded() {
        assertEquals("abHi", leftPad("Hi", 4, "abc"), "Should truncate padStr to required pad length");
    }

    @Test
    void testPadStrLongerThanString() {
        assertEquals("abcabcHi", leftPad("Hi", 8, "abc"), "Should repeat padStr to reach total size");
    }

    @Test
    void testPadWhenNoPaddingIsNeeded() {
        assertEquals("Test", leftPad("Test", 4, "x"), "Should return original string when no padding needed");
    }

    @Test
    void testPadWithDefaultSpacePad() {
        assertEquals("   Test", leftPad("Test", 7, null), "Should pad with spaces when padStr is null");
    }

}
