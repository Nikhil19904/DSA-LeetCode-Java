class Solution {
    public int findNonMinOrMax(int[] nums) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int i=0;i<nums.length;i++){
            max=Math.max(nums[i],max);
            min=Math.min(nums[i],min);

        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]<max && nums[i]>min){
                min=nums[i];
                return min;
            }
        }

        return -1;
    }
}