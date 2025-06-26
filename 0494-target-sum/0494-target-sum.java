class Solution {
    private int solve(int i , int curr ,int target , int nums[]){
        if( i == nums.length){
            if(curr == target){
                return 1;
            }

            return 0;
        }

        int plus = solve(i+1 , curr + nums[i] , target ,nums ); 
        int minus = solve(i+1 , curr - nums[i] , target ,nums ); 

        return plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
         return solve(0 , 0 , target , nums);
    }
}