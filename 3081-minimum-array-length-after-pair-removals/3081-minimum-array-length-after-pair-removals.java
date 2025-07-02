class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();  // Total number of elements in the array.
        int mid = n / 2;      // The number of elements we want to keep.

        int i = n - 1;  // Pointer to the end of the array.
        int j = mid - 1;  // Pointer to the middle of the array.
        int removals = 0;  // Count of elements to remove.

        // Iterate from the end of the array towards the middle.
        while (j >= 0) {
            if (nums.get(i) > nums.get(j)) {
                removals += 2;  // If nums[i] > nums[j], we need to remove two elements.
                i--;
            }
            j--;
        }

        // Remaining length will be total length minus removed elements in pairs
        return n - removals;
    }
}