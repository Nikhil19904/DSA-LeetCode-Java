class Solution {
    public boolean canChoose(int[][] groups, int[] nums) {
        
        for(int i=0;i<groups.length;i++)
        {
            int j=0;
            int k=0;
            for(;j<nums.length && k<groups[i].length;)
            {
                if(nums[j] == groups[i][k])
                {
                    k++;
                    j++;
                }  
                else
                {
                    j = j-k+1;
                    k=0;
                }
            }
            if(k!=groups[i].length)
            {
                return false;
            }
            j--;
            while(j!=-1)
            {
                nums[j] = Integer.MIN_VALUE;
                j--;
            }
        }
        return true;
    }
}