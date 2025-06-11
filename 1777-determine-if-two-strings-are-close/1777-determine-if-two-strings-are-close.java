class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        
        for (char c : word1.toCharArray()) {
            count1[c - 'a']++;
        }
        
        for (char c : word2.toCharArray()) {
            count2[c - 'a']++;
        }
        
        // Check if both words have the same set of characters
        for (int i = 0; i < 26; i++) {
            if((count1[i]==0&&count2[i]!=0)||(count1[i]!=0 && count2[i] == 0)) {
                return false;
            }
        }
        
        // Compare the frequency distributions
        Arrays.sort(count1);
        Arrays.sort(count2);
        
        return Arrays.equals(count1, count2);
    }
}
