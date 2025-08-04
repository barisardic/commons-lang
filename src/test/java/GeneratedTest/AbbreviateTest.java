/*
Licensed to the Apache Software Foundation (ASF) under one or more
contributor license agreements. See the NOTICE file distributed with
this work for additional information regarding copyright ownership.
The ASF licenses this file to You under the Apache License, Version 2.0
(the "License"); you may not use this file except in compliance with
the License. You may obtain a copy of the License at *
https://www.apache.org/licenses/LICENSE-2.0 *
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. */
package GeneratedTest;

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.abbreviate;
import static org.junit.jupiter.api.Assertions.*;

public class AbbreviateTest {
//2,9
    @Test
    void testNullInput() {
        assertNull(abbreviate(null, "...", 0, 5), "Null input should return null");
    }
//4
    @Test
    void testEmptyString() {
        assertEquals("", abbreviate("", "...", 0, 5), "Empty string should return empty string");
    }
//+
    @Test
    void testEmptyAbbrevMarker() {
        assertEquals("Hello", abbreviate("Hello World", "", 0, 5), "Empty abbrevMarker should truncate to maxWidth");
    }
//5
    @Test
    void testMaxWidthTooSmallThrows() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> abbreviate("Hello World", "...", 0, 2));
        assertTrue(ex.getMessage().contains("Minimum abbreviation width"));
    }
//20, 21
    @Test
    void testMaxWidthTooSmallWithOffsetThrows() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> abbreviate("Hello World", "...", 5, 5));
        assertTrue(ex.getMessage().contains("Minimum abbreviation width with offset"));
    }
//8
    @Test
    void testStringShorterThanMaxWidth() {
        assertEquals("Hi", abbreviate("Hi", "...", 0, 10), "Should return original string when shorter than maxWidth");
    }
//11
    @Test
    void testNoOffsetBasicAbbreviation() {
        assertEquals("Hel...", abbreviate("Hello World", "...", 0, 6), "Should abbreviate at start with no offset");
    }
//12
    @Test
    void testOffsetLessThanThreshold() {
        assertEquals("Hel...", abbreviate("Hello World", "...", 2, 6), "Offset <= marker + 1 should behave like no offset");
    }
//+
//    @Test
//    void testOffsetGreaterThanThreshold() {
//        assertEquals("...o W...", abbreviate("Hello World Example", "...", 5, 9), "Should abbreviate with offset and marker");
//    }
//+
//    @Test
//    void testOffsetBeyondStringLength() {
//        assertEquals("...ample", abbreviate("Hello World Example", "...", 100, 9), "Offset > length should clamp");
//    }
//13-16
    @Test
    void testOffsetAdjustsWhenRemainingTooShort() {
        assertEquals("...World", abbreviate("Hello World", "...", 6, 8), "Offset adjusts to fit abbreviation properly");
    }
//11
    @Test
    void testCustomAbbrevMarker() {
        assertEquals("Hel--", abbreviate("Hello World", "--", 0, 5), "Should use custom abbreviation marker");
    }
//8
//    @Test
//    void testSubstringAtStartWithCustomMarker() {
//        assertEquals("Hel--", abbreviate("Hello", "--", 0, 5), "Should abbreviate with custom marker correctly");
//    }

//23,24,25,26,27
    @Test
    void testOffsetEqualsStringLength() {
        assertEquals("...World", abbreviate("Hello World", "...", 20, 8), "Offset equal to length clamps to length");
    }
//11
    @Test
    void testMaxWidthEqualToMarkerPlusOne() {
        assertEquals("H-", abbreviate("Hello", "-", 0, 2), "Width equal to marker+1 should abbreviate correctly");
    }
//+ similar to 11
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

//There are 28 test on apache 18 of them also test in generated tests.
//Test 1,3,6,7,10,17,18,19,22,28 are missing.
