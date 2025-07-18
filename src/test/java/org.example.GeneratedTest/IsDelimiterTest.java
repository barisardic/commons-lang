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
import org.junit.jupiter.api.Test;

import static org.apache.commons.text.WordUtils.isDelimiter;

import static org.junit.jupiter.api.Assertions.*;
public class IsDelimiterTest {
    @Test
    public void testIsDelimiter_NullDelimiters_WhitespaceChar() {
        assertTrue(isDelimiter(' ', null));
        assertTrue(isDelimiter('\n', null));
        assertTrue(isDelimiter('\t', null));
    }

    @Test
    public void testIsDelimiter_NullDelimiters_NonWhitespaceChar() {
        assertFalse(isDelimiter('a', null));
        assertFalse(isDelimiter('1', null));
        assertFalse(isDelimiter('-', null));
    }

    @Test
    public void testIsDelimiter_CharInDelimiters() {
        char[] delimiters = {',', ';', ':'};
        assertTrue(isDelimiter(',', delimiters));
        assertTrue(isDelimiter(';', delimiters));
        assertTrue(isDelimiter(':', delimiters));
    }

    @Test
    public void testIsDelimiter_CharNotInDelimiters() {
        char[] delimiters = {',', ';', ':'};
        assertFalse(isDelimiter('.', delimiters));
        assertFalse(isDelimiter('a', delimiters));
        assertFalse(isDelimiter(' ', delimiters));
    }

    @Test
    public void testIsDelimiter_EmptyDelimiters() {
        char[] delimiters = {};
        assertFalse(isDelimiter('a', delimiters));
        assertFalse(isDelimiter(' ', delimiters));
    }

    @Test
    public void testIsDelimiter_EdgeCharacters() {
        char[] delimiters = {'\u0000', '\uFFFF'};
        assertTrue(isDelimiter('\u0000', delimiters));
        assertTrue(isDelimiter('\uFFFF', delimiters));
        assertFalse(isDelimiter('a', delimiters));
    }
}
