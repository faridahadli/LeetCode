package com.farid.ahadli.T2String.T1Palindrome;

import java.util.Locale;

public class Q125ValidPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            s = s.replaceAll("[^A-Za-z0-9]", "").toUpperCase();
            byte [] byts = s.getBytes();
            int pointerA = 0;
            int pointerB = byts.length - 1;
            while(pointerA <=pointerB){
                if(byts[pointerA] != byts[pointerB]){
                    return false;
                }
                pointerA++;pointerB--;
            }
            return true;
        }
    }
}
