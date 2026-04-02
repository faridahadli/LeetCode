package com.farid.ahadli.T3Recursion;

public class Q1922CountGoodNumbers {
    class Solution {
        static final int MOD = 1000000007;
        public static long modPow(long base, long exp, int mod) {
            long result = 1;
            base = base % mod;
            while (exp > 0) {
                if ((exp % 2) == 1) result = (result * base) % mod;
                base = (base * base) % mod;
                exp /= 2;
            }
            return result;
        }

        public int countGoodNumbers(long n) {

            long oddPlaces = n/2;
            long evenPlaces = n-oddPlaces;

            return (int) ((modPow(4,oddPlaces,MOD) * modPow(5,evenPlaces,MOD)) % MOD);

        }
    }
}
