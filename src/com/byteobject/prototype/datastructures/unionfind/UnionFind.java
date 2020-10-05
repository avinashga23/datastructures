package com.byteobject.prototype.datastructures.unionfind;

public interface UnionFind {

    void connect(int i, int j);

    boolean isConnected(int i, int j);

}
