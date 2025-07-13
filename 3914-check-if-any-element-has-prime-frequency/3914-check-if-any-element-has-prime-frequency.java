class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            // Skip duplicate numbers
            boolean checked = false;
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) {
                    checked = true;
                    break;
                }
            }
            if (checked) continue;

            // Count frequency of nums[i]
            int freq = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    freq++;
                }
            }

            // Check if frequency is a prime number
            if (freq > 1) {
                boolean isPrime = true;
                for (int k = 2; k * k <= freq; k++) {
                    if (freq % k == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    return true;
                }
            }
        }

        return false;
    }
}