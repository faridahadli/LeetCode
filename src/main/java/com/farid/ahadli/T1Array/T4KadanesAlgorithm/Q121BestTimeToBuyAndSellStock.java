package com.farid.ahadli.T1Array.T4KadanesAlgorithm;
public class Q121BestTimeToBuyAndSellStock {
    class Solution {
        public int maxProfit(int[] prices) {

            int maxGain =  0;
            int minTillI = prices[0];
            int currentProfit = 0;

            for( int i = 1; i< prices.length; i++){
                currentProfit = prices[i] - minTillI;
                maxGain = Math.max(currentProfit, maxGain);
                minTillI = Math.min(minTillI, prices[i]);
            }
            return maxGain;
        }
    }
}
