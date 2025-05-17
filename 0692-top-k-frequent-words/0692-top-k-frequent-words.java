import java.util.*;

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // Step 1: Count frequencies
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Step 2: Convert to list of entries
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(freqMap.entrySet());

        // Step 3: Sort with custom comparator
        entryList.sort((a, b) -> {
            if (!a.getValue().equals(b.getValue())) {
                return b.getValue() - a.getValue(); // Higher freq first
            } else {
                return a.getKey().compareTo(b.getKey()); // Lexicographically smaller word first
            }
        });

        // Step 4: Collect top k words
        List<String> result = new ArrayList<>();
        for (int i = 0; i < k && i < entryList.size(); i++) {
            result.add(entryList.get(i).getKey());
        }

        return result;
    }
}
