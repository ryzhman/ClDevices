package coincidenceFinder;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Oleksandr Ryzhkov on 10.03.2018.
 */
public class StringCoincedenceFinderTest {
    private static final String LETTERS_IN_BOTH_LINES = "";
    private static char[] charArray = {'a', ' ', 'q', 'w', 'e', 'r', 't', 'y', 'z'};

    private final String TEST_LINE1 = "abc e Qwerty xyz";
    private final String TEST_LINE2 = "a defg qwerty tpqrs z";

    private StringCoincedenceFinder finder = new StringCoincedenceFinder();

    @BeforeClass
    public static void beforeClassSetUp() {
        Arrays.sort(charArray);
    }

    @Test
    public void findSameCharacters1Test() {
        String sameCharacters = finder.findSameCharacters1(TEST_LINE1, TEST_LINE2);

        char[] result = sameCharacters.toCharArray();
        Arrays.sort(result);
        assertArrayEquals(charArray, result);
    }

    @Test
    public void findSameCharacters1TestWithEmptyLines() {
        String sameCharacters = finder.findSameCharacters1("", TEST_LINE2);
        assertTrue(sameCharacters.isEmpty());

        sameCharacters = finder.findSameCharacters1(TEST_LINE1, "");
        assertTrue(sameCharacters.isEmpty());

        sameCharacters = finder.findSameCharacters1("", "");
        assertTrue(sameCharacters.isEmpty());
    }

    @Test
    public void findSameCharacters2Test() {
        String sameCharacters = finder.findSameCharacters2(TEST_LINE1, TEST_LINE2);

        char[] result = sameCharacters.toCharArray();
        Arrays.sort(result);
        assertArrayEquals(charArray, result);
    }

    @Test
    public void findSameCharacters3Test() {
        String sameCharacters = finder.findSameCharacters3(TEST_LINE1, TEST_LINE2);

        char[] result = sameCharacters.toCharArray();
        Arrays.sort(result);
        assertArrayEquals(charArray, result);
    }

    @Test
    public void findSameCharacters4Test() {
        String sameCharacters = finder.findSameCharacters3(TEST_LINE1, TEST_LINE2);

        char[] result = sameCharacters.toCharArray();
        Arrays.sort(result);
        assertArrayEquals(charArray, result);
    }

}