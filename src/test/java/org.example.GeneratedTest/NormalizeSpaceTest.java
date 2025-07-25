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

import static org.apache.commons.lang3.StringUtils.normalizeSpace;

import static org.junit.jupiter.api.Assertions.*;

public class NormalizeSpaceTest {

    @Test
    void testNullInput() {
        assertNull(normalizeSpace(null), "Null input should return null");
    }

    @Test
    void testEmptyString() {
        assertEquals("", normalizeSpace(""), "Empty string should return empty string");
    }

    @Test
    void testWhitespaceOnly() {
        assertEquals("", normalizeSpace("   "), "Whitespace-only string should return empty string");
    }

    @Test
    void testLeadingAndTrailingWhitespace() {
        assertEquals("Hello World", normalizeSpace("   Hello World   "), "Should trim leading and trailing whitespace");
    }

    @Test
    void testMultipleInternalSpaces() {
        assertEquals("Hello World", normalizeSpace("Hello    World"), "Should reduce multiple spaces to single space");
    }

    @Test
    void testMixedTabsAndSpaces() {
        assertEquals("Hello World", normalizeSpace("Hello\t\tWorld"), "Should normalize tabs to single space");
    }

    @Test
    void testNewlinesAndSpaces() {
        assertEquals("Hello World Example", normalizeSpace(" Hello \n World \r\n Example "), "Should normalize newlines and spaces");
    }

    @Test
    void testUnicodeNonBreakingSpace() {
        assertEquals("Hello World", normalizeSpace("Hello\u00A0World"), "Should convert non-breaking spaces to normal spaces");
    }

    @Test
    void testMultipleMixedWhitespaceSequences() {
        assertEquals("A B C D", normalizeSpace("  A\t\tB \n C   D  "), "Should normalize mixed whitespace sequences");
    }

    @Test
    void testSingleWordNoWhitespace() {
        assertEquals("Hello", normalizeSpace("Hello"), "Should leave single word unchanged");
    }

    @Test
    void testAllWhitespaceCharacters() {
        String input = " \t\n\r\f";
        assertEquals("", normalizeSpace(input), "Should return empty string for all whitespace characters");
    }

    @Test
    void testTrailingWhitespaceOnly() {
        assertEquals("Hello", normalizeSpace("Hello    "), "Should trim trailing whitespace");
    }

    @Test
    void testLeadingWhitespaceOnly() {
        assertEquals("Hello", normalizeSpace("   Hello"), "Should trim leading whitespace");
    }

    @Test
    void testWhitespaceBetweenWords() {
        assertEquals("A B", normalizeSpace("A  \t  B"), "Should normalize mixed spaces between words");
    }

    @Test
    void testNoSpacesToNormalize() {
        assertEquals("ABC", normalizeSpace("ABC"), "Should leave string unchanged if no spaces to normalize");
    }

//    @Test
//    void testMultipleNonBreakingSpaces() {
//        assertEquals("A B C", normalizeSpace("\u00A0A\u00A0\u00A0B\u00A0C\u00A0"), "Should normalize multiple non-breaking spaces");
//    }

    @Test
    void testLongStringWithRandomWhitespace() {
        String input = "   This   is \t a \n test \r\n string   ";
        String expected = "This is a test string";
        assertEquals(expected, normalizeSpace(input), "Should normalize complex random whitespace");
    }

}
