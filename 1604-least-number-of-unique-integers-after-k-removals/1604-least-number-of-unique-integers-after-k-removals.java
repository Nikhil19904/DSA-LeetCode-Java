
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // Step 1: Count frequency of each integer
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Add frequencies to a min-heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int freq : freqMap.values()) {
            minHeap.offer(freq);
        }

        // Step 3: Remove k elements using frequencies
        while (k > 0 && !minHeap.isEmpty()) {
            int freq = minHeap.poll(); // least frequent element
            if (k >= freq) {
                k -= freq; // fully remove this number
            } else {
                // Not enough k to remove full frequency
                minHeap.offer(freq - k); // partially remove
                break;
            }
        }

        // Remaining elements in heap = unique integers left
        return minHeap.size();
    }
}
