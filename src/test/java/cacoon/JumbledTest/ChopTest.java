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

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.chop;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ChopTest {

    @Test
    public void testNullInput() {
        assertNull(chop(null));
    }

    @Test
    public void testShortInputLengthLessThan2() {
        assertEquals(StringUtils.EMPTY, chop("a"));
        assertEquals(StringUtils.EMPTY, chop(""));
    }

    @Test
    public void testNoSpecialEnding() {
        assertEquals("Hell", chop("Hello"));
        assertEquals("Tes", chop("Test"));
    }

    @Test
    public void testEndsWithCRLF() {
        // '\r' = CR, '\n' = LF
        assertEquals("Line", chop("Line\r\n"));
    }

/*    @Test
    public void testEndsWithOnlyLF() {
        assertEquals("Line\r", chop("Line\r\n\n")); // not CR+LF at the end
    }*/

    @Test
    public void testCRLFInMiddleButNotAtEnd() {
        assertEquals("Middle\r\nTex", chop("Middle\r\nText"));
    }

    @Test
    public void testCRLFWithoutTrailingLF() {
        assertEquals("Abc\r", chop("Abc\rX"));
    }
}
