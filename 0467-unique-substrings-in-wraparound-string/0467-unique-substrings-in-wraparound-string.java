class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] m = new int[26];
        char b = s.charAt(0), d=s.charAt(0);
        int x = 0;
        for(char c:s.toCharArray()){
            if(c-d==1 || d-c==25)x++;
            else{
                parse(b, x, m);
                b=c; x=1;
            }
            d=c;
        }
        parse(b,x,m);

        int a=0;
        for(int q:m)a+=q;
        return a;
    }
    private void parse(char b, int x, int[] m){
        int f=b-'a';
        for(int i=0; i<26; i++){
            if(m[f]<x)m[f]=x;
            f = f<25? f+1:0;
            x--;
            if(x==0)return;
        }
    }
}