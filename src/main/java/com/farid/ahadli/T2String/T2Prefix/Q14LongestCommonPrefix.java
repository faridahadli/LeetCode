package com.farid.ahadli.T2String.T2Prefix;

public class Q14LongestCommonPrefix {
    class Solution {


        public String longestCommonPrefix(String[] strs) {
            StringBuilder result = new StringBuilder();
            try {
                int counter = 0;
                boolean b = true;
                while (true) {
                    for (int i = 0; i < strs.length - 1; i++) {
                        if (strs[i].charAt(counter) != strs[i + 1].charAt(counter)) {
                            return new String(result);
                        }
                    }
                    result.append(strs[0].charAt(counter));
                    counter++;
                }

            } finally {
                return new String(result);
            }


        }


    }

}
