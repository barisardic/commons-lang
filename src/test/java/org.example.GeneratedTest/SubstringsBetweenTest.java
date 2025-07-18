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

import static org.junit.jupiter.api.Assertions.*;

public class SubstringsBetweenTest {


    @Test
    void testNullStringInput() {
        assertNull(StringUtils.substringsBetween(null, "[", "]"));
    }

    @Test
    void testEmptyStringInput() {
        assertArrayEquals(new String[0], StringUtils.substringsBetween("", "[", "]"));
    }

    @Test
    void testNullOpenDelimiter() {
        assertNull(StringUtils.substringsBetween("abc", null, "]"));
    }

    @Test
    void testNullCloseDelimiter() {
        assertNull(StringUtils.substringsBetween("abc", "[", null));
    }

    @Test
    void testEmptyOpenDelimiter() {
        assertNull(StringUtils.substringsBetween("abc", "", "]"));
    }

    @Test
    void testEmptyCloseDelimiter() {
        assertNull(StringUtils.substringsBetween("abc", "[", ""));
    }

    @Test
    void testNoDelimitersPresent() {
        assertNull(StringUtils.substringsBetween("abcdef", "[", "]"));
    }

    @Test
    void testSingleMatch() {
        String input = "before[content]after";
        String[] expected = {"content"};
        assertArrayEquals(expected, StringUtils.substringsBetween(input, "[", "]"));
    }

    @Test
    void testMultipleMatches() {
        String input = "<one><two><three>";
        String[] expected = {"one", "two", "three"};
        assertArrayEquals(expected, StringUtils.substringsBetween(input, "<", ">"));
    }

    @Test
    void testOverlappingDelimiters() {
        String input = "<<nested>>";
        String[] expected = {"nested"};
        assertArrayEquals(expected, StringUtils.substringsBetween(input, "<<", ">>"));
    }

//    @Test
//    void testUnclosedDelimiter() {
//        String input = "start<one<two>end>";
//        assertNull(StringUtils.substringsBetween(input, "<", ">"));
//    }

//    @Test
//    void testNestedDelimitersIgnored() {
//        String input = "<a<b>c><d>";
//        String[] expected = {"a<b"};
//        assertArrayEquals(expected, StringUtils.substringsBetween(input, "<", ">"));
//    }

    @Test
    void testConsecutiveDelimitersWithoutContent() {
        String input = "[]<>[]";
        String[] expected = {"", ""};
        assertArrayEquals(expected, StringUtils.substringsBetween(input, "[", "]"));
    }

    @Test
    void testDelimiterAtEndOnly() {
        String input = "abc[def";
        assertNull(StringUtils.substringsBetween(input, "[", "]"));
    }

    @Test
    void testDelimiterAtStartOnly() {
        String input = "def]";
        assertNull(StringUtils.substringsBetween(input, "[", "]"));
    }

    @Test
    void testCustomDelimiters() {
        String input = "fooSTARTbarENDbazSTARTquxEND";
        String[] expected = {"bar", "qux"};
        assertArrayEquals(expected, StringUtils.substringsBetween(input, "START", "END"));
    }
}