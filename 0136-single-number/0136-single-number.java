import java.util.HashMap;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }

        // Find the number that occurs only once
        for (int key : mp.keySet()) {
            if (mp.get(key) == 1) {
                return key;
            }
        }

        return -1; // Fallback, though problem states one number always appears once
    }
}
