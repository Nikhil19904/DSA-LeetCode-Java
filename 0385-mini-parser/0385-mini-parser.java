/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    public NestedInteger deserialize(String s) {
        Object parsed = parse(s);
        return dfs(parsed);
    }

    private Object parse(String s) {
        if (s.charAt(0) == '[') {
            List<Object> list = new ArrayList<>();
            int start = 1, depth = 0;
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) == '[') depth++;
                else if (s.charAt(i) == ']') depth--;
                else if (s.charAt(i) == ',' && depth == 0) {
                    list.add(parse(s.substring(start, i)));
                    start = i + 1;
                }
            }
            if (start < s.length() - 1) list.add(parse(s.substring(start, s.length() - 1)));
            return list;
        } else {
            return Integer.parseInt(s);
        }
    }

    private NestedInteger dfs(Object input) {
        if (input instanceof Integer) {
            return new NestedInteger((int) input);
        }
        NestedInteger ni = new NestedInteger();
        for (Object obj : (List<Object>) input) {
            ni.add(dfs(obj));
        }
        return ni;
    }
}