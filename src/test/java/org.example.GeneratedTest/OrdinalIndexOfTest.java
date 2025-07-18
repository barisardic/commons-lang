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

import static org.apache.commons.lang3.StringUtils.ordinalIndexOf;
import static org.example.GeneratedTest.IndexOfAnyTest.INDEX_NOT_FOUND;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrdinalIndexOfTest {
    @Test
    void testNullInputs() {
        assertEquals(INDEX_NOT_FOUND, ordinalIndexOf(null, "a", 1, false));
        assertEquals(INDEX_NOT_FOUND, ordinalIndexOf("abc", null, 1, false));
        assertEquals(INDEX_NOT_FOUND, ordinalIndexOf(null, null, 1, false));
    }

    @Test
    void testOrdinalZeroOrNegative() {
        assertEquals(INDEX_NOT_FOUND, ordinalIndexOf("abc", "a", 0, false));
        assertEquals(INDEX_NOT_FOUND, ordinalIndexOf("abc", "a", -1, true));
    }

    @Test
    void testEmptySearchStr() {
        assertEquals(0, ordinalIndexOf("abc", "", 1, false));
        assertEquals(3, ordinalIndexOf("abc", "", 1, true));
    }

    @Test
    void testNoMatch() {
        assertEquals(INDEX_NOT_FOUND, ordinalIndexOf("abc", "z", 1, false));
        assertEquals(INDEX_NOT_FOUND, ordinalIndexOf("abcabc", "z", 2, true));
    }

    @Test
    void testForwardSearchBasic() {
        assertEquals(0, ordinalIndexOf("abcabcabc", "a", 1, false));
        assertEquals(3, ordinalIndexOf("abcabcabc", "a", 2, false));
        assertEquals(6, ordinalIndexOf("abcabcabc", "a", 3, false));
        assertEquals(INDEX_NOT_FOUND, ordinalIndexOf("abcabcabc", "a", 4, false));
    }

    @Test
    void testBackwardSearchBasic() {
        assertEquals(6, ordinalIndexOf("abcabcabc", "a", 1, true));
        assertEquals(3, ordinalIndexOf("abcabcabc", "a", 2, true));
        assertEquals(0, ordinalIndexOf("abcabcabc", "a", 3, true));
        assertEquals(INDEX_NOT_FOUND, ordinalIndexOf("abcabcabc", "a", 4, true));
    }

    @Test
    void testForwardSearchWithOverlap() {
        assertEquals(0, ordinalIndexOf("aaaa", "aa", 1, false)); // "aa" at 0
        assertEquals(1, ordinalIndexOf("aaaa", "aa", 2, false)); // overlapping "aa" at 1
        assertEquals(2, ordinalIndexOf("aaaa", "aa", 3, false)); // overlapping "aa" at 2
        assertEquals(INDEX_NOT_FOUND, ordinalIndexOf("aaaa", "aa", 4, false)); // no 4th "aa"
    }

    @Test
    void testBackwardSearchWithOverlap() {
        assertEquals(2, ordinalIndexOf("aaaa", "aa", 1, true)); // last "aa" at 2
        assertEquals(1, ordinalIndexOf("aaaa", "aa", 2, true)); // second last "aa" at 1
        assertEquals(0, ordinalIndexOf("aaaa", "aa", 3, true)); // third last "aa" at 0
        assertEquals(INDEX_NOT_FOUND, ordinalIndexOf("aaaa", "aa", 4, true)); // no 4th "aa"
    }

    @Test
    void testFullStringMatch() {
        assertEquals(0, ordinalIndexOf("aaa", "aaa", 1, false));
        assertEquals(0, ordinalIndexOf("aaa", "aaa", 1, true));
        assertEquals(INDEX_NOT_FOUND, ordinalIndexOf("aaa", "aaa", 2, false));
    }
}