package GeneratedTest2;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ChompTest2 {

//15
    @Test
void testNullInput() {
    assertNull(StringUtils.chomp(null), "Should return null when input is null");
}
//14
    @Test
    void testEmptyString() {
        assertEquals("", StringUtils.chomp(""), "Should return empty string when input is empty");
    }
//10
    @Test
    void testSingleLF() {
        assertEquals("", StringUtils.chomp("\n"), "Should return empty string for single LF");
    }
//11
    @Test
    void testSingleCR() {
        assertEquals("", StringUtils.chomp("\r"), "Should return empty string for single CR");
    }
//5
    @Test
    void testSingleNonNewlineChar() {
        assertEquals("a", StringUtils.chomp("a"), "Should return same single character if not newline");
    }
//1
    @Test
    void testEndsWithCRLF() {
        assertEquals("hello", StringUtils.chomp("hello\r\n"), "Should remove CRLF");
    }
//2
    @Test
    void testEndsWithLFOnly() {
        assertEquals("hello", StringUtils.chomp("hello\n"), "Should remove LF");
    }
//3
    @Test
    void testEndsWithCROnly() {
        assertEquals("hello", StringUtils.chomp("hello\r"), "Should remove CR");
    }
//5
    @Test
    void testNoNewlineAtEnd() {
        assertEquals("hello", StringUtils.chomp("hello"), "Should return unchanged string");
    }
//8
    @Test
    void testNewlineInMiddleOnly() {
        assertEquals("hello\nworld", StringUtils.chomp("hello\nworld"), "Should not remove middle newline");
    }
//2,8
    @Test
    void testMultipleNewlinesAtEnd() {
        assertEquals("line1\nline2", StringUtils.chomp("line1\nline2\n"), "Should remove only the final LF");
    }
//+
    @Test
    void testEndsWithCRLFAndExtraCR() {
        assertEquals("line\r", StringUtils.chomp("line\r\r\n"), "Should remove only final CRLF");
    }
}
//Number of test: 12
//Number of test match:9
//New test scenarios:1
//Number duplicate:2