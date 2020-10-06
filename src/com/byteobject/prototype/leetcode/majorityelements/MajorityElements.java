package com.byteobject.prototype.leetcode.majorityelements;

import java.util.*;

public class MajorityElements {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,2}));
    }

    public static List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> elementMap = new HashMap<>();
        List<Integer> majority = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (elementMap.containsKey(nums[i])) {
                elementMap.put(nums[i], elementMap.get(nums[i]) + 1);
            } else {
                elementMap.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry: elementMap.entrySet()) {
            if (entry.getValue() > nums.length / 3)
                majority.add(entry.getKey());
        }

        return majority;
    }

}
