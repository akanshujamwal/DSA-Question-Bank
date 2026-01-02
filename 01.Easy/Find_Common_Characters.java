/*
 * Given a string array words, return an array of all characters that show up in
 * all strings within the words (including duplicates). You may return the
 * answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["bella","label","roller"]
 * Output: ["e","l","l"]
 * Example 2:
 * 
 * Input: words = ["cool","lock","cook"]
 * Output: ["c","o"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] consists of lowercase English letters.
 */
class Solution {
    public List<String> commonChars(String[] words) {

        // Step 1: Initialize min frequency array
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, Integer.MAX_VALUE);

        // Step 2: Process each word
        for (String word : words) {

            int[] freq = new int[26];

            // Count frequency of current word
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                freq[ch - 'a']++;
            }

            // Update minimum frequency
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }

        // Step 3: Build result
        List<String> result = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }

        return result;

    }
}