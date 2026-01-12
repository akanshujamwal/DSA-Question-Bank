
/*
Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

 

Example 1:

Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
Example 2:

Input: nums = [1,2]
Output: 2
Explanation:
The first distinct maximum is 2.
The second distinct maximum is 1.
The third distinct maximum does not exist, so the maximum (2) is returned instead.
Example 3:

Input: nums = [2,2,3,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2 (both 2's are counted together since they have the same value).
The third distinct maximum is 1.
 

Constraints:

1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 
*/
//solution 1
class Solution {
    public int thirdMax(int[] nums) {
        // We use Long.MIN_VALUE because the input array might contain
        // Integer.MIN_VALUE.
        // If we initialized with Integer.MIN_VALUE, we couldn't distinguish between
        // an empty slot and an actual number.
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        long max3 = Long.MIN_VALUE;

        for (int num : nums) {
            // 1. Skip duplicates
            if (num == max1 || num == max2 || num == max3) {
                continue;
            }

            // 2. Update maximums by shifting values down
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }
        }

        // 3. Logic: If max3 was never updated, it means we have fewer than 3 distinct
        // numbers.
        // In that case, the problem requires returning the maximum (max1).
        if (max3 == Long.MIN_VALUE) {
            return (int) max1;
        }

        return (int) max3;
    }
}
//solution 2
public class Solution {
    public static int thirdMax(int[] nums) {
        // Sort using insertion sort
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else {
                    break;
                }
            }
        }

        // Remove duplicates manually
        int uniqueCount = 0;
        int[] unique = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                unique[uniqueCount++] = nums[i];
            }
        }

        // Return based on unique values
        if (uniqueCount < 3) {
            return unique[uniqueCount - 1];
        }
        return unique[uniqueCount - 3];
    }

    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}