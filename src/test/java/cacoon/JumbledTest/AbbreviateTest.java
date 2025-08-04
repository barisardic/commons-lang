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

import static org.apache.commons.lang3.StringUtils.abbreviate;
import static org.junit.jupiter.api.Assertions.*;

public class AbbreviateTest {

    @Test
    void testNullInputString() {
        assertNull(abbreviate(null, "...", 5, 10));
    }

    @Test
    void testEmptyInputString() {
        assertEquals("", abbreviate("", "...", 5, 10));
    }

    @Test
    void testEmptyShortFormMarker() {
        String input = "HelloWorld";
        assertEquals("Hello", abbreviate(input, "", 5, 5));
    }

/*    @Test
    void testShorteningWithMiddleCut() {
        String input = "The quick brown fox jumps over the lazy dog";
        String result = abbreviate(input, "...", 20, 20);
        assertEquals("...he lazy dog", result.substring(0, 14)); // soft check
        assertEquals(20, result.length());
    }*/

    @Test
    void testShorteningAtStart() {
        String input = "abcdefghij";
        String result = abbreviate(input, "...", 2, 6);
        assertEquals("abc...", result);
    }

    @Test
    void testMaxLengthLargerThanInput() {
        String input = "short";
        assertEquals("short", abbreviate(input, "...", 2, 10));
    }

    @Test
    void testIllegalMinAbbreviationWidth() {
        String input = "abcdef";
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> abbreviate(input, "----", 3, 4));
        assertTrue(ex.getMessage().contains("Minimum abbreviation width is"));
    }

/*    @Test
    void testIllegalMinAbbrevOffset() {
        String input = "abcdef";
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> abbreviate(input, "***", 1, 5));
        assertTrue(ex.getMessage().contains("Minimum abbreviation width with offset is"));
    }*/

/*    @Test
    void testPositionBeyondLength() {
        String input = "abcdefghij";
        String result = abbreviate(input, "..", 50, 6);
        assertEquals("abcd..", result);
    }*/

    @Test
    void testRecursiveShortening() {
        String input = "abcdefghijklmnopqrstuvwxyz";
        String result = abbreviate(input, "...", 10, 15);
        assertTrue(result.startsWith("..."));
        assertEquals(15, result.length());
    }

/*    @Test
    void testShorteningRightEdge() {
        String input = "abcdefghij";
        String result = abbreviate(input, "--", 8, 6);
        assertEquals("abcd--", result);
    }*/

}
