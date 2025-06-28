class Solution {
    int cnt=0;
    TreeMap<Integer, Integer> map= new TreeMap<>();
    Random rnd= new Random();
    public Solution(int[] w) {
        for (int idx=0; idx<w.length; idx++){
            cnt+=w[idx];
            map.put(cnt, idx);
        }
    }
    
    public int pickIndex() {
        // int key= map.ceilingKey(rnd.nextInt(cnt)+1); don't forget to +1, because rand.nextInt(cnt) generate random integer in range [0,cnt-1]
        int key= map.higherKey(rnd.nextInt(cnt));
        return map.get(key);
    }
}