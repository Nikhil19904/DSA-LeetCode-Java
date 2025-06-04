import java.util.*;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        
        // If lengths don't match, it's not a valid pattern
        if (words.length != pattern.length()) return false;

        Map<Character, String> charToWord = new HashMap<>();
        Map<String, Character> wordToChar = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            // Check character → word mapping
            if (charToWord.containsKey(ch)) {
                if (!charToWord.get(ch).equals(word)) return false;
            } else {
                charToWord.put(ch, word);
            }

            // Check word → character mapping
            if (wordToChar.containsKey(word)) {
                if (wordToChar.get(word) != ch) return false;
            } else {
                wordToChar.put(word, ch);
            }
        }

        return true;
    }
}