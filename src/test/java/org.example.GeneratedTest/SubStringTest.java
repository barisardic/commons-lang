package org.example.GeneratedTest;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SubStringTest {



    // Reference to the EMPTY constant (as in the original code)
    private static final String EMPTY = "";

    @Test
    public void testNullInput() {
        assertNull(StringUtils.substring(null, 0, 5));
        assertNull(StringUtils.substring(null, -3, -1));
    }

    @Test
    public void testNormalSubstring() {
        assertEquals("ell", StringUtils.substring("hello", 1, 4));
        assertEquals("hello", StringUtils.substring("hello", 0, 5));
        assertEquals("", StringUtils.substring("hello", 2, 2));
    }

    @Test
    public void testNegativeStartAndEnd() {
        assertEquals("ll", StringUtils.substring("hello", -3, -1));
        assertEquals("o", StringUtils.substring("hello", -1, 5));
        assertEquals("lo", StringUtils.substring("hello", -2, 5));
    }

    @Test
    public void testNegativeStartOnly() {
        assertEquals("lo", StringUtils.substring("hello", -2, 5));
        assertEquals("hello", StringUtils.substring("hello", -5, 5));
    }

    @Test
    public void testNegativeEndOnly() {
        assertEquals("he", StringUtils.substring("hello", 0, -3));
        assertEquals("hel", StringUtils.substring("hello", 0, -2));
    }

    @Test
    public void testStartGreaterThanEnd() {
        assertEquals(EMPTY, StringUtils.substring("hello", 4, 2));
        assertEquals(EMPTY, StringUtils.substring("hello", -1, -4));
    }

    @Test
    public void testStartAndEndOutOfBounds() {
        assertEquals("hello", StringUtils.substring("hello", -10, 50));
        assertEquals("llo", StringUtils.substring("hello", 2, 10));
        assertEquals("hello", StringUtils.substring("hello", -10, 5));
    }

    @Test
    public void testNegativeEndGoesTooFar() {
        assertEquals(EMPTY, StringUtils.substring("hello", 3, -10));
    }

    @Test
    public void testEmptyString() {
        assertEquals("", StringUtils.substring("", 0, 1));
        assertEquals("", StringUtils.substring("", -1, -1));
        assertEquals("", StringUtils.substring("", 0, 0));
    }
}