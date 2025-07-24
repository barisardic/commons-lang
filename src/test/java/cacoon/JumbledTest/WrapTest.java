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
import static org.junit.jupiter.api.Assertions.*;

import org.apache.commons.lang3.text.WordUtils;
import org.junit.jupiter.api.Test;
public class WrapTest {
    @Test
    void testNullTextReturnsNull() {
        String result = WordUtils.wrap(null, 10, "\n", true, " ");
        assertNull(result);
    }

    @Test
    void testNullLineSeparatorUsesSystemLineSeparator() {
        String input = "Hello world this is a test";
        String expected = String.join(System.lineSeparator(),
                "Hello",
                "world",
                "this",
                "is a",
                "test"
        );
        String result = WordUtils.wrap(input, 6, null, true, " ");
        assertEquals(expected, result);
    }

/*    @Test
    void testBlankDelimiterDefaultsToSpace() {
        String input = "A B C D E F G";
        String result = WordUtils.wrap(input, 3, "\n", true, "");
        assertTrue(result.contains("A\nB\nC"));
    }*/

    @Test
    void testLineLengthLimitLessThanOneDefaultsToOne() {
        String input = "abc def";
        String result = WordUtils.wrap(input, 0, "\n", true, " ");
        assertTrue(result.length() > 0); // Should not crash or return ""
    }

    @Test
    void testNormalWrappingWithSpaceDelimiter() {
        String input = "The quick brown fox jumps over the lazy dog";
        String expected = String.join("\n",
                "The quick",
                "brown fox",
                "jumps over",
                "the lazy",
                "dog"
        );
        String result = WordUtils.wrap(input, 10, "\n", true, " ");
        assertEquals(expected, result);
    }

    @Test
    void testWordTooLongWithoutWrapping() {
        String input = "ShortWord Supercalifragilisticexpialidocious ShortAgain";
        String expected = String.join("\n",
                "ShortWord",
                "Supercalifragilisticexpialidocious",
                "ShortAgain"
        );
        String result = WordUtils.wrap(input, 10, "\n", false, " ");
        assertEquals(expected, result);
    }

    @Test
    void testWordTooLongWithWrappingEnabled() {
        String input = "ShortWord Supercalifragilisticexpialidocious ShortAgain";
        String result = WordUtils.wrap(input, 10, "\n", true, " ");

        assertTrue(result.contains("Supercalif")); // first part
        assertTrue(result.contains("ragilistic")); // middle
        assertTrue(result.contains("expialidoc")); // chunked wrap
    }

    @Test
    void testCustomDelimiter() {
        String input = "apple|banana|cherry|date";
        String expected = String.join("\n",
                "apple|banana",
                "cherry|date"
        );
        String result = WordUtils.wrap(input, 13, "\n", true, "\\|");
        assertEquals(expected, result);
    }

    @Test
    void testSingleLineNoWrap() {
        String input = "short";
        String result = WordUtils.wrap(input, 10, "\n", true, " ");
        assertEquals("short", result);
    }

    @Test
    void testTrailingSpaceNotCausingBlankLine() {
        String input = "word1 word2 ";
        String result = WordUtils.wrap(input, 6, "\n", true, " ");
        assertFalse(result.endsWith("\n"));
    }

    @Test
    void testExactLineFit() {
        String input = "1234567890";
        String result = WordUtils.wrap(input, 10, "\n", true, " ");
        assertEquals("1234567890", result);
    }

    @Test
    void testLongInputPerformance() {
        StringBuilder longText = new StringBuilder();
        for (int i = 0; i < 1000; i++) {
            longText.append("word").append(i).append(" ");
        }
        String result = WordUtils.wrap(longText.toString(), 50, "\n", true, " ");
        assertNotNull(result);
        assertTrue(result.contains("word"));
    }
}
