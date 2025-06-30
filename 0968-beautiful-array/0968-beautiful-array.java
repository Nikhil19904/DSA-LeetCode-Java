class Solution {
    public int[] beautifulArray(int N) {
        int[] res = new int[N];
        if (N == 1) 
        {
            return new int[] {1};
        }
        else if (N == 2) 
        {
            return new int[] {1, 2};
        }
        else
        {
            int[] odds = beautifulArray((N + 1) / 2);
            int[] even = beautifulArray(N / 2);
            for (int i = 0; i < odds.length; i ++) 
            {
                res[i] = odds[i] * 2 - 1;
            }
            for (int j = 0; j < even.length; j ++) 
            {
                res[odds.length + j] = even[j] * 2;
            }
        }
        return res;
    }
}