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

import static org.apache.commons.lang3.StringUtils.getLevenshteinDistance;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetLevenshteinDistanceTest {
    @Test
    void testIdenticalStrings() {
        assertEquals(0, getLevenshteinDistance("kitten", "kitten"));
    }

    @Test
    void testSingleEditDistance() {
        assertEquals(1, getLevenshteinDistance("kitten", "sitten")); // substitution
        assertEquals(1, getLevenshteinDistance("kitten", "kitte"));  // deletion
        assertEquals(1, getLevenshteinDistance("kitten", "kittens")); // insertion
    }

/*    @Test
    void testCompletelyDifferentStrings() {
        assertEquals(6, getLevenshteinDistance("kitten", "monkey"));
    }*/

    @Test
    void testEmptySourceString() {
        assertEquals(4, getLevenshteinDistance("", "test"));
    }

    @Test
    void testEmptyTargetString() {
        assertEquals(4, getLevenshteinDistance("test", ""));
    }

    @Test
    void testBothStringsEmpty() {
        assertEquals(0, getLevenshteinDistance("", ""));
    }

    @Test
    void testCaseSensitivity() {
        assertEquals(1, getLevenshteinDistance("Test", "test")); // 'T' vs 't'
    }

/*    @Test
    void testUnicodeCharacters() {
        assertEquals(1, getLevenshteinDistance("café", "cafe")); // é vs e
        assertEquals(2, getLevenshteinDistance("你好吗", "你好吗啊"));
    }*/

/*    @Test
    void testLongStrings() {
        String a = "a".repeat(1000);
        String b = "a".repeat(999) + "b";
        assertEquals(1, getLevenshteinDistance(a, b));
    }*/

    @Test
    void testSwapMemoryOptimizationBranch() {
        // Triggers the swap branch because target is shorter than source
        assertEquals(1, getLevenshteinDistance("abcd", "abc"));
    }

    @Test
    void testNullInputs() {
        assertThrows(IllegalArgumentException.class, () -> getLevenshteinDistance(null, "test"));
        assertThrows(IllegalArgumentException.class, () -> getLevenshteinDistance("test", null));
        assertThrows(IllegalArgumentException.class, () -> getLevenshteinDistance(null, null));
    }

}
