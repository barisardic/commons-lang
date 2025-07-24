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

import static org.apache.commons.lang3.StringUtils.normalizeSpace;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class NormalizeSpaceTest {

    @Test
    void testNullInput() {
        assertNull(normalizeSpace(null));
    }

    @Test
    void testEmptyInput() {
        assertEquals("", normalizeSpace(""));
    }

    @Test
    void testOnlySpaces() {
        assertEquals("", normalizeSpace("     "));
    }

    @Test
    void testOnlyTabsAndNewlines() {
        assertEquals("", normalizeSpace("\t\n\r  \n"));
    }

    @Test
    void testSingleWordNoWhitespace() {
        assertEquals("hello", normalizeSpace("hello"));
    }

    @Test
    void testLeadingWhitespace() {
        assertEquals("hello", normalizeSpace("   hello"));
    }

    @Test
    void testTrailingWhitespace() {
        assertEquals("hello", normalizeSpace("hello   "));
    }

    @Test
    void testLeadingAndTrailingWhitespace() {
        assertEquals("hello", normalizeSpace("   hello   "));
    }

    @Test
    void testMultipleInternalWhitespace() {
        assertEquals("hello world", normalizeSpace("hello     world"));
    }

    @Test
    void testTabsAndNewlinesBetweenWords() {
        assertEquals("hello world", normalizeSpace("hello\t\n\r world"));
    }

    @Test
    void testMultipleWordsWithExcessiveWhitespace() {
        assertEquals("this is a test", normalizeSpace("   this   is\ta \n  test   "));
    }

    @Test
    void testNonBreakingSpaceReplaced() {
        assertEquals("a b", normalizeSpace("a" + (char)160 + "b"));
    }

    @Test
    void testNonBreakingSpaceWithSurroundingSpaces() {
        assertEquals("a b", normalizeSpace("  a" + (char)160 + "b   "));
    }

    @Test
    void testMixedWhitespaceVariants() {
        assertEquals("a b c", normalizeSpace("\na\tb  \rc"));
    }

    @Test
    void testWhitespaceInMiddleOnly() {
        assertEquals("a b", normalizeSpace("a     b"));
    }

    @Test
    void testSingleCharacterWhitespace() {
        assertEquals("", normalizeSpace(" "));
    }

    @Test
    void testSingleNonWhitespaceCharacter() {
        assertEquals("x", normalizeSpace("x"));
    }

    @Test
    void testWhitespaceAroundSingleCharacter() {
        assertEquals("x", normalizeSpace("   x   "));
    }

}
