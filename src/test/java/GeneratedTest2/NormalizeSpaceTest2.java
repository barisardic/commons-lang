package GeneratedTest2;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.normalizeSpace;
import static org.junit.jupiter.api.Assertions.*;
public class NormalizeSpaceTest2 {
//2
        @Test
        void testNullInput() {
            assertNull(StringUtils.normalizeSpace(null));
        }
//3
        @Test
        void testEmptyString() {
            assertEquals("", StringUtils.normalizeSpace(""));
        }
//4
        @Test
        void testOnlyWhitespaces() {
            assertEquals("", StringUtils.normalizeSpace("     "));
        }
//+ Testing Single word without whitespace
        void testSingleWord() {
            assertEquals("word",StringUtils.normalizeSpace("word"));
        }
//16
        @Test
        void testLeadingAndTrailingSpaces() {
            assertEquals("word", StringUtils.normalizeSpace("   word   "));
        }
//17
        @Test
        void testMultipleSpacesBetweenWords() {
            assertEquals("a b c", StringUtils.normalizeSpace("a    b   c"));
        }
//5,6
        @Test
        void testTabsAndNewlines() {
            assertEquals("a b c", StringUtils.normalizeSpace("a\t\tb\n\nc"));
        }
//5,6
        @Test
        void testMixedWhitespaceTypes() {
            assertEquals("a b c", StringUtils.normalizeSpace("  a \t b \n c  "));
        }
//+ Already normalized string (verifies idempotency)
        @Test
        void testNoChangeNeeded() {
            assertEquals("a b c", StringUtils.normalizeSpace("a b c"));
        }
//+
        @Test
        void testNonBreakingSpaceHandling() {
            String input = "a" + (char) 160 + "b" + (char) 160 + "c";
            assertEquals("a b c", StringUtils.normalizeSpace(input));
        }
// +
        @Test
        void testWhitespaceOnlyWithNBSP() {
            String input = "" + (char) 160 + (char) 160;
            assertEquals("", StringUtils.normalizeSpace(input));
        }
//+
        @Test
        void testWordSurroundedByNBSP() {
            String input = (char) 160 + "word" + (char) 160;
            assertEquals("word", StringUtils.normalizeSpace(input));
        }
//+
        @Test
        void testWhitespaceInsideUnicodeString() {
            String input = "?????   ??";
            assertEquals("????? ??", StringUtils.normalizeSpace(input));
        }
    }

//Number of test: 13
//Number of test match:7
//New test scenarios:6
//Number of apache test: