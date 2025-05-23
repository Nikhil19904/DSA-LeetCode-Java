class Solution {
    // public int combinationSum4(int[] nums, int target) {
    //     if(target==0){
    //         return 1;
    //     }

    //     int ans=0;
    //     for(int i=0;i<nums.length;i++){
    //         if(target>=nums[i]){
    //             ans=ans+combinationSum4(nums,target-nums[i]);
    //         }
    //     }

    //     return ans;
    // }

    public int combinationSum4(int[]nums,int target){
        int[] comb=new int[target+1];
        comb[0]=1;
        for(int i=1;i<comb.length;i++){
            for(int j=0;j<nums.length;j++){
                if(i-nums[j]>=0){
                    comb[i] +=comb[i-nums[j]];
                }
            }
        }

        return comb[target];
    }
}