class Solution {
    public String simplifyPath(String path) {
        String arr[] = path.split("/");
        Stack<String> stk = new Stack<>();
        for(String str : arr){
            if(!stk.isEmpty() && str.equals("..")){
                stk.pop();
            } else if(!str.equals(".") && !str.equals("") && !str.equals("..")){
                stk.push(str);
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(String str : stk){
            sb.append("/");
            sb.append(str);
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}