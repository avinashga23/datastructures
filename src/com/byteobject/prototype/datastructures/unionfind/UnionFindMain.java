package com.byteobject.prototype.datastructures.unionfind;

public class UnionFindMain {

    public static void main(String[] args) {
        UnionFind unionFind = new QuickFind(10);

        System.out.println(unionFind.isConnected(3, 5));
        unionFind.connect(0, 1);
        System.out.println(unionFind.isConnected(0, 1));
        unionFind.connect(1, 6);
        System.out.println(unionFind.isConnected(0, 6));
        unionFind.connect(3, 6);
        System.out.println(unionFind.isConnected(0, 3));
        unionFind.connect(9, 3);
        System.out.println(unionFind.isConnected(0, 9));
    }

}
