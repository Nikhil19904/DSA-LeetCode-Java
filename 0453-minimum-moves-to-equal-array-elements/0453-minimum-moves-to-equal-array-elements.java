class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE, moves = 0;

        for(int x : nums) if(x < min) min = x;

        for(int x : nums) moves += x - min;

        return moves;
    }
}