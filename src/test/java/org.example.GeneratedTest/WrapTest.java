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
import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.text.WordUtils;
import org.junit.jupiter.api.Test;
public class WrapTest {
    @Test
    void testNullInput() {
        assertNull(WordUtils.wrap(null, 10, "\n", true, " "));
    }

    @Test
    void testEmptyString() {
        assertEquals("", WordUtils.wrap("", 10, "\n", true, " "));
    }

    @Test
    void testWrapLengthLessThanOne() {
        String input = "a b c";
        String expected = "a\nb\nc";
        assertEquals(expected, WordUtils.wrap(input, 0, "\n", true, " "));
    }

    @Test
    void testNoWrapNeeded() {
        String input = "short";
        assertEquals("short", WordUtils.wrap(input, 10, "\n", true, " "));
    }

    @Test
    void testWrapAtSpaces() {
        String input = "The quick brown fox";
        String expected = "The quick\nbrown fox";
        assertEquals(expected,WordUtils.wrap(input, 10, "\n", true, " "));
    }

    @Test
    void testCustomNewLine() {
        String input = "The quick brown fox";
        String expected = "The quick--brown fox";
        assertEquals(expected, WordUtils.wrap(input, 10, "--", true, " "));
    }

    @Test
    void testWrapLongWordTrue() {
        String input = "Supercalifragilisticexpialidocious";
        String expected = "Supercalif\nragilistic\nexpialidoc\nious";
        assertEquals(expected, WordUtils.wrap(input, 10, "\n", true, " "));
    }

    @Test
    void testWrapLongWordFalse() {
        String input = "Supercalifragilisticexpialidocious";
        assertEquals(input, WordUtils.wrap(input, 10, "\n", false, " "));
    }

//    @Test
//    void testWrapWithCustomRegex() {
//        String input = "one,two,three,four";
//        String expected = "one,two,\nthree,four";
//        assertEquals(expected, WordUtils.wrap(input, 9, "\n", true, ","));  // break on comma
//    }
//
//    @Test
//    void testBlankWrapOnDefaultsToSpace() {
//        String input = "Hello world example";
//        String expected = "Hello\nworld\nexample";
//        assertEquals(expected, WordUtils.wrap(input, 6, "\n", true, "  "));  // blank string treated as space
//    }

    @Test
    void testStringWithoutBreakCharacters() {
        String input = "abcxyzdef";
        String expected = "abc\nxyz\ndef";
        assertEquals(expected, WordUtils.wrap(input, 3, "\n", true, " "));
    }

//    @Test
//    void testTrailingSpacesPreserved() {
//        String input = "  Leading and  trailing  ";
//        String expected = "  Leading\nand\ntrailing";
//        assertEquals(expected, WordUtils.wrap(input.trim(), 10, "\n", true, " "));
//    }

//    @Test
//    void testMultipleConsecutiveBreakChars() {
//        String input = "a  b    c";
//        String expected = "a\nb\nc";
//        assertEquals(expected, WordUtils.wrap(input, 2, "\n", true, " "));
//    }

//    @Test
//    void testVeryLongWordAtStart() {
//        String input = "AVeryLongWordWithoutSpaces that comes after";
//        String expected = "AVeryLongW\nordWithou\ntSpaces\nthat comes\nafter";
//        assertEquals(expected, WordUtils.wrap(input, 10, "\n", true, " "));
//    }
}
