package org.example.GeneratedTest;

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.chop;

import static org.junit.jupiter.api.Assertions.*;

public class ChopTest {

    @Test
    void testNullInput() {
        assertNull(chop(null), "Null input should return null");
    }

    @Test
    void testEmptyString() {
        assertEquals("", chop(""), "Empty string should return empty string");
    }

    @Test
    void testSingleCharacterString() {
        assertEquals("", chop("A"), "Single character string should return empty string");
    }

    @Test
    void testTwoCharacterString() {
        assertEquals("A", chop("AB"), "Two character string should return first character");
    }

    @Test
    void testNormalString() {
        assertEquals("Hell", chop("Hello"), "Chop should remove last character");
    }

    @Test
    void testStringWithCRLF() {
        assertEquals("Hello", chop("Hello\r\n"), "CRLF ending should remove both characters");
    }

    @Test
    void testStringWithLFOnly() {
        assertEquals("Hello", chop("Hello\n"), "LF ending should remove only LF");
    }

    @Test
    void testStringWithCROnly() {
        assertEquals("Hello", chop("Hello\r"), "CR only should be treated as normal character");
    }

    @Test
    void testStringWithMultipleCRLFSequences() {
        assertEquals("Line1\r\nLine2", chop("Line1\r\nLine2\r\n"), "Should only chop last CRLF");
    }

    @Test
    void testStringWithTrailingWhitespace() {
        assertEquals("Hello ", chop("Hello  "), "Should chop only one character");
    }
}
