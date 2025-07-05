class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        LinkedList<Integer>index=new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target)
                index.add(i);
        }
        return index;
    }
}