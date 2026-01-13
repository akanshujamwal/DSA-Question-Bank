/*
 * Given a string s consisting of words and spaces, return the length of the
 * last word in the string.
 * 
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * Example 2:
 * 
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * Example 3:
 * 
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 */
//solution 1
class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;

        // Start from the very end of the string
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c != ' ') {
                // If we found a character, increment length
                length++;
            } else if (length > 0) {
                // If we found a space AND we have already counted some letters,
                // it means we just finished the last word.
                return length;
            }
        }

        return length;
    }
}
//solution 2
class Solution {
    public int lengthOfLastWord(String s) {
        // 1. Trim whitespace from both ends of the string.
        String trimmedS = s.trim();

        // 2. Split the string by one or more spaces into an array of words.
        String[] words = trimmedS.split("\\s+");

        // 3. The last word is the last element in the array.
        String lastWord = words[words.length - 1];

        // 4. Return its length.
        return lastWord.length();
    }
}
//solution 3
class Solution {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");

        // int len = words[words.length - 1].length();

        return words[words.length - 1].length();

    }
}