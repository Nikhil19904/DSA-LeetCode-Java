class Solution {
    public String reversePrefix(String word, char ch) {
        int index = word.indexOf(ch); // Find the index of the first occurrence of the character 'ch' in the string 'word'. \U0001f604
                                        // If 'ch' is not found, indexOf returns -1.
        StringBuilder sb = new StringBuilder(word.substring(0, index + 1)); // Create a StringBuilder object 'sb' containing the substring of 'word' from the beginning to the index of 'ch' (inclusive). \U0001f6e0️
        sb.reverse(); // Reverse the substring stored in the StringBuilder object 'sb'. \U0001f504
        sb.append(word.substring(index + 1)); // Append the remaining part of the string 'word' (from the character after 'ch' to the end) to the reversed substring. ➕

        return sb.toString(); // Convert the StringBuilder object 'sb' back to a String and return the result. \U0001f389
    }
}