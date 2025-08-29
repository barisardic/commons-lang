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
package GeneratedTest2;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GetLevenshteinDistanceTest2 {
    //+ ok test, identical word, distance 0
    @Test
    public void testIdenticalStrings() {
        assertEquals(0, StringUtils.getLevenshteinDistance("kitten", "kitten"));
    }

    //4
    @Test
    public void testCompletelyDifferentStrings() {
        assertEquals(6, StringUtils.getLevenshteinDistance("kitten", "orange"));
    }

    //3, weird but single deletion away
    @Test
    public void testSingleCharacterChange() {
        assertEquals(1, StringUtils.getLevenshteinDistance("kitten", "kittena".substring(0, 6) + "a"));
    }

    //duplicate of 3
    @Test
    public void testInsertion() {
        assertEquals(1, StringUtils.getLevenshteinDistance("abc", "abxc"));
    }

    //duplicate of 3
    @Test
    public void testDeletion() {
        assertEquals(1, StringUtils.getLevenshteinDistance("abcd", "acd"));
    }

    //8
    @Test
    public void testSubstitution() {
        assertEquals(1, StringUtils.getLevenshteinDistance("abc", "axc"));
    }

    //2
    @Test
    public void testEmptyFirstString() {
        assertEquals(4, StringUtils.getLevenshteinDistance("", "test"));
    }
    //2
    @Test
    public void testEmptySecondString() {
        assertEquals(3, StringUtils.getLevenshteinDistance("abc", ""));
    }

    //1
    @Test
    public void testBothStringsEmpty() {
        assertEquals(0, StringUtils.getLevenshteinDistance("", ""));
    }

    //+ precondition test,, s null
    @Test
    public void testNullFirstStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getLevenshteinDistance(null, "abc"));
    }

    //+ precondition test, t null
    @Test
    public void testNullSecondStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getLevenshteinDistance("abc", null));
    }

    //6
    @Test
    public void testSymmetry() {
        String a = "gumbo";
        String b = "gambol";
        assertEquals(
                StringUtils.getLevenshteinDistance(a, b),
                StringUtils.getLevenshteinDistance(b, a)
        );
    }
/*
// + ok test, large string
    @Test
    public void testLargeStrings() {
        String a = "a".repeat(1000);
        String b = "a".repeat(999) + "b";
        assertEquals(1, StringUtils.getLevenshteinDistance(a, b));
    }
*/
}
// 13 generated assertions (with negatives)
// 13 scenarios
// 1 failing scenarios
// 4,3,8,2,1,6 matched
// 6 matches
// 2 duplicates
// 4 + [new] tests
