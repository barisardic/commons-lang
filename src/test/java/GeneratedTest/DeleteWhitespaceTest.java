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
import org.apache.commons.lang3.StringUtils;

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.deleteWhitespace;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class DeleteWhitespaceTest {

    @Test
    void testNullInput() {
        assertNull(deleteWhitespace(null), "Null input should return null");
    }

    @Test
    void testEmptyString() {
        assertEquals("", deleteWhitespace(""), "Empty string should return empty string");
    }

    @Test
    void testStringWithNoWhitespace() {
        assertEquals("HelloWorld", deleteWhitespace("HelloWorld"), "String with no whitespace should be unchanged");
    }

    @Test
    void testStringWithOnlySpaces() {
        assertEquals("", deleteWhitespace("     "), "String with only spaces should return empty string");
    }

    @Test
    void testStringWithTabsAndSpaces() {
        assertEquals("HelloWorld", deleteWhitespace(" \tHello \t World\t "), "Should remove tabs and spaces");
    }

    @Test
    void testStringWithNewlines() {
        assertEquals("HelloWorld", deleteWhitespace("\nHello\nWorld\n"), "Should remove newlines");
    }

    @Test
    void testStringWithMixedWhitespace() {
        assertEquals("ABC123DEF", deleteWhitespace(" A B\tC\n1 2\t3\rD E F "), "Should remove all kinds of whitespace");
    }

//    @Test
//    void testStringWithUnicodeWhitespace() {
//        assertEquals("ABC", deleteWhitespace("A\u2003B\u00A0C"), "Should remove Unicode whitespaces like EM SPACE and NBSP");
//    }

    @Test
    void testStringWithLeadingWhitespace() {
        assertEquals("Hello", deleteWhitespace("   Hello"), "Should remove leading whitespace");
    }

    @Test
    void testStringWithTrailingWhitespace() {
        assertEquals("Hello", deleteWhitespace("Hello   "), "Should remove trailing whitespace");
    }

    @Test
    void testStringWithWhitespaceOnlyBetweenWords() {
        assertEquals("HelloWorld", deleteWhitespace("Hello   World"), "Should remove whitespace between words");
    }

    @Test
    void testLongStringWithNoWhitespace() {
        String input = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        assertEquals(input, deleteWhitespace(input), "Long string with no whitespace should be unchanged");
    }

    @Test
    void testLongStringWithAllWhitespace() {

        String input = " \n\t\r " + org.apache.commons.lang3.StringUtils.repeat(" ", 100);

        assertEquals("", deleteWhitespace(input), "Long string with only whitespace should return empty string");
    }
}
