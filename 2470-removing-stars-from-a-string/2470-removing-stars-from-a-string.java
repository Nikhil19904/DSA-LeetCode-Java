class Solution {
    public String removeStars(String s) {
        Stack<Character> stack=new Stack<>();

        for(char c:s.toCharArray()){
            if(c=='*'){
                if(!stack.isEmpty()){
                    stack.pop();           
                }
            }
            else{
                stack.push(c);
            }
        }

      StringBuilder ans = new StringBuilder();
        for (char c : stack) ans.append(c);

        return ans.toString();

    }
}