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

import static org.apache.commons.lang3.StringUtils.leftPad;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class LeftPadTest {

    @Test
    public void testNullInput() {
        assertNull(leftPad(null, 10, "*"));
    }

    @Test
    public void testEmptyPaddingDefaultsToSpace() {
        assertEquals("   foo", leftPad("foo", 6, ""));
    }

    @Test
    public void testNoPaddingNeededWhenLengthIsLessThanInput() {
        assertEquals("foobar", leftPad("foobar", 3, "-"));
    }

    @Test
    public void testExactLengthNoPaddingNeeded() {
        assertEquals("bar", leftPad("bar", 3, "*"));
    }

    @Test
    public void testSingleCharPaddingWithinLimit() {
        assertEquals("*****bar", leftPad("bar", 8, "*"));
    }

    @Test
    public void testMultiCharPaddingExactFit() {
        assertEquals("XYZbar", leftPad("bar", 6, "XYZ"));
    }

    @Test
    public void testMultiCharPaddingTruncation() {
        assertEquals("XYbar", leftPad("bar", 5, "XYZ"));
    }

    @Test
    public void testMultiCharPaddingRepeated() {
        assertEquals("ABABAbar", leftPad("bar", 8, "AB"));
    }

    @Test
    public void testPaddingWithWhitespace() {
        assertEquals("    bar", leftPad("bar", 7, " "));
    }

    @Test
    public void testPaddingLengthEqualsZero() {
        assertEquals("data", leftPad("data", 0, "-"));
    }

    @Test
    public void testPaddingLengthNegative() {
        assertEquals("data", leftPad("data", -5, "-"));
    }

    @Test
    public void testEmptyInput() {
        assertEquals("***", leftPad("", 3, "*"));
    }

    @Test
    public void testEmptyInputEmptyPadding() {
        assertEquals("   ", leftPad("", 3, ""));
    }

}
