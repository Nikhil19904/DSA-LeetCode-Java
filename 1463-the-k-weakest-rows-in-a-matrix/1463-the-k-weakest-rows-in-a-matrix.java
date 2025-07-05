class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Pair<Integer, Integer>> minQueue = 
            new PriorityQueue<>((o1, o2) -> {
                int temp = o1.getValue() - o2.getValue();
                if(temp != 0) {
                    return temp;
                } else {
                    return o1.getKey() - o2.getKey();
                }
            });
        for(int i = 0; i < mat.length; i++) {
            int count = 0;
            for(int n : mat[i]) {
                if(n == 1) count++;
            }
            minQueue.add(new Pair<>(i, count));
        }
        System.out.println(minQueue);
        int res[] = new int[k];
        for(int i = 0; i < k; i++) {
            res[i] = minQueue.poll().getKey();
        }
        return res;
    }
}