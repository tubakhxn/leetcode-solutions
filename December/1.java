
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        // Using String.join to concatenate strings in word1 and word2
        String s1 = String.join("", word1);
        String s2 = String.join("", word2);
        
        return s1.equals(s2);
    }
}
