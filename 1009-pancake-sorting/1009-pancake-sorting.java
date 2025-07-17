class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length;
        int[] indices = new int[n];
        for(int i=0; i<n; ++i) indices[arr[i]-1] = i;
        for(int i=0; i<n; ++i) {
            int pull = indices[i];
            dew(stack, i, pull);
            indices[arr[i]-1] = pull;
            indices[i] = i;
            arr[pull] = arr[i];
            arr[i] = i+1;
        }
        LinkedList<Integer> ans = new LinkedList<>();
        while(!stack.isEmpty()) {
            int x = stack.pop();
            ans.addFirst(x);
        }
        return ans;
    }
    
    private void dew(Stack<Integer> stack, int j, int i) {
        if(i != j) {
            add(stack, i+1);
            add(stack, i-j+1);
            add(stack, i-j);
            add(stack, i-j-1);
            add(stack, i-j);
            add(stack, i+1);
        }
    }
    
    private void add(Stack<Integer> stack, int x) {
        if(x > 1) {
            if(!stack.isEmpty() && stack.peek() == x) stack.pop();
            else stack.push(x);
        }
    }
}