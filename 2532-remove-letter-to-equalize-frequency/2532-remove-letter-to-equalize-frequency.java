class Solution {
    public boolean equalFrequency(String word) {
        int[] f=new int[26];
        for(int i=0;i<word.length();i++){
            f[word.charAt(i)-'a']++;
        }
        for(int i=0;i<word.length();i++){
        f[word.charAt(i)-'a']--;
            if(check(f)){

                return true;
            }
            f[word.charAt(i)-'a']++;
        }
        return false;
    }
    private boolean check(int[] f){
        int k=0,t=0;
        for(int i=0;i<26;i++){
            if(f[i]==0){
                continue;
            }
            if(t==0 && f[i]>0){
                k=f[i];
                t=1;
            }
            if(f[i]!=k){
                return false;
            }
            
            
        }
        return true;
    } 
}