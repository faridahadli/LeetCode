package com.farid.ahadli.T1Array.T1PrefixSum;

/*
https://leetcode.com/problems/subarray-sum-equals-k/
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

A subarray is a contiguous non-empty sequence of elements within an array.



    Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2


Constraints:

    1 <= nums.length <= 2 * 104
    -1000 <= nums[i] <= 1000
    -107 <= k <= 107*/

public class Q560SubarraySumEqualsK {
  public class Solution {
    public int subarraySum(int[] nums, int k) {
      int count = 0;
      for (int start = 0; start < nums.length; start++) {
        int sum = 0;
        for (int end = start; end < nums.length; end++) {
          sum += nums[end];
          if (sum == k) {
            count++;
          }
        }
      }
      return count;
    }
  }
}

/*

The best solution is crazy. It relies on the fact

1) Difference between prefix sum at y and x, y>x indicates the sum between and including y and x+1.
2) so lets say if I wanna check any subarray before and including up to y equals some value, target.
3) y- x = target, y-target = x!
4) I count the number of times the desired value appears! so the solution is below

import java.util.HashMap;

public class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int currentSum = 0;
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);  // Base case: A sum of zero is encountered once

        // Iterate through each number in the array
        for (int num : nums) {
            currentSum += num;  // Update the cumulative sum
            // Check if there is a subarray (ending at current index) which has the sum of k
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }
            // Record the current cumulative sum in the hashmap
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}

 */

