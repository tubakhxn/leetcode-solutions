public class Solution {
    public long wonderfulSubstrings(String word) {
        // Map to store frequency of each mask encountered
        Map<Integer, Long> prefixCount = new HashMap<>();
        // Start with the empty string prefix, which is a valid "all even" count
        prefixCount.put(0, 1L);

        int mask = 0;
        long result = 0;

        for (char ch : word.toCharArray()) {
            // Update the current mask by flipping the bit corresponding to the current character
            // 'a' at bit 0, 'b' at bit 1, ..., 'j' at bit 9
            mask ^= (1 << (ch - 'a'));
            
            // Check if the current mask has appeared before
            result += prefixCount.getOrDefault(mask, 0L);

            // Check for masks where exactly one character's count is odd
            for (int i = 0; i < 10; i++) { // Checking for each character a-j
                int maskWithOneFlipped = mask ^ (1 << i);
                result += prefixCount.getOrDefault(maskWithOneFlipped, 0L);
            }

            // Update the prefix count for the current mask
            prefixCount.put(mask, prefixCount.getOrDefault(mask, 0L) + 1);
        }

        return result;
    }
}
//A wonderful string is a string where at most one letter appears an odd number of times.

//For example, "ccjjc" and "abab" are wonderful, but "ab" is not.
//Given a string word that consists of the first ten lowercase English letters ('a' through 'j'), return the number of wonderful non-empty substrings in word. If the same substring appears multiple times in word, then count each occurrence separately.

//A substring is a contiguous sequence of characters in a string.

 
