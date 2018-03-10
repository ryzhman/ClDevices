package sentenceReverser;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Oleksandr Ryzhkov on 09.03.2018.
 */
public class WordsReverserTest {
    private final String testSentence = "This is a sentence to test a code for Clever Devices.";
    private final String verificationSentence = ".Devices Clever for code a test to sentence a is This";
    private final WordsReverser wordsReverser = new WordsReverser();

    @Test
    public void wordReverserTest() {
        assertEquals(verificationSentence, wordsReverser.reverseWordsOrder1(testSentence));
    }

    @Test
    public void reverseOrder2Test() {
        assertEquals(verificationSentence, wordsReverser.reverseWordsOrder2(testSentence));
    }

    @Test
    public void reverseOrder2_1Test() {
        assertEquals(verificationSentence, wordsReverser.reverseWordsOrder2_1(testSentence));
    }

    @Test
    public void reverseOrder3Test() {
        assertEquals(verificationSentence, wordsReverser.reverseWordsOrder3(testSentence));
    }

}
