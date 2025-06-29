class Solution {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[26];
        for(char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int oddCount = 0;
        char oddChar = 0;
        for(int i = 0; i < 26; i++) {
            if(freq[i] % 2 != 0) {
                oddCount++;
                oddChar = (char)(i + 'a');
            }
        }
        if(oddCount > 1) {
            return "";
        }

        char[] res = new char[n];
        int l = 0;
        int r = n - 1;

        for(int i = 0; i < 26; i++) {
            if(freq[i] == 0) continue;
            char c = (char)(i + 'a');
            while(freq[i] >= 2) {
                res[l++] = c;
                res[r--] = c;
                freq[i] -= 2;
            }
        }

        if(oddCount == 1) {
            res[l] = oddChar;
        }

        return new String(res);
    }
}