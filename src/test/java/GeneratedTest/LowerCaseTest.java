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

import static org.apache.commons.lang3.StringUtils.lowerCase;

import static org.junit.jupiter.api.Assertions.*;

public class  LowerCaseTest {

    @Test
    void testNullInput() {
        assertNull(lowerCase(null), "Null input should return null");
    }

    @Test
    void testEmptyString() {
        assertEquals("", lowerCase(""), "Empty string should return empty string");
    }

    @Test
    void testLowerCaseString() {
        assertEquals("hello", lowerCase("hello"), "Lowercase string should remain unchanged");
    }

    @Test
    void testUpperCaseString() {
        assertEquals("hello", lowerCase("HELLO"), "Uppercase string should convert to lowercase");
    }

    @Test
    void testMixedCaseString() {
        assertEquals("hello world", lowerCase("HeLLo WoRLd"), "Mixed case string should convert to lowercase");
    }

    @Test
    void testStringWithNumbersAndSymbols() {
        assertEquals("abc123!@#", lowerCase("ABC123!@#"), "Numbers and symbols should remain unchanged");
    }

//    @Test
//    void testUnicodeCharacters() {
//        assertEquals("ñ", lowerCase("Ñ"), "Unicode characters should convert correctly");
//    }

    @Test
    void testWhitespaceOnlyString() {
        assertEquals("   ", lowerCase("   "), "Whitespace should remain unchanged");
    }

//    @Test
//    void testStringWithMixedUnicode() {
//        assertEquals("über café", lowerCase("ÜBER Café"), "Mixed ASCII and Unicode should convert correctly");
//    }
}
