package com.farid.ahadli.T3Recursion;

public class Q390EliminationGame {

    private int lastRemaining(int index,int stepSize,int n,boolean left){
        int index2 = left?index + (stepSize/2):index - (stepSize/2);
        if(index2 >= n || index2<0){
            return index;
        }
        index = index2;
        int jump = left?((n-index-1)/stepSize): -(index/stepSize);
        index = index + jump*stepSize;
        return lastRemaining( index, stepSize*2,n, !left );
    }

    public int lastRemaining(int n) {
        return lastRemaining(0,2,n,true) +1;
    }
    /*
        public int lastRemaining(int n) {
            int head = 1, step = 1;
            boolean left = true;
            while (n > 1) {
                if (left || n % 2 == 1)
                    head += step;
                step *= 2;
                n /= 2;
                left = !left;
            }
            return head;
         }

        int head = 1, step = 1;
        boolean left = true;

            head = the first surviving number in the current round
            step = gap between surviving numbers (doubles each round)
            left = direction of current round

       while (n > 1) {

            keep going until only 1 number remains


        if (left || n % 2 == 1)
            head += step;

            if we're going left to right, the leftmost always gets eliminated, so head always moves right by step
            if we're going right to left, head only moves if n is odd — because if odd, the leftmost survivor gets eliminated too


        step *= 2;
        n /= 2;
        left = !left;

            step doubles because survivors are now twice as far apart
            n halves because half the numbers got eliminated
            flip direction for next round


        The key insight is you only need to track head — you don't need to store the whole list.
        Every round either moves head or keeps it, based on direction and parity.

     */

}
