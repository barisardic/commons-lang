package GeneratedTest;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ChompTest {

//15
    @Test
    void testNullInput() {
        assertNull(StringUtils.chomp(null));
    }
//14
    @Test
    void testEmptyString() {
        assertEquals("", StringUtils.chomp(""));
    }
//11
    @Test
    void testSingleCR() {
        assertEquals("", StringUtils.chomp("\r"));
    }
//10
    @Test
    void testSingleLF() {
        assertEquals("", StringUtils.chomp("\n"));
    }
//5
    @Test
    void testSingleCharacterNonNewline() {
        assertEquals("a", StringUtils.chomp("a"));
    }
//2
    @Test
    void testEndsWithLF() {
        assertEquals("hello", StringUtils.chomp("hello\n"));
    }
//1
    @Test
    void testEndsWithCRLF() {
        assertEquals("hello", StringUtils.chomp("hello\r\n"));
    }
//3
    @Test
    void testEndsWithCR() {
        assertEquals("hello", StringUtils.chomp("hello\r"));
    }
//5
    @Test
    void testNoTrailingNewline() {
        assertEquals("hello", StringUtils.chomp("hello"));
    }
//13
    @Test
    void testOnlyCRLF() {
        assertEquals("", StringUtils.chomp("\r\n"));
    }
//2,8
    @Test
    void testMultipleLines() {
        assertEquals("line1\nline2", StringUtils.chomp("line1\nline2\n"));
    }
//1,9
    @Test
    void testMultipleLinesWithCRLF() {
        assertEquals("line1\r\nline2", StringUtils.chomp("line1\r\nline2\r\n"));
    }
//+ Testing if string is trimmed in thr method. Good test.
    @Test
    void testWhitespaceAfterNewline() {
        assertEquals("test\n ", StringUtils.chomp("test\n "));
    }
// 16
//    @Test
//    void testEndsWithLFThenCR() {
//        // Edge case: unlikely but checks logic
//        assertEquals("abc\n\r", StringUtils.chomp("abc\n\r"));
//    }

}
//Number of test: 14
//Number of test match:12
//New test scenarios:1
//Number duplicate:3