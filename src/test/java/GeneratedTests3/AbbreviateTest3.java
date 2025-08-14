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
package GeneratedTests3;
import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

public class AbbreviateTest3 {


    @Test
    void testNullStringReturnsNull() {
        assertNull(StringUtils.abbreviate(null, "...", 0, 10));
    }

    @Test
    void testEmptyAbbrevMarkerUsesSubstring() {
        String result = StringUtils.abbreviate("HelloWorld", "", 0, 5);
        assertEquals("Hello", result);
    }

    @Test
    void testEmptyInputAndEmptyMarker() {
        assertEquals("", StringUtils.abbreviate("", "", 0, 5));
    }

    @Test
    void testEmptyMarkerWithNonEmptyString() {
        assertEquals("Hell", StringUtils.abbreviate("Hello", "", 0, 4));
    }

    @Test
    void testEmptyMarkerAndZeroWidth() {
        String result = StringUtils.abbreviate("Hello", "", 0, 0);
        assertEquals("", result);
    }

    @Test
    void testMaxWidthLessThanMinAbbrevWidthThrowsException() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> StringUtils.abbreviate("Hello World", "...", 0, 2));
        assertTrue(ex.getMessage().contains("Minimum abbreviation width is"));
    }

    @Test
    void testStringShorterThanMaxWidthReturnsOriginal() {
        assertEquals("Hello", StringUtils.abbreviate("Hello", "...", 0, 10));
    }

    @Test
    void testOffsetGreaterThanStringLength() {
        String result = StringUtils.abbreviate("Hello World", "...", 50, 10);
        assertEquals("Hello W...", result);
    }

    @Test
    void testAbbreviationAtStart() {
        String result = StringUtils.abbreviate("The quick brown fox", "...", 0, 10);
        assertEquals("The qui...", result);
    }

    @Test
    void testAbbreviationInMiddle() {
        String result = StringUtils.abbreviate("The quick brown fox jumps", "...", 10, 15);
        assertEquals("...own fox j...", result);
    }

    @Test
    void testAbbreviationAtEnd() {
        String result = StringUtils.abbreviate("The quick brown fox jumps over", "...", 25, 15);
        assertEquals("...ks over", result);
    }

    @Test
    void testOffsetJustBeforeAbbrevEdge() {
        String result = StringUtils.abbreviate("abcdefghij", "...", 2, 7);
        assertEquals("abcd...", result);
    }

    @Test
    void testOffsetTooSmallToApplyOffsetRule() {
        String result = StringUtils.abbreviate("abcdefghij", "...", 1, 7);
        assertEquals("abcd...", result);
    }

    @Test
    void testAbbrevWithMaxWidthExactlyEqual() {
        String result = StringUtils.abbreviate("abcdefghij", "...", 3, 10);
        assertEquals("...efghij", result);
    }

    @Test
    void testAbbrevWithOffsetAndMaxWidthTooSmallForOffsetRule() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> StringUtils.abbreviate("abcdefghij", "...", 5, 6));
        assertTrue(ex.getMessage().contains("Minimum abbreviation width with offset is"));
    }

    @Test
    void testOffsetPlusMaxWidthExceedsLength() {
        String result = StringUtils.abbreviate("abcdefghij", "...", 7, 7);
        assertEquals("...efghij", result);
    }

    @Test
    void testMarkerLongerThanMaxWidth() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> StringUtils.abbreviate("Hello world", "<<<>>>", 0, 5));
        assertTrue(ex.getMessage().contains("Minimum abbreviation width"));
    }
}
