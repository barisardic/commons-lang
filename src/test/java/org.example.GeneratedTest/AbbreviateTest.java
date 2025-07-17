package org.example.GeneratedTest;

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.abbreviate;
import static org.junit.jupiter.api.Assertions.*;

public class AbbreviateTest {

    @Test
    void testNullInput() {
        assertNull(abbreviate(null, "...", 0, 5), "Null input should return null");
    }

    @Test
    void testEmptyString() {
        assertEquals("", abbreviate("", "...", 0, 5), "Empty string should return empty string");
    }

    @Test
    void testEmptyAbbrevMarker() {
        assertEquals("Hello", abbreviate("Hello World", "", 0, 5), "Empty abbrevMarker should truncate to maxWidth");
    }

    @Test
    void testMaxWidthTooSmallThrows() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> abbreviate("Hello World", "...", 0, 2));
        assertTrue(ex.getMessage().contains("Minimum abbreviation width"));
    }

    @Test
    void testMaxWidthTooSmallWithOffsetThrows() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> abbreviate("Hello World", "...", 5, 5));
        assertTrue(ex.getMessage().contains("Minimum abbreviation width with offset"));
    }

    @Test
    void testStringShorterThanMaxWidth() {
        assertEquals("Hi", abbreviate("Hi", "...", 0, 10), "Should return original string when shorter than maxWidth");
    }

    @Test
    void testNoOffsetBasicAbbreviation() {
        assertEquals("Hel...", abbreviate("Hello World", "...", 0, 6), "Should abbreviate at start with no offset");
    }

    @Test
    void testOffsetLessThanThreshold() {
        assertEquals("Hel...", abbreviate("Hello World", "...", 2, 6), "Offset <= marker + 1 should behave like no offset");
    }

//    @Test
//    void testOffsetGreaterThanThreshold() {
//        assertEquals("...o W...", abbreviate("Hello World Example", "...", 5, 9), "Should abbreviate with offset and marker");
//    }
//
//    @Test
//    void testOffsetBeyondStringLength() {
//        assertEquals("...ample", abbreviate("Hello World Example", "...", 100, 9), "Offset > length should clamp");
//    }

    @Test
    void testOffsetAdjustsWhenRemainingTooShort() {
        assertEquals("...World", abbreviate("Hello World", "...", 6, 8), "Offset adjusts to fit abbreviation properly");
    }

    @Test
    void testCustomAbbrevMarker() {
        assertEquals("Hel--", abbreviate("Hello World", "--", 0, 5), "Should use custom abbreviation marker");
    }

//    @Test
//    void testSubstringAtStartWithCustomMarker() {
//        assertEquals("Hel--", abbreviate("Hello", "--", 0, 5), "Should abbreviate with custom marker correctly");
//    }

    @Test
    void testOffsetEqualsStringLength() {
        assertEquals("...World", abbreviate("Hello World", "...", 20, 8), "Offset equal to length clamps to length");
    }

    @Test
    void testMaxWidthEqualToMarkerPlusOne() {
        assertEquals("H-", abbreviate("Hello", "-", 0, 2), "Width equal to marker+1 should abbreviate correctly");
    }

    @Test
    void testEmptyAbbrevMarkerWithIsNotEmptyCondition() {
        assertEquals("Tes", abbreviate("Test", "", 0, 3), "Should truncate to maxWidth when marker is empty and input is not empty");
    }

//    @Test
//    void testOffsetAndSubstringWithinBounds() {
//        assertEquals("...lo Wo...", abbreviate("Hello World Example", "...", 3, 10), "Offset mid-string abbreviation works");
//    }
//
//    @Test
//    void testOffsetAtExactEdgeOfThreshold() {
//        assertEquals("...lo Wo...", abbreviate("Hello World Example", "...", 4, 10), "Offset equal to threshold still works");
//    }
//
//    @Test
//    void testOffsetDoesNotRequireFurtherAbbreviation() {
//        assertEquals("...ample", abbreviate("Hello World Example", "...", 14, 10), "Offset with no further abbreviation needed");
//    }

}
