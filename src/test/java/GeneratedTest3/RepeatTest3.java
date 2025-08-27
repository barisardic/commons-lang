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
package GeneratedTest3;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class RepeatTest3 {
    // Assume EMPTY is defined in the same class
    private static final String EMPTY = "";
    private static final int PAD_LIMIT = 8192;
//1
    @Test
    public void testRepeat_NullInput() {
        assertNull(StringUtils.repeat(null, 5));
    }
//5
    @Test
    public void testRepeat_NegativeCount() {
        assertEquals(EMPTY, StringUtils.repeat("abc", -3));
    }
//2
    @Test
    public void testRepeat_ZeroCount() {
        assertEquals(EMPTY, StringUtils.repeat("abc", 0));
    }
//3
    @Test
    public void testRepeat_EmptyString() {
        assertEquals("", StringUtils.repeat("", 10));
    }
//+ Tests single-repetition edge case
    @Test
    public void testRepeat_SingleCount() {
        assertEquals("abc", StringUtils.repeat("abc", 1));
    }

//+ Tests PAD_LIMIT boundary, bad test case
//    @Test
//    public void testRepeat_SingleCharBelowPadLimit() {
//        for (int i = 1; i <= 10; i++) {
//            assertEquals(repeat('x', i), StringUtils.repeat("x", i));
//        }
//    }


//+ Tests above PAD_LIMIT boundary, bad test case
//    @Test
//    public void testRepeat_SingleCharAbovePadLimit() {
//        int highCount = PAD_LIMIT + 100;
//        String expected = repeat('z', highCount);
//        assertEquals(expected, StringUtils.repeat("z", highCount));
//    }


//6
    @Test
    public void testRepeat_TwoCharString() {
        assertEquals("abababab", StringUtils.repeat("ab", 4));
        assertEquals("cdcdcd", StringUtils.repeat("cd", 3));
    }
//7
    @Test
    public void testRepeat_MultiCharString() {
        assertEquals("helloworldhelloworld", StringUtils.repeat("helloworld", 2));
        assertEquals("xyzxyzxyzxyz", StringUtils.repeat("xyz", 4));
    }
    //+ Tries to test special, bad test case
    @Test
    public void testRepeat_SpecialCharacters() {
        assertEquals("!@#!@#!@#", StringUtils.repeat("!@#", 3));
    }
    //+ Tries to test unicode but input is not unicode, bad test case
    @Test
    public void testRepeat_UnicodeCharacters() {
        assertEquals("???", StringUtils.repeat("?", 3));
    }
    //+ 8,9 (semantically its one case, which the long string scenario)
    @Test
    public void testRepeat_LongString() {
        String unit = "abcdef";
        int count = 100;
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < count; i++) {
            expected.append(unit);
        }
        assertEquals(expected.toString(), StringUtils.repeat(unit, count));
    }
}
//Number of test:14
//Number of test match:8
//New test scenarios:4
//Number duplicate:0

