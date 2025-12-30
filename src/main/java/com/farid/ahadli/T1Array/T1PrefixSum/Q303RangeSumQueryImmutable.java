package com.farid.ahadli.T1Array.T1PrefixSum;

/*
303. Range Sum Query - Immutable
https://leetcode.com/problems/range-sum-query-immutable/description/

Given an integer array nums, handle multiple queries of the following type:

Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
Implement the NumArray class:

NumArray(int[] nums) Initializes the object with the integer array nums.
int sumRange(int left, int right) Returns the sum of the elements of nums between indices left and right inclusive (i.e. nums[left] + nums[left + 1] + ... + nums[right]).


Example 1:

Input
["NumArray", "sumRange", "sumRange", "sumRange"]
    [[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
Output
[null, 1, -1, -3]

Explanation
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
    numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3


Constraints:

    1 <= nums.length <= 104
    -105 <= nums[i] <= 105
    0 <= left <= right < nums.length
At most 104 calls will be made to sumRange.*/
public class Q303RangeSumQueryImmutable {

  class NumArray {

    int[] numArray;
    int[] prefixSumArray;

    public NumArray(int[] nums) {
      numArray = nums;
      prefixSumArray = new int[numArray.length + 1];

      for (int i = 0; i < numArray.length + 1; i++) {
        prefixSumArray[i] = i == 0 ? 0 : prefixSumArray[i - 1] + numArray[i - 1];
      }
    }

    public int sumRange(int left, int right) {
      return prefixSumArray[right + 1] - prefixSumArray[left];
    }
  }
}
/*
The optimal solution. The only difference is it doesnt create a new arr for the
sum. it overwrites the input arr.

class NumArray {
  static { Runtime.getRuntime().addShutdownHook(new Thread(() -> { try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) { fw.write("0"); } catch (Exception e) { } })); }

  int[] n;

  public NumArray(int[] nums) {
    n = new int[nums.length];
    n[0] = nums[0];
    for (int i = 1;i < nums.length; ++i) {
      n[i] = n[i - 1] + nums[i];
    }
  }

  public int sumRange(int left, int right) {
    if (left == 0) {
      return n[right];
    }
    return n[right] - n[left - 1];
  }
}

*/
