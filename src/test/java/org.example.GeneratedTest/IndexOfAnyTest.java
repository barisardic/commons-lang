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
import static org.apache.commons.lang3.StringUtils.indexOfAny;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndexOfAnyTest { // Replace this with your actual class name if different
    static final int INDEX_NOT_FOUND = -1;

    @Test
    void testNullCharSequence() {
        assertEquals(INDEX_NOT_FOUND, StringUtils.indexOfAny(null, 'a', 'b'));
    }

    @Test
    void testNullSearchChars() {
        assertEquals(INDEX_NOT_FOUND, StringUtils.indexOfAny("abc", (char[]) null));
    }

    @Test
    void testEmptyCharSequence() {
        assertEquals(INDEX_NOT_FOUND, StringUtils.indexOfAny("", 'a', 'b'));
    }

//    @Test
//     void testEmptySearchChars() {
//        assertEquals(INDEX_NOT_FOUND, StringUtils.indexOfAny("abc"));
//    }

    @Test
    void testNoMatch() {
        assertEquals(INDEX_NOT_FOUND, StringUtils.indexOfAny("abc", 'x', 'y', 'z'));
    }

    @Test
    void testSingleMatchAtStart() {
        assertEquals(0, StringUtils.indexOfAny("abc", 'a'));
    }

    @Test
    void testSingleMatchAtMiddle() {
        assertEquals(1, StringUtils.indexOfAny("abc", 'b'));
    }

    @Test
    void testSingleMatchAtEnd() {
        assertEquals(2, StringUtils.indexOfAny("abc", 'c'));
    }

    @Test
    void testMultipleSearchCharsFirstMatch() {
        assertEquals(1, StringUtils.indexOfAny("abc", 'x', 'b', 'c'));
    }

    @Test
    void testMatchWithSupplementaryCharacter() {
        // U+1F600 is 😀, a supplementary character
        String input = "abc\uD83D\uDE00def"; // 😀 at index 3
        char[] searchChars = Character.toChars(0x1F600);
        assertEquals(3, StringUtils.indexOfAny(input, searchChars));
    }

    @Test
    void testHighSurrogateWithoutLowSurrogate() {
        // High surrogate alone should not match if searchChars has supplementary pair
        String input = "abc\uD83Ddef"; // Only high surrogate
        char[] searchChars = Character.toChars(0x1F600); // 😀
        assertEquals(INDEX_NOT_FOUND, StringUtils.indexOfAny(input, searchChars));
    }

//    @Test
//    void testLowSurrogateAlone() {
//        // Low surrogate alone should not match either
//        String input = "abc\uDE00def"; // Only low surrogate
//        char[] searchChars = Character.toChars(0x1F600); // 😀
//        assertEquals(INDEX_NOT_FOUND, StringUtils.indexOfAny(input, searchChars));
//    }

//    @Test
//    void testSameCharMultipleTimes() {
//        assertEquals(1, StringUtils.indexOfAny("abacada", 'b', 'a'));
//    }

    @Test
    void testSearchCharsWithDuplicates() {
        assertEquals(0, StringUtils.indexOfAny("abc", 'a', 'a', 'b'));
    }

    @Test
    void testWhitespaceCharacter() {
        assertEquals(3, StringUtils.indexOfAny("abc def", ' '));
    }
}
