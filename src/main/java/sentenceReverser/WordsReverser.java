package sentenceReverser;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Oleksandr Ryzhkov on 09.03.2018.
 */
public class WordsReverser {
    public static final Pattern PATTERN = Pattern.compile(".*[.!?]$");

    /**
     * Reverse the sentence via Collection.reverse
     * */
    public String reverseWordsOrder1(String sentence) {
        if (StringUtils.isNotEmpty(sentence)) {
            StringBuilder sb = new StringBuilder();
            List<String> listOfWords = new ArrayList<>(Arrays.asList(sentence.split(" ")));
            if (CollectionUtils.isNotEmpty(listOfWords)) {
                Collections.reverse(listOfWords);
                listOfWords.forEach(item -> {
                    handleLastWordOfSentence(sb, item);
                });
            }
            return sb.toString().trim(); //remove last space
        } else {
            return "";
        }

    }

    /**
     * Reverse the sentence via storing new order in a new array
     * */
    public String reverseWordsOrder2(String sentence) {
        if (StringUtils.isNotEmpty(sentence)) {
            StringBuilder result = new StringBuilder();
            String[] initialArray = sentence.split(" ");
            String[] resultArray = new String[initialArray.length];
            for (int i = initialArray.length - 1, j = 0; i >= 0; i--, j++) {
                resultArray[j] = initialArray[i];

                handleLastWordOfSentence(result, resultArray[j]);
            }
            return result.toString().trim();
        }
        return "";
    }

    /**
     * Reverse the sentence without storing data in a new array. Instead direct writing to result StringBuilder is used.
     * */
    //another option is to skip the creation on a new array object and write new value directly to result (same can be applied to other solutions)
    public String reverseWordsOrder2_1(String sentence) {
        if (StringUtils.isNotEmpty(sentence)) {
            StringBuilder result = new StringBuilder();

            String[] initialArray = sentence.split(" ");
            for (int i = initialArray.length - 1, j = 0; i >= 0; i--, j++) {
                handleLastWordOfSentence(result, initialArray[i]);
            }
            return result.toString().trim();
        }
        return "";
    }

    /**
     * Reverse the sentence without the creation of a new array to store .
     * */
    public String reverseWordsOrder3(String sentence) {
        StringBuilder result = new StringBuilder();
        if (StringUtils.isNotEmpty(sentence)) {
            String[] initialArray = sentence.split(" ");
            for (int i = 0; i < initialArray.length / 2; i++) {
                String temp = initialArray[i];
                initialArray[i] = initialArray[initialArray.length - 1 - i];
                initialArray[initialArray.length - 1 - i] = temp;
            }

            for (String s : initialArray) {
                handleLastWordOfSentence(result, s);
            }
        }
        return result.toString().trim();
    }

    /**
     * Method checks if the last symbol of a current word is a sentence ending one. If yes, move is to the beginning.
     * */
    private void handleLastWordOfSentence(StringBuilder result, String s) {
        Matcher matcher = PATTERN.matcher(s);
        if (matcher.find()) {
            String lastWord = s.substring(0, s.length() - 1);
            String endingSymbol = s.substring(s.length() - 1);
            //maintain the order
            result.append(endingSymbol);
            result.append(lastWord);
            result.append(" ");
        } else {
            result.append(s);
            result.append(" ");
        }
    }

}
