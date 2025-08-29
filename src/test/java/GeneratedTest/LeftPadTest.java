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

import static org.apache.commons.lang3.StringUtils.leftPad;

import static org.junit.jupiter.api.Assertions.*;

public class LeftPadTest {
//1
    @Test
    void testNullInput() {
        assertNull(leftPad(null, 5, "*"), "Null input should return null");
    }
//7
    @Test
    void testPadSizeLessThanStringLength() {
        assertEquals("Hello", leftPad("Hello", 3, "*"), "Should return original string if size is less than length");
    }
// + ok test, size=str.length() no padding
    @Test
    void testPadSizeEqualToStringLength() {
        assertEquals("Hello", leftPad("Hello", 5, "*"), "Should return original string if size equals length");
    }
//9
    @Test
    void testPadWithNullPadStr() {
        assertEquals("   Hi", leftPad("Hi", 5, null), "Null padStr should pad with spaces");
    }
//10
    @Test
    void testPadWithEmptyPadStr() {
        assertEquals("   Hi", leftPad("Hi", 5, ""), "Empty padStr should pad with spaces");
    }
//4
    @Test
    void testPadWithSingleCharacterPadStr() {
        assertEquals("***Hi", leftPad("Hi", 5, "*"), "Should pad correctly with single character padStr");
    }
//5
    @Test
    void testPadWithMultiCharacterPadStrExactlyMatchingPads() {
        assertEquals("abHi", leftPad("Hi", 4, "ab"), "Should pad exactly with padStr when pads == padStr length");
    }
//6
    @Test
    void testPadWithMultiCharacterPadStrSmallerThanPadLength() {
        assertEquals("aHi", leftPad("Hi", 3, "ab"), "Should truncate padStr to fit");
    }
//duplicate of 4
    @Test
    void testPadWithMultiCharacterPadStrLargerThanPadLength() {
        assertEquals("ababaHi", leftPad("Hi", 7, "ab"), "Should repeat padStr to fill pads");
    }
//duplicate of 4
    @Test
    void testPadWithSpacePadStr() {
        assertEquals("   Hi", leftPad("Hi", 5, " "), "Should pad with spaces when padStr is space");
    }
//duplicate of 7
    @Test
    void testZeroSize() {
        assertEquals("Hi", leftPad("Hi", 0, "*"), "Should return original string if size is zero");
    }
//8
    @Test
    void testNegativeSize() {
        assertEquals("Hi", leftPad("Hi", -5, "*"), "Should return original string if size is negative");
    }
// + ok test padding unicode symbol
/*    @Test
    void testPadWithUnicodePadStr() {
        assertEquals("★☆★Hi", leftPad("Hi", 5, "★☆"), "Should repeat Unicode padStr correctly");
    }*/

//duplicate of 6
    @Test
    void testPadWhenPadStrIsLongerThanPadsNeeded() {
        assertEquals("abHi", leftPad("Hi", 4, "abc"), "Should truncate padStr to required pad length");
    }
//duplicate 4
    @Test
    void testPadStrLongerThanString() {
        assertEquals("abcabcHi", leftPad("Hi", 8, "abc"), "Should repeat padStr to reach total size");
    }
//duplicate of size=str.length() no padding
    @Test
    void testPadWhenNoPaddingIsNeeded() {
        assertEquals("Test", leftPad("Test", 4, "x"), "Should return original string when no padding needed");
    }
//duplicate of 9
    @Test
    void testPadWithDefaultSpacePad() {
        assertEquals("   Test", leftPad("Test", 7, null), "Should pad with spaces when padStr is null");
    }
// 17 generated assertions (with negatives)
// 17 scenarios
// 1 failing scenarios
// 1,7,9,10,4,5,6,8 matched
// 8 matches
// 7 duplicates
// 2 + [new] tests

}
