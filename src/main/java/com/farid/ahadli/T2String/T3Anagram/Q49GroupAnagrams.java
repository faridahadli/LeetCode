package com.farid.ahadli.T2String.T3Anagram;

import java.util.*;

public class Q49GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
           Map<Map<Character, Integer>, List<String>> anagramMap = new HashMap<>();

            Arrays.stream(strs).forEach(str->{
                Map<Character, Integer> myMap =  new HashMap<>();

                for(Character chr : str.toCharArray()){
                    int i = myMap.getOrDefault(chr, 0);
                    myMap.put( chr, ++i );
                }

                List<String> myList =  anagramMap.getOrDefault(myMap, new ArrayList<>());
                myList.add(str);
                anagramMap.put(myMap, myList);
            });

                   return new ArrayList<>(anagramMap.values());

        }
    }
}


/*
better solution would be
public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> map = new HashMap<>();

    for (String str : strs) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String key = new String(chars);

        map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
    }

    return new ArrayList<>(map.values());
}*/
