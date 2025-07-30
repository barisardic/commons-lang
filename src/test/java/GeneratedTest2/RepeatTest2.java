package GeneratedTest2;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class RepeatTest2 {




        private static final String EMPTY = "";
        private static final int PAD_LIMIT = 8192; // Assumed from context



        @Test
        void testRepeat_NullInput() {
            assertNull(StringUtils.repeat(null, 5));
        }

        @Test
        void testRepeat_EmptyString() {
            assertEquals("", StringUtils.repeat("", 5));
        }

        @Test
        void testRepeat_ZeroCount() {
            assertEquals("", StringUtils.repeat("abc", 0));
        }

        @Test
        void testRepeat_NegativeCount() {
            assertEquals("", StringUtils.repeat("abc", -3));
        }

        @Test
        void testRepeat_CountOne() {
            assertEquals("abc", StringUtils.repeat("abc", 1));
        }

        @Test
        void testRepeat_SingleCharacter_SmallCount() {
            assertEquals("aaa", StringUtils.repeat("a", 3));
        }

        @Test
        void testRepeat_SingleCharacter_MaxPadLimit() {
            assertEquals(StringUtils.repeat('x', PAD_LIMIT), StringUtils.repeat("x", PAD_LIMIT));
        }

        @Test
        void testRepeat_SingleCharacter_AbovePadLimit() {
            assertEquals(StringUtils.repeat('x', PAD_LIMIT + 1), StringUtils.repeat("x", PAD_LIMIT + 1));
        }

        @Test
        void testRepeat_TwoCharacters() {
            assertEquals("ababab", StringUtils.repeat("ab", 3));
        }

        @Test
        void testRepeat_MultiCharacter() {
            assertEquals("xyzxyzxyz", StringUtils.repeat("xyz", 3));
        }

        @Test
        void testRepeat_LongString() {
            String input = "longstring";
            int count = 10;
            String expected = input.repeat(count);
            assertEquals(expected, StringUtils.repeat(input, count));
        }

        @Test
        void testRepeat_InputLengthZero() {
            assertEquals("", StringUtils.repeat("", 10));
        }

        @Test
        void testRepeat_SpecialCharacters() {
            assertEquals("@!@!@!", StringUtils.repeat("@!", 3));
        }

        @Test
        void testRepeat_UnicodeCharacters() {
            assertEquals("??????", StringUtils.repeat("??", 3));
        }
    }
//Number of test: 14
//Number of test match:
//New test scenarios: