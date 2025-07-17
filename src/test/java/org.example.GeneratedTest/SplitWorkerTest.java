package org.example.GeneratedTest;

import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.splitWorker ;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class SplitWorkerTest {

    @Test
    void testNullInputReturnsNull() {
        assertNull(splitWorker(null, null, -1, false));
    }

    @Test
    void testEmptyInputReturnsEmptyArray() {
        assertArrayEquals(new String[0], splitWorker("", null, -1, false));
    }

    @Test
    void testWhitespaceSeparator() {
        String input = "a b  c   d";
        assertArrayEquals(new String[]{"a", "b", "c", "d"}, splitWorker(input, null, -1, false));
        assertArrayEquals(new String[]{"a", "b", "", "c", "", "", "d"}, splitWorker(input, null, -1, true));
    }

    @Test
    void testSingleCharacterSeparator() {
        String input = "a,b,,c,";
        assertArrayEquals(new String[]{"a", "b", "c"}, splitWorker(input, ",", -1, false));
        assertArrayEquals(new String[]{"a", "b", "", "c", ""}, splitWorker(input, ",", -1, true));
    }

    @Test
    void testMultipleSeparators() {
        String input = "a:b,c;d";
        assertArrayEquals(new String[]{"a", "b", "c", "d"}, splitWorker(input, ":,;", -1, false));
        assertArrayEquals(new String[]{"a", "b", "c", "d"}, splitWorker(input, ":,;", -1, true));
    }

    @Test
    void testPreserveAllTokensTrue() {
        String input = ",,a,,b,,";
        assertArrayEquals(new String[]{"", "", "a", "", "b", "", ""}, splitWorker(input, ",", -1, true));
    }

    @Test
    void testPreserveAllTokensFalse() {
        String input = ",,a,,b,,";
        assertArrayEquals(new String[]{"a", "b"}, splitWorker(input, ",", -1, false));
    }

    @Test
    void testMaxParameterLimit() {
        String input = "a,b,c,d";
        assertArrayEquals(new String[]{"a", "b", "c,d"}, splitWorker(input, ",", 3, false));
        assertArrayEquals(new String[]{"a", "b", "c", "d"}, splitWorker(input, ",", 4, false));
        assertArrayEquals(new String[]{"a,b,c,d"}, splitWorker(input, ",", 1, false));
    }

    @Test
    void testLeadingAndTrailingSeparators() {
        String input = ",a,b,c,";
        assertArrayEquals(new String[]{"a", "b", "c"}, splitWorker(input, ",", -1, false));
        assertArrayEquals(new String[]{"", "a", "b", "c", ""}, splitWorker(input, ",", -1, true));
    }

    @Test
    void testNoSeparatorsPresent() {
        String input = "abc";
        assertArrayEquals(new String[]{"abc"}, splitWorker(input, ",", -1, false));
    }

    @Test
    void testMaxWithPreserveAllTokensTrue() {
        String input = "a,,b,,c,,";
        assertArrayEquals(new String[]{"a", "", "b,,c,,"}, splitWorker(input, ",", 3, true));
    }

    @Test
    void testSeparatorAtStringEnds() {
        String input = "abc ";
        assertArrayEquals(new String[]{"abc"}, splitWorker(input, null, -1, false));
        assertArrayEquals(new String[]{"abc"}, splitWorker(input, " ", -1, false));
        assertArrayEquals(new String[]{"abc", ""}, splitWorker(input, " ", -1, true));
    }
}
