class Solution {
    public int minScoreTriangulation(int[] values) {
        int n=values.length;
        // return helperRec(values,0,n-1);

        int[][] dp = new int[n + 1][n + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helperMem(values, 0, n - 1, dp);

        // return helperTab(values);
    }


    // recursive approach -
    public int helperRec(int[]values, int i, int j){
        if(i+1==j){
            return 0;
        }

        int ans=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            ans=Math.min(ans,values[i]*values[j]*values[k]+helperRec(values,i,k)+helperRec(values,k,j));
        }

        return ans;
    }

    // memoization
    public int helperMem(int[]values, int i, int j,int [][]dp){
        if(i+1==j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int ans=Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
             ans = Math.min(ans, values[i] * values[j] * values[k] + helperMem(values, i, k, dp) + helperMem(values, k, j, dp));
        }

        return dp[i][j]=ans;
    }

    // tabulation
   public int helperTab(int[] values){
        int x = values.length;
        int[][] dp = new int[x + 1][x + 1];

        for(int i = x - 1; i >= 0; i--){
            for(int j = i + 2; j < x; j++){ // i + 2 se isliye start kra h because minimum 3 nodes honi chaiye to 1 and 2 pe triangle nhi bnega
                int ans = Integer.MAX_VALUE;
                for(int k = i + 1; k < j; k++){
                    ans = Math.min(ans, values[i] * values[j] * values[k] + dp[i][k] + dp[k][j]);
                }
                dp[i][j] = ans;
            }
        }
        return dp[0][x - 1];
    }
}