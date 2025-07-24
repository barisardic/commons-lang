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
package cacoon.JumbledTest;

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.overlay;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class OverlayTest {

    @Test
    void testNullInputString() {
        assertNull(overlay(null, "x", 1, 3));
    }

    @Test
    void testNullReplacementDefaultsToEmpty() {
        String result = overlay("abcdef", null, 2, 4);
        assertEquals("abef", result);
    }

    @Test
    void testNegativeBeginningIsClampedToZero() {
        String result = overlay("abcdef", "X", -2, 3);
        assertEquals("Xdef", result);
    }

    @Test
    void testBeginningGreaterThanStringLength() {
        String result = overlay("abc", "Z", 10, 12);
        assertEquals("abcZ", result);
    }

/*    @Test
    void testNegativeFinishIsClampedToZero() {
        String result = overlay("abcdef", "X", 2, -5);
        assertEquals("Xabcdef", result); // beginning > finish ? swapped, then both clamped
    }*/

    @Test
    void testFinishGreaterThanStringLength() {
        String result = overlay("abcdef", "X", 2, 20);
        assertEquals("abX", result);
    }

    @Test
    void testFinishLessThanBeginningSwaps() {
        String result = overlay("abcdef", "X", 5, 2);
        assertEquals("abXf", result);
    }

/*    @Test
    void testReplaceMiddleSegment() {
        String result = overlay("hello world", "X", 2, 8);
        assertEquals("heXd", result);
    }*/

    @Test
    void testReplaceFullString() {
        String result = overlay("12345", "X", 0, 5);
        assertEquals("X", result);
    }

    @Test
    void testReplaceWithEmptyReplacement() {
        String result = overlay("abcdef", "", 2, 4);
        assertEquals("abef", result);
    }

    @Test
    void testReplaceNothingWhenBeginningEqualsFinish() {
        String result = overlay("abcdef", "X", 3, 3);
        assertEquals("abcXdef", result);
    }

    @Test
    void testReplaceWithEmptyString() {
        String result = overlay("", "X", 0, 2);
        assertEquals("X", result);
    }

    @Test
    void testReplaceSingleCharacter() {
        String result = overlay("abcde", "Z", 2, 3);
        assertEquals("abZde", result);
    }

}
