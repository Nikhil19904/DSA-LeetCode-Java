class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) {
            return new ArrayList<>();
        }
        return helper("", digits);
    }

    static List<String> helper(String processed, String up){
        if(up.length() == 0){
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }

        int button = up.charAt(0) - '0';
        List<String> ans = new ArrayList<>();

        if(button >= 2 && button <= 6){
            for(int i = (button - 2) * 3; i < (button - 1) * 3; i++){
                char ch = (char)('a' + i);
                ans.addAll(helper(processed + ch, up.substring(1)));
            }
        }
        else if(button == 7){
            for(int i = 15; i < 19; i++){
                char ch = (char)('a' + i);
                ans.addAll(helper(processed + ch, up.substring(1)));
            }
        }
        else if(button == 8){
            for(int i = 19; i < 22; i++){
                char ch = (char)('a' + i);
                ans.addAll(helper(processed + ch, up.substring(1)));
            }
        }
        else if(button == 9){
            for(int i = 22; i < 26; i++){
                char ch = (char)('a' + i);
                ans.addAll(helper(processed + ch, up.substring(1)));
            }
        }

        return ans;
    }
}