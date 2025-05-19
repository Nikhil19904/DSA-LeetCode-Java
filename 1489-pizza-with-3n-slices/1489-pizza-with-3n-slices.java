class Solution {
    public int maxSizeSlices(int[] slices) {
        return Math.max(
            solveTab(slices, 0, slices.length - 2),
            solveTab(slices, 1, slices.length - 1)
        );
    }

    private int solveTab(int[] slices, int start, int end) {
        int len = end - start + 1;
        int n = slices.length / 3;
        int[][] dp = new int[len + 2][n + 1]; // +2 for i+2 case

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 1; j <= n; j++) {
                int take = slices[start + i] + dp[i + 2][j - 1];
                int skip = dp[i + 1][j];
                dp[i][j] = Math.max(take, skip);
            }
        }

        return dp[0][n];
    }
}
