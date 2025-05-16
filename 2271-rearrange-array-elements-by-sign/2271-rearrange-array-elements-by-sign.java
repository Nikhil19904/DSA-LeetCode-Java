class Solution {
    public int[] rearrangeArray(int[] nums) {
        int posi=0;
        int neg=1;

        int result[]=new int [nums.length];

        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result[posi]=nums[i];
                posi=posi+2;
            }

            else{
                result[neg]=nums[i];
                neg=neg+2;
            }
        }

        return result;
    }
}