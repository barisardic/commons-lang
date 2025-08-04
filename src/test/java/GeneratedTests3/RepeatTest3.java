package GeneratedTests3;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static jdk.internal.joptsimple.internal.Strings.repeat;
import static org.junit.jupiter.api.Assertions.*;

public class RepeatTest3 {
    // Assume EMPTY is defined in the same class
    private static final String EMPTY = "";
    private static final int PAD_LIMIT = 8192;

    @Test
    public void testRepeat_NullInput() {
        assertNull(StringUtils.repeat(null, 5));
    }

    @Test
    public void testRepeat_NegativeCount() {
        assertEquals(EMPTY, StringUtils.repeat("abc", -3));
    }

    @Test
    public void testRepeat_ZeroCount() {
        assertEquals(EMPTY, StringUtils.repeat("abc", 0));
    }

    @Test
    public void testRepeat_EmptyString() {
        assertEquals("", StringUtils.repeat("", 10));
    }

    @Test
    public void testRepeat_SingleCount() {
        assertEquals("abc", StringUtils.repeat("abc", 1));
    }

    @Test
    public void testRepeat_SingleCharBelowPadLimit() {
        for (int i = 1; i <= 10; i++) {
            assertEquals(repeat('x', i), StringUtils.repeat("x", i));
        }
    }

    @Test
    public void testRepeat_SingleCharAbovePadLimit() {
        int highCount = PAD_LIMIT + 100;
        String expected = repeat('z', highCount);
        assertEquals(expected, StringUtils.repeat("z", highCount));
    }

    @Test
    public void testRepeat_TwoCharString() {
        assertEquals("abababab", StringUtils.repeat("ab", 4));
        assertEquals("cdcdcd", StringUtils.repeat("cd", 3));
    }

    @Test
    public void testRepeat_MultiCharString() {
        assertEquals("helloworldhelloworld", StringUtils.repeat("helloworld", 2));
        assertEquals("xyzxyzxyzxyz", StringUtils.repeat("xyz", 4));
    }

    @Test
    public void testRepeat_SpecialCharacters() {
        assertEquals("!@#!@#!@#", StringUtils.repeat("!@#", 3));
    }

    @Test
    public void testRepeat_UnicodeCharacters() {
        assertEquals("???", StringUtils.repeat("?", 3));
    }

    @Test
    public void testRepeat_LongString() {
        String unit = "abcdef";
        int count = 100;
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < count; i++) {
            expected.append(unit);
        }
        assertEquals(expected.toString(), StringUtils.repeat(unit, count));
    }
}
