import java.util.*;

class Solution {
    public int countPairs(int[] deliciousness) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int mod = 1_000_000_007;
        int count = 0;

        for (int x : deliciousness) {
            // Check for all powers of two up to 2^21
            for (int i = 0; i <= 21; i++) {
                int powerOfTwo = 1 << i;
                int complement = powerOfTwo - x;

                count = (count + map.getOrDefault(complement, 0)) % mod;
            }

            // Store this value in the map for future use
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        return count;
    }
}
