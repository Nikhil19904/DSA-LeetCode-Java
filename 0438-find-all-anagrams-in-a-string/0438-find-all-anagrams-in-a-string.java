class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int [] freq=new int[26];
        for(int i=0;i<p.length();i++){
            char ch=p.charAt(i);
            freq[ch-'a']++;
        }
        List<Integer> ans=new ArrayList<>();
        int lo=0,hi=0;
        while(hi<s.length()){
            char ch=s.charAt(hi);
            freq[ch-'a']--;
            if(hi-lo+1>p.length()){
                freq[s.charAt(lo)-'a']++;
                lo++;
            }
            if(hi-lo+1==p.length() && allZero(freq)){
                ans.add(lo);
            }
            hi++;
        }
        return ans;
    }
    public static boolean allZero(int [] freq){
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
}