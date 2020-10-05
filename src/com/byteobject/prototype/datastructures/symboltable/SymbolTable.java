package com.byteobject.prototype.datastructures.symboltable;

import java.security.Key;
import java.util.ArrayDeque;
import java.util.Queue;

public class SymbolTable<KEY extends Comparable<KEY>, VAL> {

    private Node root;

    public void put(KEY key, VAL value) {
        root = put(root, key, value);
    }

    public void delete(KEY key) {
        delete(root, key);
    }

    private Node delete(Node node, KEY key) {
        if (node == null)
            return null;
        if (node.key.compareTo(key) > 0) {
            node.left = delete(node.left, key);
        } else
            if (node.key.compareTo(key) < 0)
                node.right = delete(node.right, key);
            else {
                if (node.right == null)
                    return node.left;
                Node x = node;
                node = deleteMin(node);
                if (node != null) {
                    node.left = x.left;
                    node.right = x.right;
                }
            }

        return node;
    }

    public VAL get(KEY key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    private Node getNode(KEY key) {
        Node retVal = null;
        if (root == null)
            return null;
        Node node = root;

        while (node != null) {
            if (node.key.compareTo(key) > 0)
                node = node.left;
            else if (node.key.compareTo(key) < 0)
                node = node.right;
            else {
                retVal = node;
                break;
            }
        }

        return retVal;
    }

    public Iterable<KEY> keys() {
        Queue<KEY> queue = new ArrayDeque<>();
        inOrder(root, queue);
        return queue;
    }

    public void deleteMin() {
        deleteMin(root);
    }

    public VAL getMin() {
        if (root == null)
            return null;
        return getMin(root).value;
    }

    private Node deleteMin(Node x) {
        Node lastParent = x;
        Node last = x;
        while (last != null) {
            lastParent = last;
            last = last.left;
        }
        if (lastParent == root) {
            Node retVal = root;
            root = root.right;
            return retVal;
        }

        Node retVal = lastParent.left;
        lastParent.left = null;
        return retVal;
    }

    private Node getMin(Node x) {
        Node last = x;
        while (last.left != null)
            last = last.left;
        return last;
    }

    private void inOrder(Node x, Queue<KEY> keys) {
        if (x == null)
            return;
        inOrder(x.left, keys);
        keys.add(x.key);
        inOrder(x.right, keys);
    }

    private Node put(Node x, KEY key, VAL value) {
        if (x == null)
            return new Node(key, value);
        if (x.key.compareTo(key) > 0)
            x.left = put(x.left, key, value);
        else if (x.key.compareTo(key) < 0)
            x.right = put(x.right, key, value);
        else
            x.value = value;

        return x;
    }

    private class Node {
        KEY key;
        VAL value;
        Node left;
        Node right;

        Node(KEY key, VAL value) {
            this.key = key;
            this.value = value;
        }
    }

}
