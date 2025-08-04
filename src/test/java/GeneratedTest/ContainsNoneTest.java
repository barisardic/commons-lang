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

import static org.apache.commons.lang3.StringUtils.containsNone;

import static org.junit.jupiter.api.Assertions.*;

public class ContainsNoneTest {

    @Test
    void testNullInputCharSequence() {
        assertTrue(containsNone(null, 'a', 'b'), "Null CharSequence should return true");
    }

    @Test
    void testNullSearchChars() {
        assertTrue(containsNone("abc", (char[]) null), "Null searchChars should return true");
    }

    @Test
    void testNullBoth() {
        assertTrue(containsNone(null, (char[]) null), "Null CharSequence and searchChars should return true");
    }

    @Test
    void testEmptyCharSequence() {
        assertTrue(containsNone("", 'a', 'b'), "Empty CharSequence should return true");
    }

    @Test
    void testEmptySearchChars() {
        assertTrue(containsNone("abc", new char[]{}), "Empty searchChars should return true");
    }

    @Test
    void testEmptyBoth() {
        assertTrue(containsNone("", new char[]{}), "Empty CharSequence and searchChars should return true");
    }

    @Test
    void testContainsOneInvalidChar() {
        assertFalse(containsNone("abc", 'b'), "Should return false if one invalid char is found");
    }

    @Test
    void testContainsMultipleInvalidChars() {
        assertFalse(containsNone("abc", 'x', 'y', 'a'), "Should return false if any invalid char is found");
    }

    @Test
    void testContainsNoInvalidChars() {
        assertTrue(containsNone("abc", 'x', 'y', 'z'), "Should return true if no invalid chars are found");
    }

    @Test
    void testContainsNoneWithUnicode() {
        assertTrue(containsNone("über", 'x', 'y'), "Should return true for unicode chars not in searchChars");
    }

    @Test
    void testContainsInvalidUnicodeChar() {
        assertFalse(containsNone("über", "ü"), "Should return false if unicode char is found");
    }

    @Test
    void testHighSurrogatePairNotMatched() {
        String input = "A\uD83D\uDE00B"; // A 😀 B
        char[] searchChars = { '\uD83D', '\uDE00' }; // 😀 surrogate pair
        assertFalse(containsNone(input, searchChars), "Should return false if surrogate pair is matched");
    }

    @Test
    void testHighSurrogateSingleNotMatched() {
        String input = "A\uD83D B"; // A + High surrogate only + B
        char[] searchChars = { '\uD83D', '\uDE00' };
        assertTrue(containsNone(input, searchChars), "Should return true if surrogate pair is incomplete and no match");
    }

    @Test
    void testCharSequenceNoMatchWithSimilarChars() {
        assertTrue(containsNone("abc", 'd', 'e', 'f'), "Should return true if none of the chars match");
    }

    @Test
    void testCharSequenceSingleCharValid() {
        assertTrue(containsNone("a", 'b'), "Should return true if single char input does not match searchChars");
    }

    @Test
    void testCharSequenceSingleCharInvalid() {
        assertFalse(containsNone("a", 'a'), "Should return false if single char input matches searchChars");
    }

    @Test
    void testCharSequenceMultiMatch() {
        assertFalse(containsNone("abc", 'a', 'b', 'c'), "Should return false if multiple chars match");
    }

    @Test
    void testCharSequenceContainsWhitespace() {
        assertFalse(containsNone("a b c", ' '), "Should return false if whitespace is in searchChars");
    }

    @Test
    void testCharSequenceWhitespaceNoMatch() {
        assertTrue(containsNone("a b c", '\t'), "Should return true if whitespace char does not match");
    }

}
