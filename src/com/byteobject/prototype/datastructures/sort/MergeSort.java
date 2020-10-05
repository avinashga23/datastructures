package com.byteobject.prototype.datastructures.sort;

public class MergeSort {

    public static int[] sort(int[] arr) {
        if (arr.length > 1) {
            int[][] halves = halve(arr);
            int[] sorted1 = sort(halves[0]);
            int[] sorted2 = sort(halves[1]);
            return merge(sorted1, sorted2);
        }
        return arr;
    }

    private static int[][] halve(int[] arr) {
        int center = arr.length / 2;
        int[] firstHalf = new int[center];
        int[] secondHalf = new int[arr.length - center];
        for (int i = 0; i < center; i++)
            firstHalf[i] = arr[i];
        for (int i = 0; i < secondHalf.length; i++)
            secondHalf[i] = arr[center + i];
        int[][] halves = {firstHalf, secondHalf};

        return halves;
    }

    private static int[] merge(int[] arr1, int[] arr2) {
        int[] merged = new int[arr1.length + arr2.length];
        int lIndex = 0;
        int rIndex = 0;
        for (int i = 0; i < merged.length; i++) {
            if (lIndex < arr1.length && rIndex < arr2.length)
                if (arr1[lIndex] < arr2[rIndex])
                    merged[i] = arr1[lIndex++];
                else
                    merged[i] = arr2[rIndex++];
            else {
                if (lIndex >= arr1.length && rIndex < arr2.length)
                    merged[i] = arr2[rIndex++];
                if (rIndex >= arr2.length && lIndex < arr1.length)
                    merged[i] = arr1[lIndex++];
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        int[] arr = {5,6,7,8,1,2,3,4};
        int[] sorted = sort(arr);
        int i =0;
    }

}
