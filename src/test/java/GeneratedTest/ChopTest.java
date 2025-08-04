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

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.chop;

import static org.junit.jupiter.api.Assertions.*;

public class ChopTest {

    @Test
    void testNullInput() {
        assertNull(chop(null), "Null input should return null");
    }

    @Test
    void testEmptyString() {
        assertEquals("", chop(""), "Empty string should return empty string");
    }

    @Test
    void testSingleCharacterString() {
        assertEquals("", chop("A"), "Single character string should return empty string");
    }

    @Test
    void testTwoCharacterString() {
        assertEquals("A", chop("AB"), "Two character string should return first character");
    }

    @Test
    void testNormalString() {
        assertEquals("Hell", chop("Hello"), "Chop should remove last character");
    }

    @Test
    void testStringWithCRLF() {
        assertEquals("Hello", chop("Hello\r\n"), "CRLF ending should remove both characters");
    }

    @Test
    void testStringWithLFOnly() {
        assertEquals("Hello", chop("Hello\n"), "LF ending should remove only LF");
    }

    @Test
    void testStringWithCROnly() {
        assertEquals("Hello", chop("Hello\r"), "CR only should be treated as normal character");
    }

    @Test
    void testStringWithMultipleCRLFSequences() {
        assertEquals("Line1\r\nLine2", chop("Line1\r\nLine2\r\n"), "Should only chop last CRLF");
    }

    @Test
    void testStringWithTrailingWhitespace() {
        assertEquals("Hello ", chop("Hello  "), "Should chop only one character");
    }
}
