package GeneratedTests3;
import static org.apache.commons.lang3.StringUtils.getLevenshteinDistance;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class GetLevenshteinDistanceTest3 {


    //+ Non-empty identical strings 0 distance
        @Test
        void testSameStrings() {
            assertEquals(0, getLevenshteinDistance("kitten", "kitten"));
        }
    //7,8
        @Test
        void testCompletelyDifferentStrings() {
            assertEquals(6, getLevenshteinDistance("kitten", "puppies"));
        }
//5,10
        @Test
        void testSingleCharacterDifference() {
            assertEquals(1, getLevenshteinDistance("kitten", "sitten"));
        }
//7,8
        @Test
        void testInsertion() {
            assertEquals(1, getLevenshteinDistance("kitten", "kittena"));
        }
//6,9
        @Test
        void testDeletion() {
            assertEquals(1, getLevenshteinDistance("kitten", "kiten"));
        }
//2
        @Test
        void testEmptyFirstString() {
            assertEquals(6, getLevenshteinDistance("", "kitten"));
        }
//3
        @Test
        void testEmptySecondString() {
            assertEquals(6, getLevenshteinDistance("kitten", ""));
        }
//1
        @Test
        void testBothStringsEmpty() {
            assertEquals(0, getLevenshteinDistance("", ""));
        }
//+ testing letter sensitivity
        @Test
        void testCaseSensitivity() {
            assertEquals(1, getLevenshteinDistance("Kitten", "kitten"));
        }
    //+ Null first argument
        @Test
        void testNullFirstString() {
            assertThrows(IllegalArgumentException.class, () -> getLevenshteinDistance(null, "test"));
        }
    //+ Null second argument
        @Test
        void testNullSecondString() {
            assertThrows(IllegalArgumentException.class, () -> getLevenshteinDistance("test", null));
        }
//+ Testing  both arguments null
        @Test
        void testNullBothStrings() {
            assertThrows(IllegalArgumentException.class, () -> getLevenshteinDistance(null, null));
        }
}
//Number of test: 12
//Number of test match:9
//New test scenarios:5
//Number duplicate:2
