package coincidenceFinder;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * All the methods compare toLowerCase() strings
 * <p>
 * Created by Oleksandr Ryzhkov on 10.03.2018.
 */
public class StringCoincedenceFinder {
    /**
     * Method finds same characters inside @param1 and @param2 via Collection.retainAll()
     * Same can be done with Lists instead of Sets
     */
    public String findSameCharacters1(String line1, String line2) {
        if (StringUtils.isEmpty(line1) || StringUtils.isEmpty(line2)) {
            return "";
        }
        StringBuilder result = new StringBuilder();

        Set<Character> line1Characters = line1.toLowerCase().chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        Set<Character> line2Characters = line2.toLowerCase().chars().mapToObj(e -> (char) e).collect(Collectors.toSet());

        line1Characters.retainAll(line2Characters);
        line1Characters.forEach(result::append);
        return result.toString();
    }

    /**
     * Method finds same characters inside @param1 and @param2 via adding items to hashSet
     */
    public String findSameCharacters2(String line1, String line2) {
        if (StringUtils.isEmpty(line1) || StringUtils.isEmpty(line2)) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Set<Character> line1Characters = line1.toLowerCase().chars().mapToObj(e -> (char) e).collect(Collectors.toSet());
        char[] line2Characters = line2.toLowerCase().toCharArray();

        Set<Character> sameCharacters = new HashSet<>();
        for (Character character : line2Characters) {
            if (!line1Characters.add(character)) { //similar logic can be implelented with strings converted to lists and List.contains() method to find coindedence
                sameCharacters.add(character);
            }
        }
        sameCharacters.forEach(result::append);
        return result.toString();
    }

    /**
     * Method finds same characters inside @param1 and @param2 via contains()
     */
    public String findSameCharacters3(String line1, String line2) {
        if (StringUtils.isEmpty(line1) || StringUtils.isEmpty(line2)) {
            return "";
        }

        Set<Character> sameCharacters = new HashSet<>();
        StringBuilder result = new StringBuilder();
        for (Character character : line1.toLowerCase().toCharArray()) {
            if (line2.toLowerCase().contains(character + "")) { //similar can be made with String.indexOf()
                sameCharacters.add(character);
            }
        }
        sameCharacters.forEach(result::append);
        return result.toString();
    }

    /**
     * Method finds same characters inside @param1 and @param2 with a use of HashMap
     */
    public String findSameCharacters4(String line1, String line2) {
        if (StringUtils.isEmpty(line1) || StringUtils.isEmpty(line2)) {
            return "";
        }

        Set<Character> sameCharacters = new HashSet<>();
        StringBuilder result = new StringBuilder();

        Map<Character, String> characterStringHashMap = new HashMap<>();
        line1.toLowerCase().chars().mapToObj(item -> (char) item).forEach(item -> characterStringHashMap.put(item, ""));

        for (Character character : line2.toLowerCase().toCharArray()) {
            if (characterStringHashMap.containsKey(character)) {
                sameCharacters.add(character);
            }
        }
        sameCharacters.forEach(result::append);
        return result.toString();
    }
}
