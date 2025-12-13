
/*Given a string s, find the length of the longest substring without duplicate characters.

 

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int res = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap();
        char[] arr = s.toCharArray();
        for (; right < arr.length; right++) {
            int idx = map.getOrDefault(arr[right], -1);
            if (idx != -1 && idx >= left) {
                res = Math.max(res, right - 1 - left + 1);
                left = idx + 1;

            }
            map.put(arr[right], right);

        }
        return Math.max(res, right - 1 - left + 1);
    }
}