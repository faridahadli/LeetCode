package com.farid.ahadli.T1Array.T2TwoPointers;

import java.util.Arrays;

public class Q1TwoSum {
    class Solution {
      public int[] twoSum(int[] nums, int target) {

        int[] numsToSort = Arrays.copyOf(nums,nums.length);
        Arrays.sort(numsToSort);

        int pointerA = 0;
        int pointerB = nums.length-1;
        int [] ret = new int[]{-1,-1};
        while(pointerA<pointerB){
        int sum =    (numsToSort[pointerA] + numsToSort[pointerB]);
          if ( sum == target ) {

            for(int i = 0; i<nums.length; i++ ){
              if(nums[i] == numsToSort[pointerA])
                ret[0] = i;

            }
            for(int i = nums.length-1; i>-1; i-- ){
              if(nums[i] == numsToSort[pointerB])
                ret[1] = i;

            }
            break;
          }else if(sum > target){
            pointerB--;
          }else {
            pointerA++;
          }


        }

        return ret;


      }


    }

}
