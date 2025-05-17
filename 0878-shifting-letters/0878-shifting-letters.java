class Solution {
    public String shiftingLetters(String s, int[] shifts) {
         int n=shifts.length;
        int sum=0;
        for(int i=n-1;i>=0;i--){
            sum=(sum+shifts[i])%26;
            shifts[i]=(int)sum;
        }
        StringBuilder ans=new StringBuilder(s);
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int idx=ch-'a';
            int newidx=(idx+shifts[i])%26;
            ans.setCharAt(i,(char)('a'+newidx));
        }
        return ans.toString();
    }
}