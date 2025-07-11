class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int c =0;
        for(int i=left ;i<=right;i++)
        {
            int len=words[i].length();
            if(words[i].charAt(0)=='a'||words[i].charAt(0)=='e'||words[i].charAt(0)=='i'||words[i].charAt(0)=='o'||words[i].charAt(0)=='u')
            {
                 if(words[i].charAt(len-1)=='a'||words[i].charAt(len-1)=='e'||words[i].charAt(len-1)=='i'||words[i].charAt(len-1)=='o'||words[i].charAt(len-1)=='u')
                 {
                    c++;
                 }
            }


        }
        return c;
    }
}