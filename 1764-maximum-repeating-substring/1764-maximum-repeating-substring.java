class Solution {
    public int maxRepeating(String sequence, String word) {
       int maxRe=0;
       StringBuilder sb=new StringBuilder(word);

       while(sequence.contains(sb.toString())){
        maxRe++;
        sb.append(word);
       } 

       return maxRe;
    }
}