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
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class ConvertRemainingAccentCharactersTest {

    @Test
    void testLWithStrokeUpper() {
        StringBuilder sb = new StringBuilder("\u0141"); // ?
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("L", sb.toString());
    }

    @Test
    void testLWithStrokeLower() {
        StringBuilder sb = new StringBuilder("\u0142"); // ?
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("l", sb.toString());
    }

    @Test
    void testDWithStrokeUpper() {
        StringBuilder sb = new StringBuilder("\u0110"); // ?
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("D", sb.toString());
    }

    @Test
    void testDWithStrokeLower() {
        StringBuilder sb = new StringBuilder("\u0111"); // ?
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("d", sb.toString());
    }

    @Test
    void testIWithBarUpper1() {
        StringBuilder sb = new StringBuilder("\u0197"); // ?
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("I", sb.toString());
    }

    @Test
    void testIWithBarLower1() {
        StringBuilder sb = new StringBuilder("\u0268"); // ?
       StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("i", sb.toString());
    }

    @Test
    void testIWithBarModifier1() {
        StringBuilder sb = new StringBuilder("\u1D7B"); // ?
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("I", sb.toString());
    }

    @Test
    void testIWithBarModifier2() {
        StringBuilder sb = new StringBuilder("\u1DA4"); // ?
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("i", sb.toString());
    }

    @Test
    void testIWithBarModifier3() {
        StringBuilder sb = new StringBuilder("\u1DA7"); // ?
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("I", sb.toString());
    }

    @Test
    void testUWithBarUpper1() {
        StringBuilder sb = new StringBuilder("\u0244"); // ?
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("U", sb.toString());
    }

    @Test
    void testUWithBarLower1() {
        StringBuilder sb = new StringBuilder("\u0289"); // ?
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("u", sb.toString());
    }

    @Test
    void testUWithStrokeSmallCapital() {
        StringBuilder sb = new StringBuilder("\u1D7E"); // ?
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("U", sb.toString());
    }

    @Test
    void testUWithBarModifier() {
        StringBuilder sb = new StringBuilder("\u1DB6"); // ?
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("u", sb.toString());
    }

    @Test
    void testTWithStrokeUpper() {
        StringBuilder sb = new StringBuilder("\u0166"); // ?
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("T", sb.toString());
    }

    @Test
    void testTWithStrokeLower() {
        StringBuilder sb = new StringBuilder("\u0167"); // ?
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("t", sb.toString());
    }

    @Test
    void testNoConversionNeeded() {
        StringBuilder sb = new StringBuilder("ABCxyz123");
        String expected = sb.toString();
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals(expected, sb.toString());
    }

    @Test
    void testMixedCharacters() {
        StringBuilder sb = new StringBuilder("A\u0141\u0111\u1D7EU"); // A???U
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("ALdUU", sb.toString());
    }

    @Test
    void testEmptyString() {
        StringBuilder sb = new StringBuilder("");
        StringUtils.convertRemainingAccentCharacters(sb);
        assertEquals("", sb.toString());
    }
}
