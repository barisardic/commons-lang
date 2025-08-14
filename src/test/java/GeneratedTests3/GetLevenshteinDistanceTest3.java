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
package GeneratedTests3;
import static org.apache.commons.lang3.StringUtils.getLevenshteinDistance;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class GetLevenshteinDistanceTest3 {


    //+ ok test
        @Test
        void testSameStrings() {
            assertEquals(0, getLevenshteinDistance("kitten", "kitten"));
        }
    //5
        @Test
        void testCompletelyDifferentStrings() {
            assertEquals(6, getLevenshteinDistance("kitten", "puppies"));
        }
//8
        @Test
        void testSingleCharacterDifference() {
            assertEquals(1, getLevenshteinDistance("kitten", "sitten"));
        }
//3
        @Test
        void testInsertion() {
            assertEquals(1, getLevenshteinDistance("kitten", "kittena"));
        }
//3
        @Test
        void testDeletion() {
            assertEquals(1, getLevenshteinDistance("kitten", "kiten"));
        }
//2
        @Test
        void testEmptyFirstString() {
            assertEquals(6, getLevenshteinDistance("", "kitten"));
        }
//2
        @Test
        void testEmptySecondString() {
            assertEquals(6, getLevenshteinDistance("kitten", ""));
        }
//1
        @Test
        void testBothStringsEmpty() {
            assertEquals(0, getLevenshteinDistance("", ""));
        }
//+ ok test testing letter sensitivity
        @Test
        void testCaseSensitivity() {
            assertEquals(1, getLevenshteinDistance("Kitten", "kitten"));
        }
    //+ precondition test
        @Test
        void testNullFirstString() {
            assertThrows(IllegalArgumentException.class, () -> getLevenshteinDistance(null, "test"));
        }
    //+ precondition test
        @Test
        void testNullSecondString() {
            assertThrows(IllegalArgumentException.class, () -> getLevenshteinDistance("test", null));
        }
    //+ precondition test
        @Test
        void testNullBothStrings() {
            assertThrows(IllegalArgumentException.class, () -> getLevenshteinDistance(null, null));
        }
}
//Number of test: 12
// 5 matches
//Number of test match:5,8,3,2,1
//+ New test scenarios:5
//Number duplicate:0
