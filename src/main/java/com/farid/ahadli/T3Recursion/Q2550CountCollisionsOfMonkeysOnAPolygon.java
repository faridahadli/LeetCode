package com.farid.ahadli.T3Recursion;

public class Q2550CountCollisionsOfMonkeysOnAPolygon {
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

        public static int monkeyMove(int n) {
            long ans = (modPow(2, n, MOD) - 2 + MOD) % MOD;
            return (int) ans;
        }


    }
    public static void main(String[] args) {
        System.out.println(Solution.monkeyMove(55));
    }

    ///  got hte idea right but was not fast
}
