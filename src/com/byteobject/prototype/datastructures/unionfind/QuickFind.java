package com.byteobject.prototype.datastructures.unionfind;

public class QuickFind implements UnionFind{

    private final int[] arr;

    public QuickFind(int n) {
        this.arr = new int[n];
        for (int i = 0; i < n; i++)
            this.arr[i] = i;
    }

    @Override
    public void connect(int i, int j) {
        if (!isConnected(i, j)) {
            int jVal = arr[j];
            for (int index = 0; index < arr.length; index++) {
                if (arr[index] == jVal)
                    arr[index] = arr[i];
            }
        }
    }

    @Override
    public boolean isConnected(int i, int j) {
        return arr[i] == arr[j];
    }
}
