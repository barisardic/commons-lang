package org.example.GeneratedTest;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GetLevenshteinDistanceTest { @Test
void testIdenticalStrings() {
    assertEquals(0, StringUtils.getLevenshteinDistance("test", "test"));
}

    @Test
    void testCompletelyDifferentStrings() {
        assertEquals(4, StringUtils.getLevenshteinDistance("test", "abcd"));
    }

    @Test
    void testOneEmptyString() {
        assertEquals(4, StringUtils.getLevenshteinDistance("test", ""));
        assertEquals(4, StringUtils.getLevenshteinDistance("", "test"));
    }

    @Test
    void testBothEmptyStrings() {
        assertEquals(0, StringUtils.getLevenshteinDistance("", ""));
    }

    @Test
    void testNullFirstStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getLevenshteinDistance(null, "test");
        });
    }

    @Test
    void testNullSecondStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getLevenshteinDistance("test", null);
        });
    }

    @Test
    void testInsertion() {
        assertEquals(1, StringUtils.getLevenshteinDistance("test", "tests"));
    }

    @Test
    void testDeletion() {
        assertEquals(1, StringUtils.getLevenshteinDistance("tests", "test"));
    }

    @Test
    void testSubstitution() {
        assertEquals(1,StringUtils.getLevenshteinDistance("test", "tent"));
    }

    @Test
    void testSwappedStrings() {
        // s is longer than t, so it should swap internally
        assertEquals(1, StringUtils.getLevenshteinDistance("testing", "testin"));
    }

//    @Test
//    void testUnicodeStrings() {
//        assertEquals(1, StringUtils.getLevenshteinDistance("türk", "turk"));
//    }

    @Test
    void testLongerStrings() {
        String s1 = "kitten";
        String s2 = "sitting";
        assertEquals(3, StringUtils.getLevenshteinDistance(s1, s2));
    }

}
