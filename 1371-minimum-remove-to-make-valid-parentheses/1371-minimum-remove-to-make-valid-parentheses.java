class Solution {
    public String minRemoveToMakeValid(String s) {
        // Initializze count for left and right parenthese
        int leftCount=0;
        int rightCount =0;

        // use a stack to keep track
        Stack<Character>st=new Stack<>();

         // Pass 1: Iterate through the string and process parentheses
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            
            // Increment count for left parentheses
            if (currentChar == '(') {
                leftCount++;
            }
            // Increment count for right parentheses
            if (currentChar == ')') {
                rightCount++;
            }

            
            // If there are more right parentheses than left, skip the current right parenthesis
            if (rightCount > leftCount) {
                rightCount--; // Decrease right count
                continue;     // Skip processing this right parenthesis
            } else {
                st.push(currentChar); // Add valid parentheses to the stack
            }

        }

         // Pass 2: Reconstruct the string using the valid parentheses in the stack
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            char currentChar = st.pop();
            // If there are more left parentheses than right, skip the current left parenthesis
            if (leftCount > rightCount && currentChar == '(') {
                leftCount--; // Decrease left count
                // Do nothing, skip this left parenthesis
            } else {
                result.append(currentChar); // Add valid parentheses to the result
            }
        }

        // Reverse the result string and return
        return result.reverse().toString();



    }
}