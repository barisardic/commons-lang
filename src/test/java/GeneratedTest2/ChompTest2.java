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
package GeneratedTest2;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChompTest2 {

//14
    @Test
void testNullInput() {
    assertNull(StringUtils.chomp(null), "Should return null when input is null");
}
//13
    @Test
    void testEmptyString() {
        assertEquals("", StringUtils.chomp(""), "Should return empty string when input is empty");
    }
//10
    @Test
    void testSingleLF() {
        assertEquals("", StringUtils.chomp("\n"), "Should return empty string for single LF");
    }
//11
    @Test
    void testSingleCR() {
        assertEquals("", StringUtils.chomp("\r"), "Should return empty string for single CR");
    }
//5
    @Test
    void testSingleNonNewlineChar() {
        assertEquals("a", StringUtils.chomp("a"), "Should return same single character if not newline");
    }
//1
    @Test
    void testEndsWithCRLF() {
        assertEquals("hello", StringUtils.chomp("hello\r\n"), "Should remove CRLF");
    }
//2
    @Test
    void testEndsWithLFOnly() {
        assertEquals("hello", StringUtils.chomp("hello\n"), "Should remove LF");
    }
//3
    @Test
    void testEndsWithCROnly() {
        assertEquals("hello", StringUtils.chomp("hello\r"), "Should remove CR");
    }
//duplicate of 5
    @Test
    void testNoNewlineAtEnd() {
        assertEquals("hello", StringUtils.chomp("hello"), "Should return unchanged string");
    }
//8
    @Test
    void testNewlineInMiddleOnly() {
        assertEquals("hello\nworld", StringUtils.chomp("hello\nworld"), "Should not remove middle newline");
    }
//duplicate of 2,8
    @Test
    void testMultipleNewlinesAtEnd() {
        assertEquals("line1\nline2", StringUtils.chomp("line1\nline2\n"), "Should remove only the final LF");
    }
//duplicate of 1
    @Test
    void testEndsWithCRLFAndExtraCR() {
        assertEquals("line\r", StringUtils.chomp("line\r\r\n"), "Should remove only final CRLF");
    }
}
//Number of test: 12
//Number of test match:9
//New test scenarios:1
//Number duplicate:2

// 12 generated assertions (with negatives)
// 12 scenarios
// 0 failing scenarios
// 14,13,10,11,5,1,2,3,8 matched
// 9 matches
// 3 duplicates
// 0 + [new] tests
