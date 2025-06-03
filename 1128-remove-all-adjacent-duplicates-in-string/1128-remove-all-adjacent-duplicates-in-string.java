class Solution {

    public static String remAllAdjDupStr(String str){
        Stack<Character>stk=new Stack<>();
        StringBuilder sb=new StringBuilder("");
        stk.push('{');

        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==stk.peek()){
                stk.pop();

            }
            else{
                stk.push(str.charAt(i));
            }
        }

        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        return str = sb.reverse().toString().substring(1);
    }

    public String removeDuplicates(String s) {
        return remAllAdjDupStr(s);
    }
}