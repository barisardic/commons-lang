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

import static org.apache.commons.lang3.StringUtils.containsNone;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsNoneTest {

    @Test
    public void testNullSequence() {
        assertTrue(containsNone(null, 'a', 'b'));
    }

/*    @Test
    public void testNullExcludedChars() {
        assertTrue(containsNone("abc", null));
    }

    @Test
    public void testBothNull() {
        assertTrue(containsNone(null, null));
    }*/

    @Test
    public void testEmptySequence() {
        assertTrue(containsNone("", 'x'));
    }

    @Test
    public void testEmptyExcludedChars() {
        assertTrue(containsNone("abc", new char[0]));
    }

    @Test
    public void testNoExcludedCharsPresent() {
        assertTrue(containsNone("hello", 'x', 'y', 'z'));
    }

    @Test
    public void testExcludedCharPresent() {
        assertFalse(containsNone("hello", 'x', 'e', 'z'));
    }

    @Test
    public void testFirstCharIsExcluded() {
        assertFalse(containsNone("abc", 'a'));
    }

    @Test
    public void testLastCharIsExcluded() {
        assertFalse(containsNone("abc", 'c'));
    }

    @Test
    public void testMultipleExcludedCharsOneMatches() {
        assertFalse(containsNone("test", 'x', 'e', 'z'));
    }

    @Test
    public void testHighSurrogateMatchValidPair() {
        // surrogate pair U+1F60A = "\uD83D\uDE0A"
        String text = "abc\uD83D\uDE0Axyz";
        char[] excluded = {'\uD83D', '\uDE0A'};
        assertFalse(containsNone(text, excluded));
    }

    @Test
    public void testHighSurrogateWithoutMatchingLowSurrogate() {
        // Only high surrogate included, next char not a match
        String text = "abc\uD83D\uDE0Bxyz";
        char[] excluded = {'\uD83D', '\uDE0A'};
        assertTrue(containsNone(text, excluded));
    }

    @Test
    public void testSurrogateWithMismatch() {
        // surrogate in sequence, but not matching the excluded
        String text = "abc\uD83D\uDE0Bxyz";
        char[] excluded = {'\uD83D', '\uDE0C'};
        assertTrue(containsNone(text, excluded));
    }

    @Test
    public void testIdenticalSurrogateCharButNotPair() {
        // high surrogate matches but not followed by the low surrogate
        String text = "\uD83Dabc";
        char[] excluded = {'\uD83D', '\uDE0A'};
        assertTrue(containsNone(text, excluded));
    }

}
