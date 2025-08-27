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
package GeneratedTest3;
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.chomp;
import static org.junit.jupiter.api.Assertions.*;

public class ChompTest3 {
    // Helper constants simulating CharUtils
    private static final char CR = '\r';
    private static final char LF = '\n';


    // --- Test cases ---
//14
    @Test
    public void testNullInput() {
        assertNull(chomp(null));
    }
//13
    @Test
    public void testEmptyString() {
        assertEquals("", chomp(""));
    }
//11
    @Test
    public void testSingleCR() {
        assertEquals("", chomp("\r"));
    }
//10
    @Test
    public void testSingleLF() {
        assertEquals("", chomp("\n"));
    }
//5
    @Test
    public void testSingleCharNonNewline() {
        assertEquals("a", chomp("a"));
    }
//1
    @Test
    public void testCRLFEnding() {
        assertEquals("line", chomp("line\r\n"));
    }
//2
    @Test
    public void testLFSoloEnding() {
        assertEquals("line", chomp("line\n"));
    }
//3
    @Test
    public void testCRSoloEnding() {
        assertEquals("line", chomp("line\r"));
    }
//duplicate of 5
    @Test
    public void testNoNewlineAtEnd() {
        assertEquals("line", chomp("line"));
    }
//8
    @Test
    public void testEmbeddedNewlinesOnlyRemoveFinal() {
        assertEquals("line1\nline2", chomp("line1\nline2\n"));
    }
    //+ good test, testing if string is trimmed in the method.
    @Test
    public void testEmbeddedCRLFOnlyRemoveFinal() {
        assertEquals("line1\r\nline2", chomp("line1\r\nline2\r\n"));
    }
//6
    @Test
    public void testMultipleNewlines() {
        assertEquals("hello\n\n", chomp("hello\n\n\n"));
    }

}

// 12 generated assertions (with negatives)
// 12 scenarios
// 0 failing scenarios
// 14,13,11,10,5,1,2,3,8,6 matched
// 10 matches
// 1 duplicates
// 1 + [new] tests
