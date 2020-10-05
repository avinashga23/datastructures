package com.byteobject.prototype.leetcode;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] characters = s.chars().toArray();
        Set<Integer> visitedCharacters = new HashSet<>();
        Set<Integer> largestLengthSet = new HashSet<>();

        int sum = 0;
        for (int i = 0; i < characters.length; i++) {
            if (!visitedCharacters.contains(characters[i])) {
                visitedCharacters.add(characters[i]);
                sum++;
            }
            else{
                largestLengthSet.add(sum);
                visitedCharacters.clear();
                visitedCharacters.add(characters[i]);
                sum = 1;
            }
        }

        return largestLengthSet.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }).orElse(0);
    }

}
