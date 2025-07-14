class Solution {
    public int findShortestSubArray(int[] nums) {
        //find the degree of array 
        HashMap<Integer,int[]> freq = new HashMap<>();
        int deg = 0;
        for(int i =0;i<nums.length;i++){
            int val=nums[i];
            if(!freq.containsKey(val)){
                freq.put(val,new int[]{i,i,1});
            }
            else{
                int [] arr = freq.get(val);
                arr[1]=i;
                arr[2]++;
            }
            deg=Math.max(deg,freq.get(val)[2]);
        }
        int len= nums.length;
        for(int key : freq.keySet()){
            int []arr = freq.get(key);
            if(arr[2]==deg){
                len =Math.min(len, arr[1]-arr[0]+1);
            }
        }
        return len;
    }
}