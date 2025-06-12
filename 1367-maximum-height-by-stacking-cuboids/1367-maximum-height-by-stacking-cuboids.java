class Solution {
    public int maxHeight(int[][] cuboids) {
        int n = cuboids.length;
        
        // Step 1: Sort dimensions of each cuboid (to handle rotations)
        for (int[] c : cuboids) {
            Arrays.sort(c);  // sort each cuboid: [l, w, h]
        }

        // Step 2: Sort cuboids based on dimensions
        Arrays.sort(cuboids, (a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            if (a[1] != b[1]) return a[1] - b[1];
            return a[2] - b[2];
        });

        // Step 3: DP to find max height
        int[] dp = new int[n];
        int max = 0;

        for (int i = 0; i < n; i++) {
            dp[i] = cuboids[i][2]; // base case: height if it's alone
            for (int j = 0; j < i; j++) {
                if (canPlace(cuboids[j], cuboids[i])) {
                    dp[i] = Math.max(dp[i], dp[j] + cuboids[i][2]);
                }
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    // Helper to check if 'below' cuboid can be placed below 'above' cuboid
    private boolean canPlace(int[] below, int[] above) {
        return below[0] <= above[0] && below[1] <= above[1] && below[2] <= above[2];
    }
}
