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
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetLevenshteinDistanceTest {

//+ ok test
    @Test
void testIdenticalStrings() {
    assertEquals(0, StringUtils.getLevenshteinDistance("test", "test"));
}

// [4]
    @Test
    void testCompletelyDifferentStrings() {
        assertEquals(4, StringUtils.getLevenshteinDistance("test", "abcd"));
    }

// [2]
    @Test
    void testOneEmptyString() {
        assertEquals(4, StringUtils.getLevenshteinDistance("test", ""));
        assertEquals(4, StringUtils.getLevenshteinDistance("", "test"));
    }
// [1]
    @Test
    void testBothEmptyStrings() {
        assertEquals(0, StringUtils.getLevenshteinDistance("", ""));
    }

// + precondition test
    @Test
    void testNullFirstStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getLevenshteinDistance(null, "test");
        });
    }
// + precondition test
    @Test
    void testNullSecondStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getLevenshteinDistance("test", null);
        });
    }
// [3]
    @Test
    void testInsertion() {
        assertEquals(1, StringUtils.getLevenshteinDistance("test", "tests"));
    }
// [3]
    @Test
    void testDeletion() {
        assertEquals(1, StringUtils.getLevenshteinDistance("tests", "test"));
    }
// [8]
    @Test
    void testSubstitution() {
        assertEquals(1,StringUtils.getLevenshteinDistance("test", "tent"));
    }
// [6]
    @Test
    void testSwappedStrings() {
        // s is longer than t, so it should swap internally
        assertEquals(1, StringUtils.getLevenshteinDistance("testing", "testin"));
    }
//+ ok test
//    @Test
//    void testUnicodeStrings() {
//        assertEquals(1, StringUtils.getLevenshteinDistance("türk", "turk"));
//    }

    // + ok test
    @Test
    void testLongerStrings() {
        String s1 = "kitten";
        String s2 = "sitting";
        assertEquals(3, StringUtils.getLevenshteinDistance(s1, s2));
    }

}
// 12 generated assertions
//There are 8 scenarios in apache  of them used in generated test
// 4,2,1,3,8,6 are matched
// 6 matches
// 5 + [new] tests
// 1 failing
