package com.farid.ahadli.T1Array.T2TwoPointers;

/*Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

https://leetcode.com/problems/trapping-rain-water/description/

    Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9


Constraints:

n == height.length
1 <= n <= 2 * 104
    0 <= height[i] <= 105*/

import java.util.HashMap;
import java.util.Map;

public class Q42TrappingRainWater {

  class Solution {


    public int trap(int[] height) {

      int[] gradient = new int[height.length];
      gradient[0] = 0;

      for (int i = 1; i < height.length; i++) {
        gradient[i] = height[i] - height[i - 1];
      }

      int pointerOne = 0;
      int pointerTwo = 1;
      boolean isStartSet = false;
      boolean isEndSet = false;
      int startPeak = -1;
      int endPeak = -1;
      boolean isPastDip = false;
      // start and end of valley
      int[] peaksIndex = new int[height.length];
      int[] peaksValue = new int[height.length];
      int peakCounter = 0;
      Map<Integer,Integer> finalValleys = new HashMap<>();
      while (pointerOne < height.length && pointerTwo < height.length) {
        if (!isStartSet) {
          if (height[pointerOne] > 0 && gradient[pointerTwo] < 0) {
            pointerTwo++;
            isStartSet = true;
            continue;
          } else {
            pointerOne++;
            pointerTwo = pointerOne + 1;
            continue;
          }
        } else {
          if (gradient[pointerTwo] <= 0 && !isPastDip) {
            pointerTwo++;
          } else if (gradient[pointerTwo] > 0 && !isPastDip) {
            isPastDip = true;
            pointerTwo++;
          } else if (gradient[pointerTwo] >= 0 && isPastDip) {
            pointerTwo++;
          } else {

            peaksIndex[peakCounter] = pointerOne;
            peaksValue[peakCounter++] = height[pointerOne];
            peaksIndex[peakCounter] = pointerTwo;
            peaksValue[peakCounter] = height[pointerTwo];
            startPeak = pointerOne;
            endPeak = pointerTwo;
            pointerOne = pointerTwo;
            pointerTwo = pointerOne + 1;
            isPastDip = false;
          }
        }
      }
        int pointerA = 0;
        int pointerB = 1;
        while(pointerA<=peakCounter && pointerB<=peakCounter){
          int currentHeight = peaksValue[pointerA];

          if(currentHeight>peaksValue[pointerB]){
            pointerB++;
          }else{
            finalValleys.put(pointerA,pointerB);
            pointerA = pointerB;
            pointerB = pointerA+1;
          }
        }

        for( Integer i : finalValleys.keySet()){
          Integer j = finalValleys.get(i);
          int vol = 0;

          for(int k =i; i<=j; k++ ){
            vol+=( height[k]);
          }

        }

      return 0;

    }
  }

}
