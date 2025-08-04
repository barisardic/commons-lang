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

import static org.apache.commons.lang3.StringUtils.substring;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SubStringTest {



    // Reference to the EMPTY constant (as in the original code)
    private static final String EMPTY = "";

    @Test
    void testNullInputReturnsNull() {
        assertNull(substring(null, 0, 5));
    }

    @Test
    void testEmptyInputReturnsEmpty() {
        assertEquals(EMPTY, substring("", 0, 5));
    }

    @Test
    void testPositiveIndicesWithinBounds() {
        assertEquals("llo", substring("Hello World", 2, 5));
    }

    @Test
    void testNegativeBeginIndex() {
        assertEquals("orld", substring("Hello World", -4, 11));
    }

/*    @Test
    void testNegativeFinishIndex() {
        assertEquals("Wor", substring("Hello World", 6, -1));
    }*/

    @Test
    void testNegativeBothIndices() {
        assertEquals("Wor", substring("Hello World", -5, -2));
    }

    @Test
    void testFinishGreaterThanLength() {
        assertEquals("World", substring("World", 0, 10));
    }

    @Test
    void testBeginGreaterThanFinishReturnsEmpty() {
        assertEquals(EMPTY, substring("abcdef", 4, 2));
    }

    @Test
    void testBeginEqualsFinishReturnsEmpty() {
        assertEquals(EMPTY, substring("abcdef", 3, 3));
    }

    @Test
    void testBeginNegativeAfterAdjustmentBelowZero() {
        assertEquals("abc", substring("abcdef", -10, 3));
    }

    @Test
    void testFinishNegativeAfterAdjustmentBelowZero() {
        assertEquals(EMPTY, substring("abcdef", 1, -10));
    }

/*    @Test
    void testFullStringViaNegativeIndices() {
        assertEquals("abcdef", substring("abcdef", -6, -0));
    }*/
}