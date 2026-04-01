package com.farid.ahadli.T3Recursion;

public class Q50PowXN {

    class Solution {

        private double invertX(double x, int n){
            return n>0?x:1/x;
        }
        private double myPow(double x, double originalX, int n, int counter ){
            if(n == 0){
                return 1;
            }
            if(n == 1){
                return x;
            }
            if( n-counter-counter<0){

                return x * myPow(originalX, originalX, n-counter,1);
            }else {
                x = x*x;
                counter = counter+counter;
            }
           return   myPow(x, originalX, n,counter);
        }

        public double myPow(double x, int n) {

            if(x==0){
                return 0;
            }
            if(n == 0){
                return 1;
            }

            return myPow(invertX(x,n), invertX(x,n),Math.abs(n),1);

        }

        /*

        class Solution {
    public double myPow(double x, int n) {
        // Handle MIN_VALUE overflow before negating
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;

        if (n % 2 == 0) {
            // Even: x^n = (x^2)^(n/2)
            double half = fastPow(x * x, n / 2);
            return half;
        } else {
            // Odd: x^n = x * x^(n-1)
            return x * fastPow(x, n - 1);
        }
    }
}
            divisibility by two saved it.
            MAJOR INSIGHT
            Even x^n = (x²)^(n/2) — halves the problem
            Odd x^n = x · x^(n-1) — makes it even, then halves
         */
    }


}
