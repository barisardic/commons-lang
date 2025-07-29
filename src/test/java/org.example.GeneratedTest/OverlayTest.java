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
package org.example.GeneratedTest;

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.overlay;

import static org.junit.jupiter.api.Assertions.*;

public class OverlayTest {

//+
    @Test
    void testNullInputString() {
        assertNull(overlay(null, "test", 0, 2), "Null input string should return null");
    }
//8
    @Test
    void testNullOverlayString() {
        assertEquals("Heo", overlay("Hello", null, 2, 4), "Null overlay should act as empty string");
    }

//10
/*    @Test
    void testEmptyOverlayString() {
        assertEquals("Ho", overlay("Hello", "", 2, 4), "Empty overlay should remove range");
    }
//12 or 14 partially
    @Test
    void testOverlayAtStart() {
        assertEquals("XYlo", overlay("Hello", "XY", 0, 2), "Overlay at start should replace correctly");
    }*/
//18
    @Test
    void testOverlayAtEnd() {
        assertEquals("HelXY", overlay("Hello", "XY", 3, 5), "Overlay at end should replace correctly");
    }
//12
/*    @Test
    void testOverlayInMiddle() {
        assertEquals("HeXYo", overlay("Hello", "XY", 2, 3), "Overlay in middle should replace correctly");
    }*/
//13
/*    @Test
    void testStartGreaterThanEnd() {
        assertEquals("HeXYo", overlay("Hello", "XY", 3, 2), "If start > end, they should be swapped");
    }*/
//14
    @Test
    void testNegativeStartIndex() {
        assertEquals("XYllo", overlay("Hello", "XY", -5, 2), "Negative start index should be treated as 0");
    }
//15
    @Test
    void testNegativeEndIndex() {
        assertEquals("XYHello", overlay("Hello", "XY", 0, -1), "Negative end index should be treated as 0");
    }
//20
    @Test
    void testStartGreaterThanStringLength() {
        assertEquals("HelloXY", overlay("Hello", "XY", 10, 12), "Start index beyond length should clamp to length");
    }
//18
    @Test
    void testEndGreaterThanStringLength() {
        assertEquals("HelXY", overlay("Hello", "XY", 3, 10), "End index beyond length should clamp to length");
    }
//20
    @Test
    void testStartAndEndBothGreaterThanStringLength() {
        assertEquals("HelloXY", overlay("Hello", "XY", 10, 15), "Both indices beyond length should clamp to length");
    }
//+
    @Test
    void testZeroLengthOverlay() {
        assertEquals("HeXYllo", overlay("Hello", "XY", 2, 2), "When start == end, overlay should insert");
    }
//14
    @Test
    void testOverlayWholeString() {
        assertEquals("XY", overlay("Hello", "XY", 0, 5), "Overlay should fully replace entire string");
    }
//6
    @Test
    void testOverlayEmptyInput() {
        assertEquals("XY", overlay("", "XY", 0, 2), "Overlay on empty string should just return overlay");
    }
//3
    @Test
    void testOverlayEmptyInputWithNullOverlay() {
        assertEquals("", overlay("", null, 0, 2), "Overlay null on empty string should return empty string");
    }
//Duplicate of testZeroLengthOverlay
    @Test
    void testStartEqualsEnd() {
        assertEquals("HeXYllo", overlay("Hello", "XY", 2, 2), "When start == end, should insert overlay");
    }
//+ kind of 14 but not intentionally
    @Test
    void testOverlayFullStringWithNegativeIndices() {
        assertEquals("XY", overlay("Hello", "XY", -10, 20), "Negative start and large end should overlay whole string");
    }

}
// Assert 1, 2, 4,5,7,9,19, 11,16,17,  from Apache are missing
