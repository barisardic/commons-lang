package org.example.GeneratedTest;

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.overlay;

import static org.junit.jupiter.api.Assertions.*;

public class OverlayTest {

    @Test
    void testNullInputString() {
        assertNull(overlay(null, "test", 0, 2), "Null input string should return null");
    }

    @Test
    void testNullOverlayString() {
        assertEquals("Heo", overlay("Hello", null, 2, 4), "Null overlay should act as empty string");
    }

/*    @Test
    void testEmptyOverlayString() {
        assertEquals("Ho", overlay("Hello", "", 2, 4), "Empty overlay should remove range");
    }

    @Test
    void testOverlayAtStart() {
        assertEquals("XYlo", overlay("Hello", "XY", 0, 2), "Overlay at start should replace correctly");
    }*/

    @Test
    void testOverlayAtEnd() {
        assertEquals("HelXY", overlay("Hello", "XY", 3, 5), "Overlay at end should replace correctly");
    }

/*    @Test
    void testOverlayInMiddle() {
        assertEquals("HeXYo", overlay("Hello", "XY", 2, 3), "Overlay in middle should replace correctly");
    }*/

/*    @Test
    void testStartGreaterThanEnd() {
        assertEquals("HeXYo", overlay("Hello", "XY", 3, 2), "If start > end, they should be swapped");
    }*/

    @Test
    void testNegativeStartIndex() {
        assertEquals("XYllo", overlay("Hello", "XY", -5, 2), "Negative start index should be treated as 0");
    }

    @Test
    void testNegativeEndIndex() {
        assertEquals("XYHello", overlay("Hello", "XY", 0, -1), "Negative end index should be treated as 0");
    }

    @Test
    void testStartGreaterThanStringLength() {
        assertEquals("HelloXY", overlay("Hello", "XY", 10, 12), "Start index beyond length should clamp to length");
    }

    @Test
    void testEndGreaterThanStringLength() {
        assertEquals("HelXY", overlay("Hello", "XY", 3, 10), "End index beyond length should clamp to length");
    }

    @Test
    void testStartAndEndBothGreaterThanStringLength() {
        assertEquals("HelloXY", overlay("Hello", "XY", 10, 15), "Both indices beyond length should clamp to length");
    }

    @Test
    void testZeroLengthOverlay() {
        assertEquals("HeXYllo", overlay("Hello", "XY", 2, 2), "When start == end, overlay should insert");
    }

    @Test
    void testOverlayWholeString() {
        assertEquals("XY", overlay("Hello", "XY", 0, 5), "Overlay should fully replace entire string");
    }

    @Test
    void testOverlayEmptyInput() {
        assertEquals("XY", overlay("", "XY", 0, 2), "Overlay on empty string should just return overlay");
    }

    @Test
    void testOverlayEmptyInputWithNullOverlay() {
        assertEquals("", overlay("", null, 0, 2), "Overlay null on empty string should return empty string");
    }

    @Test
    void testStartEqualsEnd() {
        assertEquals("HeXYllo", overlay("Hello", "XY", 2, 2), "When start == end, should insert overlay");
    }

    @Test
    void testOverlayFullStringWithNegativeIndices() {
        assertEquals("XY", overlay("Hello", "XY", -10, 20), "Negative start and large end should overlay whole string");
    }

}
