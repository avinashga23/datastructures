package com.byteobject.prototype.datastructures.hashmap;

public interface Map<K, V> {

    void put(K key, V val);

    V get(K key);

    boolean contains(K key);

}
