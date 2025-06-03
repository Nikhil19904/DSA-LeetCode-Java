class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        // to store both height and names
        HashMap<Integer,String>mp=new HashMap<>();
        for(int i=0;i<names.length;i++){
            mp.put(heights[i],names[i]);
        }

        Arrays.sort(heights);  //sort heights

        String[] result=new String[heights.length];
        int index=0;
        for(int i=heights.length-1;i>=0;i--){
          result[index] = mp.get(heights[i]);
            index++;   
        }
        return result;
    }
}