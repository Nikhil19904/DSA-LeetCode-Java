class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans=new ArrayList<>();
        for(int i=0;i<l.length;i++){
            int left=l[i];
            int right=r[i];
            int[] temp=Arrays.copyOfRange(nums,left,right+1);
            Arrays.sort(temp);
            int q=temp[1]-temp[0];
            Boolean a=true;
            for(int j=1;j<temp.length-1;j++){
                if(temp[j+1]-temp[j]!=q) a=false; 
            }
            if(a) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
}