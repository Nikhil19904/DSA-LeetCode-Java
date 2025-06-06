class Solution {

    private boolean isSubsequence(String a, String b, int m, int n) {
        int j = 0;
        for (int i = 0; i < m && j < n; ++i) {
            if (a.charAt(i) == b.charAt(j)) {
                ++j;
            }
        }
        return j == n;
    }

    public int numMatchingSubseq(String s, String[] words) {
        final Map<String, Integer> wordFrequencyMap = new HashMap<>();
        int matches = 0;
        for (String word : words) {
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : wordFrequencyMap.entrySet()) {
            String word = entry.getKey();
            if (isSubsequence(s, word, s.length(), word.length())) {
                matches += entry.getValue();
            }
        }
        return matches;
    }
}