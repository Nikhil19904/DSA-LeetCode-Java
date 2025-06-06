class Solution {
    public int matrixSum(int[][] nums) {
        int rows=nums.length;
        int cols=nums[0].length;
        int score=0;

        for(int i=0;i<rows;i++){
            Arrays.sort(nums[i]);
        }

        for(int j=cols-1;j>=0;j--){
            int maxcol=0;
            for(int i=0;i<rows;i++){
                maxcol=Math.max(maxcol,nums[i][j]);
            }

            score+=maxcol;
        }

        return score;
    }
}