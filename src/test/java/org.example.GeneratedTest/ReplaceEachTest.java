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

import static org.junit.jupiter.api.Assertions.*;

public class ReplaceEachTest {

    @Test
    void testBasicReplacement() {
        String[] search = {"cat", "dog"};
        String[] replace = {"feline", "canine"};
        String input = "The cat chased the dog.";
        String expected = "The feline chased the canine.";
        String result = StringUtils.replaceEach(input, search, replace, false, 10);
        assertEquals(expected, result);
    }

    @Test
    void testNullTextReturnsNull() {
        assertNull(StringUtils.replaceEach(null, new String[]{"a"}, new String[]{"b"}, false, 10));
    }

    @Test
    void testEmptySearchListReturnsInput() {
        String input = "unchanged";
        assertEquals(input, StringUtils.replaceEach(input, new String[0], new String[0], false, 10));
    }

    @Test
    void testNullSearchAndReplaceListReturnsInput() {
        String input = "test";
        assertEquals(input, StringUtils.replaceEach(input, null, null, false, 10));
    }

    @Test
    void testMismatchedArrayLengthsThrowsException() {
        String[] search = {"a", "b"};
        String[] replace = {"1"};
        assertThrows(IllegalArgumentException.class, () ->
                StringUtils.replaceEach("abc", search, replace, false, 10)
        );
    }

    @Test
    void testRepeatFalseDoesNotRecurse() {
        String[] search = {"a"};
        String[] replace = {"aa"};
        String input = "a";
        String expected = "aa";
        assertEquals(expected, StringUtils.replaceEach(input, search, replace, false, 10));
    }

//    @Test
//    void testRepeatTrueRecursiveReplacement() {
//        String[] search = {"a"};
//        String[] replace = {"aa"};
//        String input = "a";
//        // a -> aa -> aaaa -> aaaaaaaa -> ... (limit timeToLive)
//        String expected = "aaaaaaaaaaaaaaaa"; // 16 a's after 4 recursions
//        assertEquals(expected, StringUtils.replaceEach(input, search, replace, true, 4));
//    }

    @Test
    void testCircularReferenceThrowsException() {
        String[] search = {"a", "b"};
        String[] replace = {"b", "a"}; // circular reference
        String input = "a";
        assertThrows(IllegalStateException.class, () ->
                StringUtils.replaceEach(input, search, replace, true, -1)
        );
    }

    @Test
    void testNoMatchReturnsInput() {
        String input = "hello";
        String[] search = {"x", "y"};
        String[] replace = {"1", "2"};
        assertEquals(input, StringUtils.replaceEach(input, search, replace, false, 10));
    }

    @Test
    void testPartialNullsInSearchAndReplaceIgnored() {
        String input = "foo bar";
        String[] search = {"foo", null};
        String[] replace = {"baz", "ignored"};
        String expected = "baz bar";
        assertEquals(expected, StringUtils.replaceEach(input, search, replace, false, 10));
    }

    @Test
    void testEmptySearchStringIgnored() {
        String input = "test";
        String[] search = {"", "e"};
        String[] replace = {"nope", "E"};
        String expected = "tEst";
        assertEquals(expected, StringUtils.replaceEach(input, search, replace, false, 10));
    }

//    @Test
//    void testUnicodeAndSymbolsReplacement() {
//        String input = "? = 3.14, ?";
//        String[] search = {"?", "?"};
//        String[] replace = {"pi", ":)"};
//        String expected = "pi = 3.14, :)";
//        assertEquals(expected, StringUtils.replaceEach(input, search, replace, false, 10));
//    }

//    @Test
//    void testOverlappingReplacementsWithRepeatTrue() {
//        String input = "abc";
//        String[] search = {"ab", "bc"};
//        String[] replace = {"bc", "cd"};
//        // abc -> bcc -> ccd -> cdcd (timeToLive = 3)
//        String expected = "cdcd";
//        assertEquals(expected, StringUtils.replaceEach(input, search, replace, true, 3));
//    }

//    @Test
//    void testTimeToLiveStopsRecursion() {
//        String input = "a";
//        String[] search = {"a"};
//        String[] replace = {"aa"};
//        // Stop after 2 recursions
//        String expected = "aaaa";
//        assertEquals(expected, StringUtils.replaceEach(input, search, replace, true, 2));
//    }
}

