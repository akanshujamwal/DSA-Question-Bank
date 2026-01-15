
/**
 * Given an integer columnNumber, return its corresponding column title as it
 * appears in an Excel sheet.
 * 
 * For example:
 * 
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * 
 * 
 * Example 1:
 * 
 * Input: columnNumber = 1
 * Output: "A"
 * Example 2:
 * 
 * Input: columnNumber = 28
 * Output: "AB"
 * Example 3:
 * 
 * Input: columnNumber = 701
 * Output: "ZY"
 * 
 * 
 * Constraints:
 * 
 * 1 <= columnNumber <= 231 - 1
 */
class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int rem = (columnNumber - 1) % 26;
            sb.append((char) (rem + 'A'));
            columnNumber = (columnNumber - 1) / 26;
        }
        return sb.reverse().toString();
    }
}
//solution 2
class Solution {
    public String convertToTitle(int columnNumber) {
        // Base Case: If number is 0, stop recursion
        if (columnNumber == 0) {
            return "";
        }

        // 1. Adjust to 0-indexed (1 -> 0, 26 -> 25)
        columnNumber--;

        // 2. Recursive Step: Get the title for the rest of the number
        // and add the current character at the end.
        return convertToTitle(columnNumber / 26) + (char) ('A' + columnNumber % 26);
    }
}