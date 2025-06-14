class Solution {
    public int numTrees(int n) {
        
		// array to cache the number of combinations against node count
        int[] dp = new int[n + 1];
		// base case
		dp[0] = dp[1] = 1;
		// traversing from 1 to n even though we need the result of n because for finding the nth node, we need the sub nodes value.
        for (int node = 2; node <= n; ++node) {
			// for each root node, calculating the left and right node count and finding the number of possible combinations from the cached array
            for (int root = 1; root <= node; ++root) {
                int left = root - 1, right = node - root;
                dp[node] += dp[left] * dp[right];
            }
        }
		// returning the last count since it gives the nth count
        return dp[n];
    }
    }