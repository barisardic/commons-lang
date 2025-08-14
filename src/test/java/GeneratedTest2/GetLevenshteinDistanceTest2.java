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
    //+ ok test
    @Test
    public void testIdenticalStrings() {
        assertEquals(0, StringUtils.getLevenshteinDistance("kitten", "kitten"));
    }

    //4
    @Test
    public void testCompletelyDifferentStrings() {
        assertEquals(6, StringUtils.getLevenshteinDistance("kitten", "orange"));
    }

    //+
    @Test
    public void testSingleCharacterChange() {
        assertEquals(1, StringUtils.getLevenshteinDistance("kitten", "kittena".substring(0, 6) + "a"));
    }

    //3
    @Test
    public void testInsertion() {
        assertEquals(1, StringUtils.getLevenshteinDistance("abc", "abxc"));
    }

    //3
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

    //+ precondition test
    @Test
    public void testNullFirstStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getLevenshteinDistance(null, "abc"));
    }

    //+ precondition test
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
//+ ok test
    @Test
    public void testLargeStrings() {
        String a = "a".repeat(1000);
        String b = "a".repeat(999) + "b";
        assertEquals(1, StringUtils.getLevenshteinDistance(a, b));
    }
*/
}
//Number of test: 13
//matches 4 3 8 2 1
//Number of test match:5
//New test scenarios:5
//Number duplicate:0