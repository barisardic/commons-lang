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

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.repeat;
import static org.apache.commons.lang3.StringUtils.EMPTY;

import static org.junit.jupiter.api.Assertions.*;

public class RepeatTest {
    private static final int PAD_LIMIT = 8192; // assumed value; adjust if needed
    @Test
    void testNullInput() {
        assertNull(repeat(null, 3));
    }

    @Test
    void testZeroTimes() {
        assertEquals(EMPTY, repeat("abc", 0));
    }

    @Test
    void testNegativeTimes() {
        assertEquals(EMPTY, repeat("abc", -1));
    }

    @Test
    void testEmptyInput() {
        assertEquals(EMPTY, repeat("", 5));
    }

    @Test
    void testTimesEqualsOne() {
        assertEquals("abc", repeat("abc", 1));
    }

    @Test
    void testSingleCharBelowPadLimit() {
        assertEquals("aaa", repeat("a", 3));
    }

/*    @Test
    void testSingleCharEqualsPadLimit() {
        assertEquals("a".repeat(PAD_LIMIT), repeat("a", PAD_LIMIT));
    }*/

    @Test
    void testTwoCharString() {
        assertEquals("ababab", repeat("ab", 3));
    }

    @Test
    void testThreeCharString() {
        assertEquals("xyzxyzxyz", repeat("xyz", 3));
    }

    @Test
    void testLongerString() {
        String input = "hello";
        int times = 4;
        String expected = "hellohellohellohello";
        assertEquals(expected, repeat(input, times));
    }

/*    @Test
    void testPadLimitExceededForSingleChar() {
        String input = "x";
        int times = PAD_LIMIT + 1;
        String result = repeat(input, times);
        assertEquals("x".repeat(times), result);
    }*/

}
