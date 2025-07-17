package org.example.GeneratedTest;
import org.junit.jupiter.api.Test;

import static org.apache.commons.text.WordUtils.isDelimiter;

import static org.junit.jupiter.api.Assertions.*;
public class IsDelimiterTest {
    @Test
    public void testIsDelimiter_NullDelimiters_WhitespaceChar() {
        assertTrue(isDelimiter(' ', null));
        assertTrue(isDelimiter('\n', null));
        assertTrue(isDelimiter('\t', null));
    }

    @Test
    public void testIsDelimiter_NullDelimiters_NonWhitespaceChar() {
        assertFalse(isDelimiter('a', null));
        assertFalse(isDelimiter('1', null));
        assertFalse(isDelimiter('-', null));
    }

    @Test
    public void testIsDelimiter_CharInDelimiters() {
        char[] delimiters = {',', ';', ':'};
        assertTrue(isDelimiter(',', delimiters));
        assertTrue(isDelimiter(';', delimiters));
        assertTrue(isDelimiter(':', delimiters));
    }

    @Test
    public void testIsDelimiter_CharNotInDelimiters() {
        char[] delimiters = {',', ';', ':'};
        assertFalse(isDelimiter('.', delimiters));
        assertFalse(isDelimiter('a', delimiters));
        assertFalse(isDelimiter(' ', delimiters));
    }

    @Test
    public void testIsDelimiter_EmptyDelimiters() {
        char[] delimiters = {};
        assertFalse(isDelimiter('a', delimiters));
        assertFalse(isDelimiter(' ', delimiters));
    }

    @Test
    public void testIsDelimiter_EdgeCharacters() {
        char[] delimiters = {'\u0000', '\uFFFF'};
        assertTrue(isDelimiter('\u0000', delimiters));
        assertTrue(isDelimiter('\uFFFF', delimiters));
        assertFalse(isDelimiter('a', delimiters));
    }
}
