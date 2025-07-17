package org.example.GeneratedTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppendTest {

    private TestCompareToBuilder builder;

    // Custom CompareToBuilder for testing
    static class TestCompareToBuilder {
        int comparison = 0;

        public TestCompareToBuilder append(char lhs, char rhs) {
            if (comparison != 0) return this;
            if (lhs < rhs) comparison = -1;
            else if (lhs > rhs) comparison = 1;
            return this;
        }

        public TestCompareToBuilder append(char[] lhs, char[] rhs) {
            if (comparison != 0) return this;
            if (lhs == rhs) return this;
            if (lhs == null) {
                comparison = -1;
                return this;
            }
            if (rhs == null) {
                comparison = 1;
                return this;
            }
            if (lhs.length != rhs.length) {
                comparison = lhs.length < rhs.length ? -1 : 1;
                return this;
            }
            for (int i = 0; i < lhs.length && comparison == 0; i++) {
                append(lhs[i], rhs[i]);
            }
            return this;
        }

        public int toComparison() {
            return comparison;
        }
    }

    @BeforeEach
    void setUp() {
        builder = new TestCompareToBuilder();
    }

    @Test
    void testSameReference() {
        char[] arr = {'a', 'b'};
        builder.append(arr, arr);
        assertEquals(0, builder.toComparison());
    }

    @Test
    void testLeftNullRightNotNull() {
        builder.append(null, new char[]{'a'});
        assertEquals(-1, builder.toComparison());
    }

    @Test
    void testRightNullLeftNotNull() {
        builder.append(new char[]{'a'}, null);
        assertEquals(1, builder.toComparison());
    }

    @Test
    void testBothNull() {
        builder.append(null, null);
        assertEquals(0, builder.toComparison());
    }

    @Test
    void testDifferentLengthsLeftShorter() {
        builder.append(new char[]{'a'}, new char[]{'a', 'b'});
        assertEquals(-1, builder.toComparison());
    }

    @Test
    void testDifferentLengthsRightShorter() {
        builder.append(new char[]{'a', 'b'}, new char[]{'a'});
        assertEquals(1, builder.toComparison());
    }

    @Test
    void testEqualArrays() {
        builder.append(new char[]{'a', 'b'}, new char[]{'a', 'b'});
        assertEquals(0, builder.toComparison());
    }

    @Test
    void testDifferentElementsLeftLess() {
        builder.append(new char[]{'a', 'b'}, new char[]{'a', 'c'});
        assertEquals(-1, builder.toComparison());
    }

    @Test
    void testDifferentElementsLeftGreater() {
        builder.append(new char[]{'a', 'd'}, new char[]{'a', 'c'});
        assertEquals(1, builder.toComparison());
    }

    @Test
    void testEarlyExitIfComparisonAlreadyNonZero() {
        builder.comparison = 1;
        builder.append(new char[]{'a'}, new char[]{'b'});
        assertEquals(1, builder.toComparison());
    }
}
