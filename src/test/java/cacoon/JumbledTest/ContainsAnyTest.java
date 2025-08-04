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

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.containsAny;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsAnyTest {

    @Test
    public void testNullSequence() {
        assertFalse(containsAny(null, 'a', 'b'));
    }

    @Test
    public void testEmptySequence() {
        assertFalse(containsAny("", 'x'));
    }

    @Test
    public void testNullTestChars() {
        assertFalse(containsAny("hello", (char[]) null));
    }

/*    @Test
    public void testEmptyTestChars() {
        assertFalse(containsAny("hello"));
    }*/

    @Test
    public void testSingleMatch() {
        assertTrue(containsAny("hello", 'e'));
    }

    @Test
    public void testMultipleMatches() {
        assertTrue(containsAny("hello", 'x', 'y', 'o'));
    }

    @Test
    public void testNoMatch() {
        assertFalse(containsAny("world", 'a', 'b', 'c'));
    }

    @Test
    public void testAllCharactersMatch() {
        assertTrue(containsAny("abc", 'a', 'b', 'c'));
    }

    @Test
    public void testMatchWithHighSurrogate() {
        // Surrogate pair: U+1F600 (grinning face emoji)
        String smile = "\uD83D\uDE00";
        char[] chars = new char[] { '\uD83D', '\uDE00' }; // the pair
        assertTrue(containsAny(smile, chars));
    }

    @Test
    public void testHighSurrogateWithoutLowSurrogate() {
        String s = "\uD83Dabc"; // high surrogate without proper low surrogate following
        assertFalse(containsAny(s, '\uD83D', '\uDE00'));
    }

    @Test
    public void testLastCharacterMatch() {
        assertTrue(containsAny("xyz", 'z'));
    }

    @Test
    public void testPerformanceLargeInput() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10000; i++) sb.append('x');
        sb.append('z');
        assertTrue(containsAny(sb.toString(), 'z'));
    }
}

