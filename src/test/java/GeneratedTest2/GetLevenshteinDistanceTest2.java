package GeneratedTest2;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GetLevenshteinDistanceTest2 {
    //+ Non-empty identical strings 0 distance
    @Test
    public void testIdenticalStrings() {
        assertEquals(0, StringUtils.getLevenshteinDistance("kitten", "kitten"));
    }

    //5
    @Test
    public void testCompletelyDifferentStrings() {
        assertEquals(6, StringUtils.getLevenshteinDistance("kitten", "orange"));
    }

    //+
    @Test
    public void testSingleCharacterChange() {
        assertEquals(1, StringUtils.getLevenshteinDistance("kitten", "kittena".substring(0, 6) + "a"));
    }

    //4
    @Test
    public void testInsertion() {
        assertEquals(1, StringUtils.getLevenshteinDistance("abc", "abxc"));
    }

    //4
    @Test
    public void testDeletion() {
        assertEquals(1, StringUtils.getLevenshteinDistance("abcd", "acd"));
    }

    //4
    @Test
    public void testSubstitution() {
        assertEquals(1, StringUtils.getLevenshteinDistance("abc", "axc"));
    }

    //2
    @Test
    public void testEmptyFirstString() {
        assertEquals(4, StringUtils.getLevenshteinDistance("", "test"));
    }

    //3
    @Test
    public void testEmptySecondString() {
        assertEquals(3, StringUtils.getLevenshteinDistance("abc", ""));
    }

    //1
    @Test
    public void testBothStringsEmpty() {
        assertEquals(0, StringUtils.getLevenshteinDistance("", ""));
    }

    //+ Null first argument
    @Test
    public void testNullFirstStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getLevenshteinDistance(null, "abc"));
    }

    //+ Null second argument
    @Test
    public void testNullSecondStringThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getLevenshteinDistance("abc", null));
    }

    //6,7
    @Test
    public void testSymmetry() {
        String a = "gumbo";
        String b = "gambol";
        assertEquals(
                StringUtils.getLevenshteinDistance(a, b),
                StringUtils.getLevenshteinDistance(b, a)
        );
    }
/*
//+ Bad Testing
    @Test
    public void testLargeStrings() {
        String a = "a".repeat(1000);
        String b = "a".repeat(999) + "b";
        assertEquals(1, StringUtils.getLevenshteinDistance(a, b));
    }
*/
}
//Number of test: 13
//Number of test match:7
//New test scenarios:5
//Number duplicate:2