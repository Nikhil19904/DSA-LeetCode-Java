class Solution {
    public List<Boolean> camelMatch(String[] queries, String s) {
        List<Boolean>res=new ArrayList<>();
        for(String e:queries){
            res.add(soln(e,s));
        }
        return res;
    }
    public boolean soln(String e,String s){
            int i=0,j=0,flag=0;
            while(i<e.length()){
                if(j<s.length()&&e.charAt(i)==s.charAt(j)){
                    j++;
                }
                else if(Character.isUpperCase(e.charAt(i))){
                    return  false;
                }
                i++;
            }
        return j==s.length();
    }
}