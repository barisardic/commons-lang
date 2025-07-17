package org.example.GeneratedTest;
import static org.apache.commons.lang3.StringUtils.matches;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class MatchesTest {
    @Test
    void testIdenticalStrings() {
        int[] result = StringUtils.matches("hello", "hello");
        // Expected: matches=5, transpositions=0, prefix=5, max.length=5
        assertArrayEquals(new int[]{5, 0, 5, 5}, result);
    }

    @Test
    void testCompletelyDifferentStrings() {
        int[] result = StringUtils.matches("abc", "xyz");
        // Expected: matches=0, transpositions=0, prefix=0, max.length=3
        assertArrayEquals(new int[]{0, 0, 0, 3}, result);
    }

    @Test
    void testPartialOverlap() {
        int[] result = StringUtils.matches("martha", "marhta");
        // martha vs marhta -> matches=6, transpositions=1, prefix=3, max.length=6
        assertArrayEquals(new int[]{6, 1, 3, 6}, result);
    }

    @Test
    void testPrefixOnly() {
        int[] result = StringUtils.matches("abcdxyz", "abcdefg");
        // overlap on prefix abcd: matches should be 4, transpositions=0, prefix=4, max.length=7
        assertArrayEquals(new int[]{4, 0, 4, 7}, result);
    }

    @Test
    void testOneEmptyString() {
        int[] result = StringUtils.matches("", "abc");
        // Expected: matches=0, transpositions=0, prefix=0, max.length=3
        assertArrayEquals(new int[]{0, 0, 0, 3}, result);
    }

    @Test
    void testBothEmptyStrings() {
        int[] result = StringUtils.matches("", "");
        // Expected: matches=0, transpositions=0, prefix=0, max.length=0
        assertArrayEquals(new int[]{0, 0, 0, 0}, result);
    }

    @Test
    void testSingleCharacterMatch() {
        int[] result = StringUtils.matches("a", "a");
        assertArrayEquals(new int[]{1, 0, 1, 1}, result);
    }

    @Test
    void testSingleCharacterNoMatch() {
        int[] result = StringUtils.matches("a", "b");
        assertArrayEquals(new int[]{0, 0, 0, 1}, result);
    }

    @Test
    void testTranspositions() {
        int[] result = StringUtils.matches("abcdef", "abcfde");
        // matches: 6, transpositions: 2 (c and d/e swapped), prefix: 3, max.length=6
        assertArrayEquals(new int[]{6, 1, 3, 6}, result);
    }

}
