package com.farid.ahadli.T1Array.T3ReverseArray;

public class Q344ReverseString {

  class Solution {

    public void reverseString(char[] s) {
      int pointerOne = 0;
      int pointerTwo = s.length -1;
      char holder;

      while (pointerOne < pointerTwo) {
        holder = s[pointerOne];
        s[pointerOne] = s[pointerTwo];
        s[pointerTwo] = holder;
        pointerOne++;
        pointerTwo--;
      }

    }
  }
}
