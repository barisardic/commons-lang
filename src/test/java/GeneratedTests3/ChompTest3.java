package GeneratedTests3;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.chomp;
import static org.junit.jupiter.api.Assertions.*;

public class ChompTest3 {
    // Helper constants simulating CharUtils
    private static final char CR = '\r';
    private static final char LF = '\n';


    // --- Test cases ---
//15
    @Test
    public void testNullInput() {
        assertNull(chomp(null));
    }
//14
    @Test
    public void testEmptyString() {
        assertEquals("", chomp(""));
    }
//11
    @Test
    public void testSingleCR() {
        assertEquals("", chomp("\r"));
    }
//10
    @Test
    public void testSingleLF() {
        assertEquals("", chomp("\n"));
    }
//5
    @Test
    public void testSingleCharNonNewline() {
        assertEquals("a", chomp("a"));
    }
//1
    @Test
    public void testCRLFEnding() {
        assertEquals("line", chomp("line\r\n"));
    }
//2
    @Test
    public void testLFSoloEnding() {
        assertEquals("line", chomp("line\n"));
    }
//3
    @Test
    public void testCRSoloEnding() {
        assertEquals("line", chomp("line\r"));
    }
//5
    @Test
    public void testNoNewlineAtEnd() {
        assertEquals("line", chomp("line"));
    }
//2,8
    @Test
    public void testEmbeddedNewlinesOnlyRemoveFinal() {
        assertEquals("line1\nline2", chomp("line1\nline2\n"));
    }
//+ Testing if string is trimmed in thr method. Good test
    @Test
    public void testEmbeddedCRLFOnlyRemoveFinal() {
        assertEquals("line1\r\nline2", chomp("line1\r\nline2\r\n"));
    }
//6
    @Test
    public void testMultipleNewlines() {
        assertEquals("hello\n\n", chomp("hello\n\n\n"));
    }

}
//Number of test:12
//Number of test match:10
//New test scenarios:1
//Number duplicate:2
