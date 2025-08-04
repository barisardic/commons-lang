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

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndexOfDifferenceTest {
    // Assuming INDEX_NOT_FOUND is -1
    private static final int INDEX_NOT_FOUND = -1;

    @Test
    void testNullArray() {
        assertEquals(INDEX_NOT_FOUND, StringUtils.indexOfDifference((CharSequence[]) null));
    }

    @Test
    void testEmptyArray() {
        assertEquals(INDEX_NOT_FOUND, StringUtils.indexOfDifference());
    }

    @Test
    void testSingleElementArray() {
        assertEquals(INDEX_NOT_FOUND, StringUtils.indexOfDifference("abc"));
    }

    @Test
    void testAllNulls() {
        assertEquals(INDEX_NOT_FOUND, StringUtils.indexOfDifference(null, null, null));
    }

    @Test
    void testAllEmptyStrings() {
        assertEquals(INDEX_NOT_FOUND, StringUtils.indexOfDifference("", "", ""));
    }

    @Test
    void testSomeNulls() {
        assertEquals(0, StringUtils.indexOfDifference(null, "abc"));
        assertEquals(0, StringUtils.indexOfDifference("abc", null));
        assertEquals(0, StringUtils.indexOfDifference(null, ""));
    }

//    @Test
//    void testSomeEmptyStrings() {
//        assertEquals(0, StringUtils.indexOfDifference("", "abc"));
//        assertEquals(0, StringUtils.indexOfDifference("abc", ""));
//        assertEquals(0, StringUtils.indexOfDifference("", ""));
//    }

    @Test
    void testIdenticalStrings() {
        assertEquals(INDEX_NOT_FOUND, StringUtils.indexOfDifference("abc", "abc", "abc"));
    }

    @Test
    void testDifferentAtStart() {
        assertEquals(0, StringUtils.indexOfDifference("abc", "xbc"));
    }

    @Test
    void testDifferentInMiddle() {
        assertEquals(1, StringUtils.indexOfDifference("abc", "adc"));
    }

    @Test
    void testDifferentAtEnd() {
        assertEquals(2, StringUtils.indexOfDifference("abc", "abd"));
    }

    @Test
    void testShorterStringIsPrefix() {
        assertEquals(3, StringUtils.indexOfDifference("abc", "abcdef"));
        assertEquals(3, StringUtils.indexOfDifference("abcdef", "abc"));
    }

    @Test
    void testMultipleStringsDifferentLengths() {
        assertEquals(1, StringUtils.indexOfDifference("abc", "adc", "aec"));
        assertEquals(1, StringUtils.indexOfDifference("abcdef", "adc", "aec"));
    }

    @Test
    void testOneStringEmptyOthersNonEmpty() {
        assertEquals(0, StringUtils.indexOfDifference("", "abc", "def"));
    }

    @Test
    void testMixedNullEmptyNonEmpty() {
        assertEquals(0, StringUtils.indexOfDifference(null, "", "abc"));
        assertEquals(0, StringUtils.indexOfDifference("abc", "", null));
    }

    @Test
    void testDifferenceWithSpaces() {
        assertEquals(1, StringUtils.indexOfDifference("a bc", "aXbc"));
        assertEquals(2, StringUtils.indexOfDifference("ab c", "abXc"));
    }

    @Test
    void testLongCommonPrefix() {
        assertEquals(5, StringUtils.indexOfDifference("abcdef", "abcdeX", "abcdeY"));
    }

    @Test
    void testOneIsSubstringOfAnother() {
        assertEquals(4, StringUtils.indexOfDifference("abcd", "abcde"));
    }

//    @Test
//    void testDifferentUnicodeChars() {
//        assertEquals(2, StringUtils.indexOfDifference("ab😀d", "ab😁d"));
//    }
}
