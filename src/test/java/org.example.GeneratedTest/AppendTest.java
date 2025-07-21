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

import org.apache.commons.lang3.text.FormattableUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.FormattableFlags;
import java.util.Formatter;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

public class AppendTest {

    private static String format(CharSequence seq, int flags, int width, int precision, char padChar, CharSequence ellipsis) {
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.US);
        FormattableUtils.append(seq, formatter, flags, width, precision, padChar, ellipsis);
        return sb.toString();
    }

    @Test
    public void testNoTruncationNoPadding() {
        String result = format("Hello", 0, 5, -1, ' ', null);
        assertEquals("Hello", result);
    }

    @Test
    public void testPaddingRightJustified() {
        String result = format("Hi", 0, 5, -1, '_', null);
        assertEquals("___Hi", result);
    }

    @Test
    public void testPaddingLeftJustified() {
        String result = format("Hi", FormattableFlags.LEFT_JUSTIFY, 5, -1, '_', null);
        assertEquals("Hi___", result);
    }

    @Test
    public void testTruncationNoEllipsis() {
        String result = format("HelloWorld", 0, 10, 5, ' ', null);
        assertEquals("     Hello", result);
    }

    @Test
    public void testTruncationWithEllipsis() {
        String result = format("HelloWorld", 0, 10, 7, ' ', "...");  // Will truncate to 7 chars: 4 + "..."
        assertEquals("   Hell...", result);
    }

    @Test
    public void testEllipsisEqualToPrecision() {
        String result = format("HelloWorld", 0, 10, 3, ' ', "..."); // Replaces all 3 with ellipsis
        assertEquals("       ...", result);
    }

    @Test
    public void testEllipsisNullFallsBackToEmpty() {
        String result = format("HelloWorld", 0, 10, 5, ' ', null); // Should truncate to "Hello"
        assertEquals("     Hello", result);
    }

    @Test
    public void testZeroWidth() {
        String result = format("Hi", 0, 0, -1, ' ', null);
        assertEquals("Hi", result);
    }

    @Test
    public void testPrecisionGreaterThanLength() {
        String result = format("Hi", 0, 4, 10, ' ', null);
        assertEquals("  Hi", result);
    }

    @Test
    public void testEllipsisLongerThanPrecisionThrows() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> {
            format("Hello", 0, 10, 2, ' ', "...");
        });
        assertTrue(ex.getMessage().contains("ellipsis"));
    }

    @Test
    public void testEmptyStringInput() {
        String result = format("", 0, 5, -1, '_', null);
        assertEquals("_____", result);
    }

    @Test
    public void testEllipsisEmptyString() {
        String result = format("ABCDEFG", 0, 8, 4, ' ', ""); // Should truncate without ellipsis
        assertEquals("    ABCD", result);
    }

    @Test
    public void testWidePaddingUnicodeChar() {
        String result = format("X", 0, 4, -1, '\u2022', null); // Padding with ?
        assertEquals("\u2022\u2022\u2022X", result);
    }

    @Test
    public void testLeftJustifyWithTruncationAndEllipsis() {
        String result = format("abcdefghij", FormattableFlags.LEFT_JUSTIFY, 10, 6, '.', "--");
        assertEquals("abcd--....", result);
    }
}
