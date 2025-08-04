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

import static org.apache.commons.lang3.StringUtils.indexOfAny;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndexOfAnyTest { // Replace this with your actual class name if different
    static final int INDEX_NOT_FOUND = -1;

    @Test
    void testNullInputSequence() {
        assertEquals(INDEX_NOT_FOUND, indexOfAny(null, 'a', 'b'));
    }

    @Test
    void testEmptyInputSequence() {
        assertEquals(INDEX_NOT_FOUND, indexOfAny("", 'a', 'b'));
    }

    @Test
    void testNullMatchChars() {
        assertEquals(INDEX_NOT_FOUND, indexOfAny("abc", (char[]) null));
    }

    @Test
    void testEmptyMatchChars() {
        assertEquals(INDEX_NOT_FOUND, indexOfAny("abc", new char[0]));
    }

    @Test
    void testNoMatchingChars() {
        assertEquals(INDEX_NOT_FOUND, indexOfAny("abcdef", 'x', 'y'));
    }

    @Test
    void testFirstCharMatches() {
        assertEquals(0, indexOfAny("abcdef", 'a', 'z'));
    }

    @Test
    void testMiddleCharMatches() {
        assertEquals(2, indexOfAny("abcdef", 'c', 'x'));
    }

    @Test
    void testLastCharMatches() {
        assertEquals(5, indexOfAny("abcdef", 'f'));
    }

    @Test
    void testMultipleMatchCharsSameIndex() {
        assertEquals(1, indexOfAny("abcdef", 'x', 'b', 'y', 'z'));
    }

/*    @Test
    void testSupplementaryCharacterPairMatch() {
        String str = "a𝒜b"; // '𝒜' is a supplementary character (U+1D49C)
        char[] match = Character.toChars(0x1D49C); // get surrogate pair
        assertEquals(1, indexOfAny(str, match));
    }*/

/*    @Test
    void testSurrogateMismatchDueToTrailingLowSurrogate() {
        String str = "a𝒜b";
        char high = Character.highSurrogate(0x1D49C);
        assertEquals(INDEX_NOT_FOUND, indexOfAny(str, high));
    }*/

    @Test
    void testHighSurrogateOnlyMatchingFirstButNotPair() {
        String str = "a𝒜b";
        char high = Character.highSurrogate(0x1D49C);
        char wrongLow = 'x';
        assertEquals(INDEX_NOT_FOUND, indexOfAny(str, high, wrongLow));
    }
}
