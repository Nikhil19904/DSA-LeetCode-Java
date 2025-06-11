class Solution {
    public boolean canSortArray(int[] arr) {
        int length = arr.length;

        // Check all pairs of elements to see if the array can be sorted
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                // If elements are out of order
                if (arr[j] < arr[i]) {
                    // Check if they have the same bit count
                    if (Integer.bitCount(arr[i]) != Integer.bitCount(arr[j])) {
                        // Return false if they can't be swapped to sort the array
                        return false;
                    }

                    // Swap elements to move the smaller one forward
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        // Final check to ensure the array is sorted
        for (int k = 0; k < length-1; k++) {
            if (arr[k] > arr[k + 1]) 
                return false;
        }

        return true;
    }
}

