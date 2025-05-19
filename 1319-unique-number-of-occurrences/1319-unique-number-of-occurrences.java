class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        HashSet<Integer> hashSet = new HashSet();

        for(int eachNum : arr){
            int freq = hashMap.getOrDefault(eachNum, 0) + 1;
            hashMap.put(eachNum, freq);
        }

        for(int value : hashMap.values()){
            if(hashSet.contains(value)){
                return false;
            }
            hashSet.add(value);
        }
        return true;
    }
}