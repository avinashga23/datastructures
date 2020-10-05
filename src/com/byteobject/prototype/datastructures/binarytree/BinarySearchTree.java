package com.byteobject.prototype.datastructures.binarytree;

public class BinarySearchTree<K extends Comparable<K>, V> {

    private Node<K, V> root;

    public void put(K key, V val) {
        root = put(root, key, val);
    }

    private Node<K, V> put(Node<K, V> node, K key, V val) {
        if (node == null) {
            return new Node<>(key, val);
        }
        int cmp = node.getKey().compareTo(key);
        if (cmp > 0)
            node.setLeft(put(node.getLeft(), key, val));
        else if (cmp < 0)
            node.setRight(put(node.getRight(), key, val));
        else
            node.setValue(val);
        return node;
    }

    public V get(K key) {
        var temp = root;
        V retVal = null;

        while (temp != null) {
            int cmp = temp.getKey().compareTo(key);
            if (cmp > 0) {
                temp = temp.getLeft();
            } else if (cmp < 0) {
                temp = temp.getRight();
            } else {
                retVal = temp.getValue();
                break;
            }
        }

        return retVal;
    }

    public V getMin(Node<K, V> rootNode) {
        var temp = rootNode;
        V minVal = temp.getValue();
        while (temp != null) {
            minVal = temp.getValue();
            temp = temp.getLeft();
        }

        return minVal;
    }

    public V getMax(Node<K, V> rootNode) {
        var temp = rootNode;
        V retVal = temp.getValue();
        while (temp != null) {
            retVal = temp.getValue();
            temp = temp.getRight();
        }

        return retVal;
    }

    public boolean contains(K key) {
        var temp = root;
        while (temp != null) {
            int cmp = temp.getKey().compareTo(key);
            if (cmp > 0) {
                temp = temp.getLeft();
            } else if (cmp < 0)
                temp = temp.getRight();
            else
                return true;
        }

        return false;
    }

    public boolean isBinarySearchTree(Node<K, V> rootNode) {
        if (rootNode == null)
            return true;

        boolean leftRetVal = true;
        boolean rightRetVal = true;

        var leftNode = rootNode.getLeft();
        var rightNode = rootNode.getRight();

        if (leftNode != null && rootNode.getLeft().getKey().compareTo(leftNode.getKey()) < 0)
            return false;
        else
            leftRetVal = isBinarySearchTree(leftNode);

        if (rightNode != null && rootNode.getRight().getKey().compareTo(rightNode.getKey()) > 0)
            return false;
        else
            rightRetVal = isBinarySearchTree(leftNode);

        return leftRetVal && rightRetVal;
    }

    public void delete(K key) {
        var temp = root;

        while (temp != null) {
            int cmp = temp.getKey().compareTo(key);
            if (cmp > 0) {
                temp = temp.getLeft();
            } else if (cmp < 0) {
                temp = temp.getRight();
            } else {
                temp.setValue(null);
                break;
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer, String> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.put(5, "five");
        binarySearchTree.put(3, "three");
        binarySearchTree.put(7, "seven");
        binarySearchTree.put(2, "two");
        binarySearchTree.put(4, "four");
        binarySearchTree.put(6, "six");
        binarySearchTree.put(9, "nine");
        binarySearchTree.put(1, "one");

        System.out.println(binarySearchTree.get(5));
        System.out.println(binarySearchTree.getMin(binarySearchTree.root));
        System.out.println(binarySearchTree.getMax(binarySearchTree.root));

        System.out.println(binarySearchTree.isBinarySearchTree(binarySearchTree.root));
        System.out.println(binarySearchTree.contains(5));
        System.out.println(binarySearchTree.contains(9));
        System.out.println(binarySearchTree.contains(11));

        binarySearchTree.delete(6);
        System.out.println(binarySearchTree.get(6));
        binarySearchTree.put(6, "SIXXX");
        System.out.println(binarySearchTree.get(6));

    }

}
