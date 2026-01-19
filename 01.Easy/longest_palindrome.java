/*
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome.

 

Example 1:

Input: s = "abccccdd"
Output: 7
Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
Example 2:

Input: s = "a"
Output: 1
Explanation: The longest palindrome that can be built is "a", whose length is 1.
 

Constraints:

1 <= s.length <= 2000
s consists of lowercase and/or uppercase English letters only.
 */
class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int [128];

        for (char ch: s.toCharArray()){
            count[ch]++;
        }
        int res = 0;
        for(int i=0; i<128; i++){
            int val = count[i];
            res = res+(val/2)*2;
            if(res%2 == 0 && val%2==1 ){
                res++;
            }
        }
        return res;
    }
}

import java.util.HashSet;

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0;

        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                // We found a matching pair
                set.remove(ch);
                res += 2;
            } else {
                // Add the character waiting for a match
                set.add(ch);
            }
        }

        // If the set is not empty, it means we have unmatched characters.
        // We can take exactly one of them to put in the middle.
        if (!set.isEmpty()) {
            res++;
        }

        return res;
    }
}
