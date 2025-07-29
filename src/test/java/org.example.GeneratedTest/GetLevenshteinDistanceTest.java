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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetLevenshteinDistanceTest {

//+
    @Test
void testIdenticalStrings() {
    assertEquals(0, StringUtils.getLevenshteinDistance("test", "test"));
}

//10
    @Test
    void testCompletelyDifferentStrings() {
        assertEquals(4, StringUtils.getLevenshteinDistance("test", "abcd"));
    }

//Partially 2
    @Test
    void testOneEmptyString() {
        assertEquals(4, StringUtils.getLevenshteinDistance("test", ""));
        assertEquals(4, StringUtils.getLevenshteinDistance("", "test"));
    }
//1
    @Test
    void testBothEmptyStrings() {
        assertEquals(0, StringUtils.getLevenshteinDistance("", ""));
    }

//+
    @Test
    void testNullFirstStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getLevenshteinDistance(null, "test");
        });
    }
//+
    @Test
    void testNullSecondStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getLevenshteinDistance("test", null);
        });
    }
//7
    @Test
    void testInsertion() {
        assertEquals(1, StringUtils.getLevenshteinDistance("test", "tests"));
    }
//6
    @Test
    void testDeletion() {
        assertEquals(1, StringUtils.getLevenshteinDistance("tests", "test"));
    }
//10
    @Test
    void testSubstitution() {
        assertEquals(1,StringUtils.getLevenshteinDistance("test", "tent"));
    }
//9
    @Test
    void testSwappedStrings() {
        // s is longer than t, so it should swap internally
        assertEquals(1, StringUtils.getLevenshteinDistance("testing", "testin"));
    }
//10
//    @Test
//    void testUnicodeStrings() {
//        assertEquals(1, StringUtils.getLevenshteinDistance("türk", "turk"));
//    }

    //9
    @Test
    void testLongerStrings() {
        String s1 = "kitten";
        String s2 = "sitting";
        assertEquals(3, StringUtils.getLevenshteinDistance(s1, s2));
    }

}

//3,4,5,8 not used from apache