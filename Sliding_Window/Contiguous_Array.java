/* 525. Contiguous Array

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Example 1:
Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

Example 2:
Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

Example 3:
Input: nums = [0,1,1,1,1,1,0,0,0]
Output: 6
Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
*/

import java.util.HashMap;
import java.util.Map;

public class Contiguous_Array {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map =new HashMap<>();
        map.put(0,-1);
        int prefixSum= 0;
        int count = 0;

        for(int i=0; i<nums.length; i++){

            prefixSum+= (nums[i]== 1) ? 1: -1;
            if(map.containsKey(prefixSum)){
                count= Math.max(count, i- map.get(prefixSum));
            }else{
                map.put(prefixSum, i);
            }
        }
        return count;
    }
}
