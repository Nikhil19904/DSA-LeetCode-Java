class Solution {
    public void solve(int[] nums, int index, List<Integer> output, Set<List<Integer>> ans) {
        // base case: if we have reached the end of the input array
        if (index >= nums.length) {
            // only add the output if it has more than one element
            if (output.size() > 1) {
                ans.add(new ArrayList<>(output));
            }
            return;
        }
        
        // if the output is empty or the current element is greater than or equal to the last element in the output
        if (output.isEmpty() || nums[index] >= output.get(output.size() - 1)) {
            // add the current element to the output and recursively call solve
            output.add(nums[index]);
            solve(nums, index+1, output, ans);
            // remove the last element from the output before returning
            output.remove(output.size() - 1);
        }
        
        // recursively call solve without adding the current element to the output
        solve(nums, index+1, output, ans);
    }
    
    public List<List<Integer>> findSubsequences(int[] nums) {
        // use a set to store the unique sub sequences
        Set<List<Integer>> ans = new HashSet<>();
        solve(nums, 0, new ArrayList<>(), ans);
        return new ArrayList<>(ans);
    }
}