
/*Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.

An alphanumeric string is a string consisting of lowercase English letters and digits.

 

Example 1:

Input: s = "dfa12321afd"
Output: 2
Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
Example 2:

Input: s = "abc1111"
Output: -1
Explanation: The digits that appear in s are [1]. There is no second largest digit. 
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters and digits. */
class Solution {
    public int secondHighest(String s) {
        HashSet<Integer> hs = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                hs.add(ch - '0');
            }
        }
        int[] arr = new int[hs.size()];
        int k = 0;
        for (int i : hs) {
            arr[k] = i;
            k++;
        }
        if (arr.length < 2) {
            return -1;
        } else {
            return arr[arr.length - 2];
        }
    }
}