class Solution {
    public int rearrangeCharacters(String s, String target) {
        HashMap<Character,Integer> map1=new HashMap<>();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(char ch:s.toCharArray()){
            map1.put(ch,map1.getOrDefault(ch,0)+1);
        }
        for(char ch:target.toCharArray()){
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        int max=Integer.MAX_VALUE;
        for(char ch:map2.keySet()){
            if(!map1.containsKey(ch)){
                return 0;
            }
            int copies=map1.get(ch)/map2.get(ch);
            max=Math.min(max,copies);
        }
        return max;
    }
}