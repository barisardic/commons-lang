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

import static org.apache.commons.lang3.StringUtils.repeat;

import static org.junit.jupiter.api.Assertions.*;

public class RepeatTest {
//1
    @Test
    void testNullInput() {
        assertNull(repeat(null, 5), "Null input should return null");
    }
//2
    @Test
    void testZeroCount() {
        assertEquals("", repeat("abc", 0), "Zero count should return empty string");
    }
//5
    @Test
    void testNegativeCount() {
        assertEquals("", repeat("abc", -3), "Negative count should be treated as zero and return empty string");
    }
//3
    @Test
    void testEmptyString() {
        assertEquals("", repeat("", 5), "Empty string should always return empty string");
    }
//7
    @Test
    void testCountOne() {
        assertEquals("abc", repeat("abc", 1), "Count of one should return original string");
    }
//4
    @Test
    void testSingleCharacterString() {
        assertEquals("aaaaa", repeat("a", 5), "Single character should repeat correctly");
    }
//6
    @Test
    void testTwoCharacterString() {
        assertEquals("ababab", repeat("ab", 3), "Two character string should repeat correctly");
    }
//7
    @Test
    void testMultiCharacterString() {
        assertEquals("abcabcabc", repeat("abc", 3), "Multi character string should repeat correctly");
    }
//8,9
    @Test
    void testCountLarge() {
        String repeated = repeat("x", 1000);
        assertNotNull(repeated, "Result should not be null for large count");
        assertEquals(1000, repeated.length(), "Length should match input length times count");
    }
//8,9
    @Test
    void testSingleCharacterAtPadLimit() {
        final int PAD_LIMIT = 8192; // Typically the limit in Commons Lang
        String repeated = repeat("a", PAD_LIMIT);
        assertNotNull(repeated);
        assertEquals(PAD_LIMIT, repeated.length(), "Should handle count equal to PAD_LIMIT");
    }
//8,9
    @Test
    void testSingleCharacterAbovePadLimit() {
        final int PAD_LIMIT = 8192; // Typically the limit in Commons Lang
        String repeated = repeat("a", PAD_LIMIT + 1);
        assertNotNull(repeated);
        assertEquals(PAD_LIMIT + 1, repeated.length(), "Should handle count above PAD_LIMIT");
    }
//+
    @Test
    void testWhitespaceString() {
        assertEquals("     ", repeat(" ", 5), "Whitespace string should repeat correctly");
    }
//+
    @Test
    void testUnicodeCharacter() {
        assertEquals("ééééé", repeat("é", 5), "Unicode single char should repeat correctly");
    }
// Similar logic testUnicodeCharacter
    @Test
    void testUnicodeString() {
        assertEquals("你好你好你好", repeat("你好", 3), "Unicode multi-char string should repeat correctly");
    }
//+ ???
    @Test
    void testRepeatSameReference() {
        String input = "test";
        String result = repeat(input, 1);
        assertSame(input, result, "If count is one, should return same reference");
    }
//4
    @Test
    void testRepeatSingleCharacterIsOptimized() {
        assertEquals("zzz", repeat("z", 3), "Single character repeat should be optimized");
    }
//6
    @Test
    void testRepeatTwoCharacterIsOptimized() {
        assertEquals("xyxyxyxy", repeat("xy", 4), "Two character repeat should be optimized");
    }
//7
    @Test
    void testRepeatMultiCharacterFallback() {
        assertEquals("abcdabcd", repeat("abcd", 2), "Multi character repeat should use StringBuilder fallback");
    }

}

// except test 10 from apache ??
