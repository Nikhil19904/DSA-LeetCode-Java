class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int index = nums.length-1;
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            if(Math.abs(nums[start]) > Math.abs(nums[end])){
                result[index] = nums[start] * nums[start];
                start++;
                index--;
            } else {
                result[index] = nums[end] * nums[end];
                end--;
                index--;
            }
        }
        return result;
    }
}