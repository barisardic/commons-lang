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
import static org.apache.commons.lang3.StringUtils.splitByWholeSeparatorWorker;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SplitByWholeSeparatorWorkerTest {
    // Helper: mimic ArrayHelpers.EMPTY_STRING_ARRAY if needed
    private static final String[] EMPTY_STRING_ARRAY = new String[0];

    // Helper: expose the private method via reflection for testing
    private String[] splitByWholeSeparatorWorker(
            String str, String separator, int max, boolean preserveAllTokens) {
        // This should be the actual call in your production code
        return StringUtils.splitByWholeSeparatorWorker(str, separator, max, preserveAllTokens);
    }

    @Test
    void testNullStringInputReturnsNull() {
        assertNull(splitByWholeSeparatorWorker(null, ",", -1, false));
    }

    @Test
    void testEmptyStringReturnsEmptyArray() {
        assertArrayEquals(EMPTY_STRING_ARRAY, splitByWholeSeparatorWorker("", ",", -1, false));
    }

    @Test
    void testNullSeparatorSplitsOnWhitespace() {
        String input = "one two  three";
        String[] expected = {"one", "two", "three"};
        assertArrayEquals(expected, splitByWholeSeparatorWorker(input, null, -1, false));
    }

    @Test
    void testEmptySeparatorSplitsOnWhitespace() {
        String input = "a b c";
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, splitByWholeSeparatorWorker(input, "", -1, false));
    }

    @Test
    void testSimpleSplit() {
        String input = "apple##banana##cherry";
        String[] expected = {"apple", "banana", "cherry"};
        assertArrayEquals(expected, splitByWholeSeparatorWorker(input, "##", -1, false));
    }

    @Test
    void testPreserveAllTokensTrueWithConsecutiveSeparators() {
        String input = "a##b####c";
        String[] expected = {"a", "b", "", "c"};
        assertArrayEquals(expected, splitByWholeSeparatorWorker(input, "##", -1, true));
    }

    @Test
    void testPreserveAllTokensFalseWithConsecutiveSeparators() {
        String input = "a##b####c";
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, splitByWholeSeparatorWorker(input, "##", -1, false));
    }

    @Test
    void testMaxLimitStopsSplitting() {
        String input = "x--y--z--w";
        String[] expected = {"x", "y", "z--w"};
        assertArrayEquals(expected, splitByWholeSeparatorWorker(input, "--", 3, false));
    }

    @Test
    void testSeparatorNotFoundReturnsWholeString() {
        String input = "hello world";
        String[] expected = {"hello world"};
        assertArrayEquals(expected, splitByWholeSeparatorWorker(input, "###", -1, false));
    }

    @Test
    void testTrailingSeparatorPreserveAllTokensTrue() {
        String input = "a::b::";
        String[] expected = {"a", "b", ""};
        assertArrayEquals(expected, splitByWholeSeparatorWorker(input, "::", -1, true));
    }
//
//    @Test
//    void testTrailingSeparatorPreserveAllTokensFalse() {
//        String input = "a::b::";
//        String[] expected = {"a", "b"};
//        assertArrayEquals(expected, splitByWholeSeparatorWorker(input, "::", -1, false));
//    }

    @Test
    void testSingleToken() {
        String input = "onlyone";
        String[] expected = {"onlyone"};
        assertArrayEquals(expected, splitByWholeSeparatorWorker(input, "--", -1, false));
    }

    @Test
    void testMaxLimitEqualsOne() {
        String input = "one##two##three";
        String[] expected = {"one##two##three"};
        assertArrayEquals(expected, splitByWholeSeparatorWorker(input, "##", 1, false));
    }

    @Test
    void testMaxLimitLargerThanTokens() {
        String input = "one##two";
        String[] expected = {"one", "two"};
        assertArrayEquals(expected, splitByWholeSeparatorWorker(input, "##", 5, false));
    }
}
