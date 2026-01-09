package com.farid.ahadli.T1Array.T4KadanesAlgorithm;

public class Q53MaximumSubarray {
  class Solution {
    public int maxSubArray(int[] nums) {
      int[] prefixSum  = new int [nums.length+1];

      prefixSum[0] = 0;
      int minTillIndex = 0;
      int maxDiff = Integer.MIN_VALUE;

      for(int i = 0; i < nums.length; i++ ){
        prefixSum[i+1] = prefixSum[i] + nums[i];
      }

      for(int i = 1; i<nums.length+1;i++ ){
        maxDiff = (prefixSum[i] - minTillIndex)>maxDiff?prefixSum[i] - minTillIndex :maxDiff;
        minTillIndex = prefixSum[i] < minTillIndex ? prefixSum[i] : minTillIndex;
      }

      return maxDiff;

    }
  }
}
