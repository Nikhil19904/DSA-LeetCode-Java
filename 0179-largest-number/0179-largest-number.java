class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];

        // Convert each int to string
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Sort using custom comparator
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is "0", return "0"
        if (strNums[0].equals("0")) return "0";

        // Concatenate the sorted strings
        StringBuilder result = new StringBuilder();
        for (String s : strNums) {
            result.append(s);
        }

        return result.toString();
    }
}