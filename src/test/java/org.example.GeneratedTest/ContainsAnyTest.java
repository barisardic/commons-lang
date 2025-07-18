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
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsAnyTest {

    @Test
    void testContainsAny_NullCharSequence() {
        assertFalse(StringUtils.containsAny(null, 'a', 'b', 'c'));
    }

    @Test
    void testContainsAny_NullSearchChars() {
        assertFalse(StringUtils.containsAny("abc", (char[]) null));
    }

    @Test
    void testContainsAny_EmptyCharSequence() {
        assertFalse(StringUtils.containsAny("", 'a', 'b'));
    }

    @Test
    void testContainsAny_EmptySearchChars() {
        assertFalse(StringUtils.containsAny("abc", new char[0]));
    }

    @Test
    void testContainsAny_BothEmpty() {
        assertFalse(StringUtils.containsAny("", new char[0]));
    }

    @Test
    void testContainsAny_MatchSingleChar() {
        assertTrue(StringUtils.containsAny("abc", 'b'));
    }

    @Test
    void testContainsAny_MatchMultipleChars() {
        assertTrue(StringUtils.containsAny("abcdef", 'x', 'y', 'e'));
    }

    @Test
    void testContainsAny_NoMatch() {
        assertFalse(StringUtils.containsAny("abcdef", 'x', 'y', 'z'));
    }

    @Test
    void testContainsAny_MatchFirstChar() {
        assertTrue(StringUtils.containsAny("abc", 'a'));
    }

    @Test
    void testContainsAny_MatchLastChar() {
        assertTrue(StringUtils.containsAny("abc", 'c'));
    }

    @Test
    void testContainsAny_MatchSurrogatePair() {
        // 😀 (U+1F600) is represented by surrogate pair \uD83D\uDE00
        String input = "\uD83D\uDE00"; // 😀
        char[] searchChars = {'\uD83D', '\uDE00'};
        assertTrue(StringUtils.containsAny(input, searchChars));
    }

//    @Test
//    void testContainsAny_PartialSurrogate_NoMatch() {
//        // Only one half of the surrogate pair present in searchChars
//        String input = "\uD83D\uDE00"; // 😀
//        char[] searchChars = {'\uD83D'};
//        assertFalse(StringUtils.containsAny(input, searchChars));
//    }

    @Test
    void testContainsAny_SpecialCharacters() {
        assertTrue(StringUtils.containsAny("abc$%*", '$', '#'));
        assertFalse(StringUtils.containsAny("abc$%*", '#', '^'));
    }

//    @Test
//    void testContainsAny_UnicodeCharacters() {
//        assertTrue(StringUtils.containsAny("こんにちは", 'に', 'ほ'));
//        assertFalse(StringUtils.containsAny("こんにちは", 'さ', 'し'));
//    }

    @Test
    void testContainsAny_RepeatedChars() {
        assertTrue(StringUtils.containsAny("aaaaa", 'a'));
        assertFalse(StringUtils.containsAny("aaaaa", 'b'));
    }

    @Test
    void testContainsAny_Whitespace() {
        assertTrue(StringUtils.containsAny("a b c", ' '));
        assertFalse(StringUtils.containsAny("abc", ' '));
    }

    @Test
    void testContainsAny_TabNewline() {
        assertTrue(StringUtils.containsAny("abc\tdef\n", '\t'));
        assertTrue(StringUtils.containsAny("abc\tdef\n", '\n'));
    }
}

