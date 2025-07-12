class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String> hashSet = new HashSet();
        HashMap<String, Integer> hashMap = new HashMap();
        String[] words = paragraph.split("[\\s!?',;.]+");

        for (String word : banned) {
            hashSet.add(word);
        }

        String mostFreqWord = "";
        int biggestFreq = 0;

        for (String word : words) {
            word = word.toLowerCase();
            if (!hashSet.contains(word)) {
                int freq = hashMap.getOrDefault(word, 0) + 1;
                hashMap.put(word, freq);

                if (freq > biggestFreq) {
                    biggestFreq = freq;
                    mostFreqWord = word;
                }
            }
        }

        return mostFreqWord;
    }
}