class Solution {
    public int maxFrequencyElements(int[] nums) {
        int freq[] = new int[101];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }

        int maxFreq = 0, totalMaxFreq = 0;

        for (int i = 1; i <= 100; i++) {
            maxFreq = Math.max(maxFreq, freq[i]);
        }

        for (int i = 1; i <= 100; i++) {

            if (maxFreq == freq[i])
                totalMaxFreq += freq[i];
        }

        return totalMaxFreq;
    }
}