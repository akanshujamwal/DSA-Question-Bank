/*
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * 
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "A man, a plan, a canal: Panama"
 * Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * Example 2:
 * 
 * Input: s = "race a car"
 * Output: false
 * Explanation: "raceacar" is not a palindrome.
 * Example 3:
 * 
 * Input: s = " "
 * Output: true
 * Explanation: s is an empty string "" after removing non-alphanumeric
 * characters.
 * Since an empty string reads the same forward and backward, it is a
 * palindrome.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2 * 105
 * s consists only of printable ASCII characters.
 */
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            char charStart = s.charAt(start);
            char charEnd = s.charAt(end);

            // 1. Move start forward if current char is not a letter or digit
            if (!Character.isLetterOrDigit(charStart)) {
                start++;
            }
            // 2. Move end backward if current char is not a letter or digit
            else if (!Character.isLetterOrDigit(charEnd)) {
                end--;
            }
            // 3. Both are valid characters, so compare them
            else {
                // Compare characters in lowercase
                if (Character.toLowerCase(charStart) != Character.toLowerCase(charEnd)) {
                    return false;
                }
                // Continue inward
                start++;
                end--;
            }
        }

        return true;
    }
}
//solution 2
class Solution {
    public boolean isPalindrome(String s) {
            // WRITE YOUR CODE HERE	
		String LowerString = s.toLowerCase();
		String finalString =LowerString.replaceAll("[^a-zA-Z0-9]", "");
		  int start = 0;
       int end = finalString.length() - 1;
      while (start < end) {
    if (finalString.charAt(start) != finalString.charAt(end)) {
                return false; // Not a palindrome
            }
            start++;
            end--;
}
return true;
    }
}