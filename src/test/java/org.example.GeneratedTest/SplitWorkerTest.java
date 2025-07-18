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

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.splitWorker ;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SplitWorkerTest {

    @Test
    void testNullInputReturnsNull() {
        assertNull(splitWorker(null, null, -1, false));
    }

    @Test
    void testEmptyInputReturnsEmptyArray() {
        assertArrayEquals(new String[0], splitWorker("", null, -1, false));
    }

    @Test
    void testWhitespaceSeparator() {
        String input = "a b  c   d";
        assertArrayEquals(new String[]{"a", "b", "c", "d"}, splitWorker(input, null, -1, false));
        assertArrayEquals(new String[]{"a", "b", "", "c", "", "", "d"}, splitWorker(input, null, -1, true));
    }

    @Test
    void testSingleCharacterSeparator() {
        String input = "a,b,,c,";
        assertArrayEquals(new String[]{"a", "b", "c"}, splitWorker(input, ",", -1, false));
        assertArrayEquals(new String[]{"a", "b", "", "c", ""}, splitWorker(input, ",", -1, true));
    }

    @Test
    void testMultipleSeparators() {
        String input = "a:b,c;d";
        assertArrayEquals(new String[]{"a", "b", "c", "d"}, splitWorker(input, ":,;", -1, false));
        assertArrayEquals(new String[]{"a", "b", "c", "d"}, splitWorker(input, ":,;", -1, true));
    }

    @Test
    void testPreserveAllTokensTrue() {
        String input = ",,a,,b,,";
        assertArrayEquals(new String[]{"", "", "a", "", "b", "", ""}, splitWorker(input, ",", -1, true));
    }

    @Test
    void testPreserveAllTokensFalse() {
        String input = ",,a,,b,,";
        assertArrayEquals(new String[]{"a", "b"}, splitWorker(input, ",", -1, false));
    }

    @Test
    void testMaxParameterLimit() {
        String input = "a,b,c,d";
        assertArrayEquals(new String[]{"a", "b", "c,d"}, splitWorker(input, ",", 3, false));
        assertArrayEquals(new String[]{"a", "b", "c", "d"}, splitWorker(input, ",", 4, false));
        assertArrayEquals(new String[]{"a,b,c,d"}, splitWorker(input, ",", 1, false));
    }

    @Test
    void testLeadingAndTrailingSeparators() {
        String input = ",a,b,c,";
        assertArrayEquals(new String[]{"a", "b", "c"}, splitWorker(input, ",", -1, false));
        assertArrayEquals(new String[]{"", "a", "b", "c", ""}, splitWorker(input, ",", -1, true));
    }

    @Test
    void testNoSeparatorsPresent() {
        String input = "abc";
        assertArrayEquals(new String[]{"abc"}, splitWorker(input, ",", -1, false));
    }

    @Test
    void testMaxWithPreserveAllTokensTrue() {
        String input = "a,,b,,c,,";
        assertArrayEquals(new String[]{"a", "", "b,,c,,"}, splitWorker(input, ",", 3, true));
    }

    @Test
    void testSeparatorAtStringEnds() {
        String input = "abc ";
        assertArrayEquals(new String[]{"abc"}, splitWorker(input, null, -1, false));
        assertArrayEquals(new String[]{"abc"}, splitWorker(input, " ", -1, false));
        assertArrayEquals(new String[]{"abc", ""}, splitWorker(input, " ", -1, true));
    }
}
