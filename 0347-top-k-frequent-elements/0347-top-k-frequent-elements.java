class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // count frequencies
        HashMap<Integer,Integer>mp=new HashMap<>();
        for(int num:nums){
            if(!mp.containsKey(num)){
                mp.put(num,1);
            }

            else{
                int freq=mp.get(num);
                freq++;
                mp.put(num,freq);
            }
        }

        // sort keys by thier freq in desc order
        ArrayList<Integer>list=new ArrayList<>(mp.keySet());
        Collections.sort(list,(a,b)->mp.get(b)-mp.get(a));

        // prepare result array with top k elements -
        int[]ans=new int [k];
        for(int i=0;i<k;i++){
            ans[i]=list.get(i);

        }
        return ans;

    }
}