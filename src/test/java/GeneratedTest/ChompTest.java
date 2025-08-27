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
import static org.junit.jupiter.api.Assertions.*;
public class ChompTest {

//14
    @Test
    void testNullInput() {
        assertNull(StringUtils.chomp(null));
    }
//13
    @Test
    void testEmptyString() {
        assertEquals("", StringUtils.chomp(""));
    }
//11
    @Test
    void testSingleCR() {
        assertEquals("", StringUtils.chomp("\r"));
    }
//10
    @Test
    void testSingleLF() {
        assertEquals("", StringUtils.chomp("\n"));
    }
//5
    @Test
    void testSingleCharacterNonNewline() {
        assertEquals("a", StringUtils.chomp("a"));
    }
//2
    @Test
    void testEndsWithLF() {
        assertEquals("hello", StringUtils.chomp("hello\n"));
    }
//1
    @Test
    void testEndsWithCRLF() {
        assertEquals("hello", StringUtils.chomp("hello\r\n"));
    }
//3
    @Test
    void testEndsWithCR() {
        assertEquals("hello", StringUtils.chomp("hello\r"));
    }
//duplicate of 5
    @Test
    void testNoTrailingNewline() {
        assertEquals("hello", StringUtils.chomp("hello"));
    }
//12
    @Test
    void testOnlyCRLF() {
        assertEquals("", StringUtils.chomp("\r\n"));
    }
//8
    @Test
    void testMultipleLines() {
        assertEquals("line1\nline2", StringUtils.chomp("line1\nline2\n"));
    }
    // + ok test, internal \r\n
    @Test
    void testMultipleLinesWithCRLF() {
        assertEquals("line1\r\nline2", StringUtils.chomp("line1\r\nline2\r\n"));
    }
//+ good test, testing if string is trimmed in the method.
    @Test
    void testWhitespaceAfterNewline() {
        assertEquals("test\n ", StringUtils.chomp("test\n "));
    }
// 15
//    @Test
//    void testEndsWithLFThenCR() {
//        // Edge case: unlikely but checks logic
//        assertEquals("abc\n\r", StringUtils.chomp("abc\n\r"));
//    }

}
// 14 generated assertions (with negatives)
// 14 scenarios
// 1 failing scenarios
// 14,13,11,10,5,2,1,3,12,8,15 matched
// 11 matches
// 1 duplicates
// 2 + [new] tests
