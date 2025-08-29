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
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NormalizeSpaceTest3 {


//1
    @Test
    void testNullInput() {
        assertNull(StringUtils.normalizeSpace(null), "Expected null input to return null");
    }
//2
    @Test
    void testEmptyString() {
        assertEquals("", StringUtils.normalizeSpace(""), "Expected empty string to return empty");
    }


    @Test
    void testOnlyWhitespace() {
        //3
        assertEquals("", StringUtils.normalizeSpace("    "), "Expected spaces only to return empty");
        //4,5,8
        assertEquals("", StringUtils.normalizeSpace("\t\n\r "), "Expected mixed whitespace only to return empty");
    }
//9
    @Test
    void testLeadingAndTrailingWhitespace() {
        assertEquals("abc", StringUtils.normalizeSpace("   abc   "), "Expected leading/trailing whitespace trimmed");
    }
//10
    @Test
    void testInternalMultipleWhitespace() {
        assertEquals("a b c", StringUtils.normalizeSpace("a     b   c"), "Expected internal whitespace normalized to one space");
    }
//+ ok test no whitespace
    @Test
    void testNoWhitespace() {
        assertEquals("abc", StringUtils.normalizeSpace("abc"), "Expected unchanged for no whitespace");
    }
//duplicate
    @Test
    void testTabAndNewlineWhitespace() {
        assertEquals("a b c", StringUtils.normalizeSpace("a\tb\nc"), "Expected tabs/newlines normalized to space");
    }
//duplicate of 12
    @Test
    void testNonBreakingSpace() {
        char nbsp = (char) 160;
        assertEquals("a b", StringUtils.normalizeSpace("a" + nbsp + "b"), "Expected non-breaking space to be replaced with normal space");
    }
//duplicate
    @Test
    void testComplexMixedWhitespace() {
        String input = " \t a \n  b \r\n  c \t ";
        String expected = "a b c";
        assertEquals(expected, StringUtils.normalizeSpace(input), "Expected all types of whitespace normalized");
    }
//+ok test, non-space special chars preserved
    @Test
    void testStringWithUnicodeCharacters() {
        assertEquals("á é ñ", StringUtils.normalizeSpace("á   é   ñ"), "Expected unicode preserved and whitespace normalized");
    }
//12, correct test for non-breaking space (char160) is not whitespace
/*    @Test
    void testStringWithSurroundingNonBreakingSpaces() {
        char nbsp = (char) 160;
        assertEquals("x y", StringUtils.normalizeSpace(nbsp + "x" + nbsp + " " + nbsp + "y" + nbsp), "Expected surrounding nbsp converted and normalized");
    }*/

    @Test
    void testSingleCharacterWhitespace() {
        //duplicate of 3
        assertEquals("", StringUtils.normalizeSpace(" "), "Single space should return empty");
        //duplicate of 4
        assertEquals("", StringUtils.normalizeSpace("\t"), "Single tab should return empty");
    }
//+ ok test already normalized string (verifies idempotency)
    @Test
    void testAlreadyNormalizedString() {
        assertEquals("a b c", StringUtils.normalizeSpace("a b c"), "Already normalized string should remain unchanged");
    }
}
//15  generated assertions (with negatives)
// 15 scenarios
// 1 failing scenarios
// 1,2,3,4,5,8,9,10,12 matched
// 9 matches
// 5 duplicates
// 3 + [new] tests


