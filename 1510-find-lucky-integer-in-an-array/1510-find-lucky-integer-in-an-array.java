class Solution {
    public static int findLucky(int[] arr) {
        
    	int n =  arr.length;
    	HashMap<Integer, Integer> hm =  new HashMap<Integer, Integer>();
    	
    	for (int i = 0; i < n; i++) {
			hm.put(arr[i], hm.getOrDefault(arr[i], 0)+1);
		}
    	
    	
    	int ans = -1;
    	
    	for(int a : hm.keySet()) {
    		
    		if(a ==  hm.get(a)) {
    			ans = Math.max(a, ans);
    		}
    		
    	}
    	
    	return ans;
    }
}