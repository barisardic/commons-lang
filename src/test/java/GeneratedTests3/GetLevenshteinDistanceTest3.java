package GeneratedTests3;
import static org.apache.commons.lang3.StringUtils.getLevenshteinDistance;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class GetLevenshteinDistanceTest3 {



        @Test
        void testSameStrings() {
            assertEquals(0, getLevenshteinDistance("kitten", "kitten"));
        }

        @Test
        void testCompletelyDifferentStrings() {
            assertEquals(6, getLevenshteinDistance("kitten", "puppies"));
        }

        @Test
        void testSingleCharacterDifference() {
            assertEquals(1, getLevenshteinDistance("kitten", "sitten"));
        }

        @Test
        void testInsertion() {
            assertEquals(1, getLevenshteinDistance("kitten", "kittena"));
        }

        @Test
        void testDeletion() {
            assertEquals(1, getLevenshteinDistance("kitten", "kiten"));
        }

        @Test
        void testEmptyFirstString() {
            assertEquals(6, getLevenshteinDistance("", "kitten"));
        }

        @Test
        void testEmptySecondString() {
            assertEquals(6, getLevenshteinDistance("kitten", ""));
        }

        @Test
        void testBothStringsEmpty() {
            assertEquals(0, getLevenshteinDistance("", ""));
        }

        @Test
        void testCaseSensitivity() {
            assertEquals(1, getLevenshteinDistance("Kitten", "kitten"));
        }

        @Test
        void testNullFirstString() {
            assertThrows(IllegalArgumentException.class, () -> getLevenshteinDistance(null, "test"));
        }

        @Test
        void testNullSecondString() {
            assertThrows(IllegalArgumentException.class, () -> getLevenshteinDistance("test", null));
        }

        @Test
        void testNullBothStrings() {
            assertThrows(IllegalArgumentException.class, () -> getLevenshteinDistance(null, null));
        }
}
