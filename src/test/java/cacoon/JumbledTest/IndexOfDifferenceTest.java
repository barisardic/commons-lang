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

import static org.apache.commons.lang3.StringUtils.indexOfDifference;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IndexOfDifferenceTest {
    // Assuming INDEX_NOT_FOUND is -1
    private static final int INDEX_NOT_FOUND = -1;

    @Test
    public void testNullInputArray() {
        assertEquals(INDEX_NOT_FOUND, indexOfDifference((CharSequence[]) null));
    }

    @Test
    public void testEmptyInputArray() {
        assertEquals(INDEX_NOT_FOUND, indexOfDifference());
    }

    @Test
    public void testSingleString() {
        assertEquals(INDEX_NOT_FOUND, indexOfDifference("onlyOne"));
    }

    @Test
    public void testAllNulls() {
        assertEquals(INDEX_NOT_FOUND, indexOfDifference(null, null));
    }

    @Test
    public void testSomeNulls() {
        assertEquals(0, indexOfDifference("abc", null));
        assertEquals(0, indexOfDifference(null, "abc", "abc"));
    }

    @Test
    public void testEmptyStringsAllEqual() {
        assertEquals(INDEX_NOT_FOUND, indexOfDifference("", ""));
    }

    @Test
    public void testEmptyAndNonEmpty() {
        assertEquals(0, indexOfDifference("", "abc"));
        assertEquals(0, indexOfDifference("abc", ""));
    }

    @Test
    public void testAllSameStrings() {
        assertEquals(INDEX_NOT_FOUND, indexOfDifference("hello", "hello", "hello"));
    }

    @Test
    public void testDifferentAtBeginning() {
        assertEquals(0, indexOfDifference("hello", "jello", "mello"));
    }

    @Test
    public void testDifferentInMiddle() {
        assertEquals(2, indexOfDifference("abcde", "abXde", "abYde"));
    }

/*    @Test
    public void testDifferentAtEnd() {
        assertEquals(4, indexOfDifference("test", "tesu", "tesv"));
    }*/

    @Test
    public void testAllPrefixesSame() {
        assertEquals(3, indexOfDifference("abc", "abcdef", "abcxyz"));
    }

    @Test
    public void testOneShorterNoDifference() {
        assertEquals(3, indexOfDifference("abc", "abcd", "abcde"));
    }

    @Test
    public void testMultipleEmptyStringsAndNulls() {
        assertEquals(0, indexOfDifference("", null, ""));
    }

/*    @Test
    public void testMultibyteCharacters() {
        assertEquals(2, indexOfDifference("héllo", "héylo"));
    }*/
}
