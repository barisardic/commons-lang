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

import static org.apache.commons.lang3.StringUtils.replaceEach;
import static org.junit.jupiter.api.Assertions.*;

public class ReplaceEachTest {

    @Test
    public void testNullInputText() {
        assertNull(replaceEach(null, new String[]{"a"}, new String[]{"b"}, false, 1));
    }

    @Test
    public void testEmptyInputText() {
        assertEquals("", replaceEach("", new String[]{"a"}, new String[]{"b"}, false, 1));
    }

    @Test
    public void testEmptyReplacementKeys() {
        assertEquals("abc", replaceEach("abc", new String[]{}, new String[]{}, false, 1));
    }

    @Test
    public void testNullReplacementArray() {
        assertEquals("abc", replaceEach("abc", new String[]{"a"}, null, false, 1));
    }

    @Test
    public void testUnequalReplacementArrays() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                replaceEach("abc", new String[]{"a", "b"}, new String[]{"x"}, false, 1));
        assertTrue(ex.getMessage().contains("array lengths"));
    }

    @Test
    public void testMaxRecursionsNegative() {
        Exception ex = assertThrows(IllegalStateException.class, () ->
                replaceEach("abc", new String[]{"a"}, new String[]{"b"}, true, -1));
        assertTrue(ex.getMessage().contains("Aborting to protect"));
    }

    @Test
    public void testSimpleReplacement() {
        assertEquals("xbc", replaceEach("abc", new String[]{"a"}, new String[]{"x"}, false, 1));
    }

    @Test
    public void testMultipleReplacements() {
        assertEquals("x1x2", replaceEach("a1a2", new String[]{"a1", "a2"}, new String[]{"x1", "x2"}, false, 1));
    }

    @Test
    public void testOverlappingReplacement() {
        assertEquals("xyz", replaceEach("abc", new String[]{"a", "b", "c"}, new String[]{"x", "y", "z"}, false, 1));
    }

    @Test
    public void testReplacementNotFound() {
        assertEquals("hello", replaceEach("hello", new String[]{"x"}, new String[]{"y"}, false, 1));
    }

    @Test
    public void testRecursiveReplacement() {
        String[] keys = {"a", "b"};
        String[] values = {"b", "c"};
        // a -> b -> c
        assertEquals("ccc", replaceEach("aaa", keys, values, true, 2));
    }

/*    @Test
    public void testRecursiveReplacementWithMaxDepth() {
        String[] keys = {"a", "b"};
        String[] values = {"b", "a"};
        // a -> b -> a -> b -> ...
        String result = replaceEach("a", keys, values, true, 3);
        // Should stop after 3 recursions (resulting in 'b')
        assertEquals("b", result);
    }*/

    /*@Test
    public void testPartialReplacementDueToEmptyKeys() {
        assertEquals("abc", replaceEach("abc", new String[]{"", "a"}, new String[]{"x", "y"}, false, 1));
    }

    @Test
    public void testNullReplacementElementIgnored() {
        assertEquals("xbc", replaceEach("abc", new String[]{"a", "b"}, new String[]{null, "x"}, false, 1));
    }

    @Test
    public void testRecursiveReplacementTerminates() {
        String[] keys = {"x"};
        String[] values = {"x"};
        assertEquals("x", replaceEach("x", keys, values, true, 5));
    }*/
}

